/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geotec;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 */
import entities.CSVUtils;
import entities.Municipio;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Geotec extends Application {

    private TableView<Municipio> tableView;
    private ObservableList<Municipio> municipios;
    private TextField txtBusca;

    @Override
    public void start(Stage primaryStage) {
        LoginApp loginApp = new LoginApp(this);
        loginApp.start(new Stage());
    }

    public void iniciarTelaPrincipal(Stage primaryStage) {
        primaryStage.setTitle("Gestão de Municípios");

        tableView = new TableView<>();
        municipios = FXCollections.observableArrayList();

        // Configurar a formatação de valores para Locale Brasileiro
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat numeroBR = NumberFormat.getNumberInstance(localeBR);
        numeroBR.setMinimumFractionDigits(2);
        numeroBR.setMaximumFractionDigits(2);

        StringConverter<Number> converter = new NumberStringConverter(numeroBR);

        Callback<TableColumn<Municipio, Double>, TableCell<Municipio, Double>> cellFactory = column -> new TableCell<Municipio, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item == 0.0) {
                    setText(null);
                } else {
                    setText(converter.toString(item));
                }
            }
        };

        // Configuração das colunas da tabela
        TableColumn<Municipio, String> colCodigoIBGE = new TableColumn<>("Código IBGE");
        colCodigoIBGE.setCellValueFactory(new PropertyValueFactory<>("codigoIBGE"));
        colCodigoIBGE.setSortable(true);

        TableColumn<Municipio, String> colNome = new TableColumn<>("Município");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNome.setSortable(true);

        TableColumn<Municipio, String> colMicrorregiao = new TableColumn<>("Microrregião");
        colMicrorregiao.setCellValueFactory(new PropertyValueFactory<>("microRegiao"));
        colMicrorregiao.setSortable(true);

        TableColumn<Municipio, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colEstado.setSortable(true);

        TableColumn<Municipio, String> colRegiaoGeografica = new TableColumn<>("Região Geográfica");
        colRegiaoGeografica.setCellValueFactory(new PropertyValueFactory<>("regiaoGeografica"));
        colRegiaoGeografica.setSortable(true);

        TableColumn<Municipio, Double> colAreaKm2 = new TableColumn<>("Área km²");
        colAreaKm2.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getAreaKm());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colAreaKm2.setSortable(true);
        colAreaKm2.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colPopulacao = new TableColumn<>("População");
        colPopulacao.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getPopulacao());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colPopulacao.setSortable(true);
        colPopulacao.setCellFactory(cellFactory);

        // Repita o processo para as outras colunas...
        TableColumn<Municipio, Double> colDomicilios = new TableColumn<>("Domicílios");
        colDomicilios.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getDomicilios());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colDomicilios.setSortable(true);
        colDomicilios.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colPibTotal = new TableColumn<>("PIB Total (R$ mil)");
        colPibTotal.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getPibTotal());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colPibTotal.setSortable(true);
        colPibTotal.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colRendaMedia = new TableColumn<>("Renda Média");
        colRendaMedia.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getRendaMedia());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colRendaMedia.setSortable(true);
        colRendaMedia.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colRendaNominal = new TableColumn<>("Renda Nominal");
        colRendaNominal.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getRendaNominal());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colRendaNominal.setSortable(true);
        colRendaNominal.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colPeaDia = new TableColumn<>("PEA Dia");
        colPeaDia.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getPeaDia());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colPeaDia.setSortable(true);
        colPeaDia.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colPibPerCapita = new TableColumn<>("PIB per Capita");
        colPibPerCapita.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getPIBPerCapitaTotal());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colPibPerCapita.setSortable(true);
        colPibPerCapita.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colIdhEducacao = new TableColumn<>("IDH Educação");
        colIdhEducacao.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getIdhEducacao());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colIdhEducacao.setSortable(true);
        colIdhEducacao.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colIdhLongevidade = new TableColumn<>("IDH Longevidade");
        colIdhLongevidade.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getIdhLongevidade());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colIdhLongevidade.setSortable(true);
        colIdhLongevidade.setCellFactory(cellFactory);

        TableColumn<Municipio, Double> colIdh = new TableColumn<>("IDH");
        colIdh.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getIdh());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colIdh.setSortable(true);
        colIdh.setCellFactory(cellFactory);

        TableColumn<Municipio, String> colClassificacaoIDH = new TableColumn<>("C IDH");
        colClassificacaoIDH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDH()));
        colClassificacaoIDH.setSortable(true);

        TableColumn<Municipio, String> colClassificacaoIDHLongevidade = new TableColumn<>("C IDH Longevidade");
        colClassificacaoIDHLongevidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDHLongevidade()));
        colClassificacaoIDHLongevidade.setSortable(true);

        TableColumn<Municipio, String> colClassificacaoIDHEducacao = new TableColumn<>("C IDH Educação");
        colClassificacaoIDHEducacao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDHEducacao()));
        colClassificacaoIDHEducacao.setSortable(true);

        TableColumn<Municipio, Double> colDensidadeDemografica = new TableColumn<>("Densidade Demográfica");
        colDensidadeDemografica.setCellValueFactory(cellData -> {
            Double value = parseDouble(cellData.getValue().getDensidadeDemografica());
            return value != 0.0 ? new SimpleDoubleProperty(value).asObject() : null;
        });
        colDensidadeDemografica.setSortable(true);
        colDensidadeDemografica.setCellFactory(cellFactory);

        TableColumn<Municipio, String> colDataUltimaAtualizacao = new TableColumn<>("Data Última Atualização");
        colDataUltimaAtualizacao.setCellValueFactory(new PropertyValueFactory<>("dataUltimaAtualizacao"));
        colDataUltimaAtualizacao.setSortable(true);

        tableView.getColumns().addAll(
                colCodigoIBGE, colNome, colMicrorregiao, colEstado, colRegiaoGeografica,
                colAreaKm2, colPopulacao, colDomicilios, colPibTotal, colRendaMedia,
                colRendaNominal, colPeaDia, colPibPerCapita, colDensidadeDemografica,
                colIdh, colClassificacaoIDH, colIdhLongevidade, colClassificacaoIDHLongevidade,
                colIdhEducacao, colClassificacaoIDHEducacao, colDataUltimaAtualizacao
        );

        // Configurar a ordenação para a tabela
        SortedList<Municipio> sortedData = new SortedList<>(municipios);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);

        // Botão Importar Dados
        Button btnImportar = new Button("Importar");
        btnImportar.setOnAction(e -> importarDados(primaryStage));

        // Botão Exportar Dados
        Button btnExportar = new Button("Exportar");
        btnExportar.setOnAction(e -> exportarDados(primaryStage));

        // Campo de Busca
        txtBusca = new TextField();
        txtBusca.setPromptText("Digite o nome ou código IBGE do município");

        txtBusca.textProperty().addListener((observable, oldValue, newValue) -> {
            // Defina os caracteres proibidos em uma expressão regular
            String caracteresProibidos = "[#@!$%&*()¨;:<>|/?+_-]";

            // Verifique se o novo valor contém qualquer um dos caracteres proibidos
            if (newValue.matches(".*" + caracteresProibidos + ".*")) {
                txtBusca.setText(oldValue);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Entrada Inválida");
                alert.setHeaderText(null);
                alert.setContentText("Caracteres proibidos: #, @, !, $, %, &, *, ( , ) , < , > , | , ? , = , + , - e _   não são permitidos.");
                alert.showAndWait();
            }
        });

        // Botão Buscar
        Button btnBuscar = new Button("Buscar");
        btnBuscar.setOnAction(e -> buscarMunicipio());

        // Botão Atualizar Tabela
        Button btnAtualizarTabela = new Button("Atualizar");
        btnAtualizarTabela.setOnAction(e -> tableView.refresh());

        // Botão Atualizar Registro
        Button btnAtualizar = new Button("Atualizar Registro");
        btnAtualizar.setOnAction(e -> abrirInterfaceAtualizacao(primaryStage));

        // Botão Deletar
        Button btnDeletar = new Button("Deletar");
        btnDeletar.setOnAction(e -> abrirInterfaceDelecao(primaryStage));

        // Layout da barra de busca e botões
        HBox hBoxBusca = new HBox(txtBusca, btnBuscar, btnAtualizarTabela, btnAtualizar, btnDeletar);
        hBoxBusca.setSpacing(10);

        // Botões Importar e Exportar à direita
        HBox hBoxTop = new HBox(hBoxBusca, btnImportar, btnExportar);
        hBoxTop.setSpacing(10);
        HBox.setHgrow(hBoxBusca, Priority.ALWAYS);

        // Configuração da tela principal
        VBox vbox = new VBox(hBoxTop, tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();

        // Expande as colunas para preencher a tabela
        for (TableColumn<?, ?> column : tableView.getColumns()) {
            column.prefWidthProperty().bind(tableView.widthProperty().multiply(1.0 / tableView.getColumns().size()));
        }
    }

    private void importarDados(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            List<Municipio> lista = CSVUtils.lerCSV(selectedFile.getAbsolutePath());
            municipios.setAll(lista);
            tableView.setItems(municipios);
        }
    }

    private void exportarDados(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile != null) {
            CSVUtils.escreverCSV(municipios, selectedFile.getAbsolutePath());
        }
    }

    private void buscarMunicipio() {
        String busca = removerAcentos(txtBusca.getText().trim().toLowerCase());
        ObservableList<Municipio> resultadoBusca = FXCollections.observableArrayList();

        for (Municipio municipio : municipios) {
            if (removerAcentos(municipio.getNome().toLowerCase()).contains(busca)
                    || removerAcentos(municipio.getCodigoIBGE().toLowerCase()).contains(busca)) {
                resultadoBusca.add(municipio);
            }
        }

        tableView.setItems(resultadoBusca);
    }

    private void abrirInterfaceAtualizacao(Stage primaryStage) {
        Stage atualizacaoStage = new Stage();
        AtualizacaoRegistrosApp atualizacaoApp = new AtualizacaoRegistrosApp(municipios);
        atualizacaoApp.start(atualizacaoStage);
        atualizacaoStage.show();
    }

    private void abrirInterfaceDelecao(Stage primaryStage) {
        Stage delecaoStage = new Stage();
        DelecaoMunicipioApp delecaoApp = new DelecaoMunicipioApp(municipios);
        delecaoApp.start(delecaoStage);
        delecaoStage.show();
    }

    private String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    private double parseDouble(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }
        try {
            // Remove pontos de separação de milhar e substitui vírgula por ponto decimal
            return Double.parseDouble(value.replace(".", "").replace(",", "."));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
