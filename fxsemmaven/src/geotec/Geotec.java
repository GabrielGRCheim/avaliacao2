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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import java.text.Normalizer;
import java.util.List;

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

        // Configuração das colunas da tabela
        TableColumn<Municipio, String> colCodigoIBGE = new TableColumn<>("Código IBGE");
        colCodigoIBGE.setCellValueFactory(new PropertyValueFactory<>("codigoIBGE"));

        TableColumn<Municipio, String> colNome = new TableColumn<>("Município");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Municipio, String> colMicrorregiao = new TableColumn<>("Microrregião");
        colMicrorregiao.setCellValueFactory(new PropertyValueFactory<>("microRegiao"));

        TableColumn<Municipio, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        TableColumn<Municipio, String> colRegiaoGeografica = new TableColumn<>("Região Geográfica");
        colRegiaoGeografica.setCellValueFactory(new PropertyValueFactory<>("regiaoGeografica"));

        TableColumn<Municipio, String> colAreaKm2 = new TableColumn<>("Área km²");
        colAreaKm2.setCellValueFactory(new PropertyValueFactory<>("areaKm"));

        TableColumn<Municipio, String> colPopulacao = new TableColumn<>("População");
        colPopulacao.setCellValueFactory(new PropertyValueFactory<>("populacao"));

        TableColumn<Municipio, String> colDomicilios = new TableColumn<>("Domicílios");
        colDomicilios.setCellValueFactory(new PropertyValueFactory<>("domicilios"));

        TableColumn<Municipio, String> colPibTotal = new TableColumn<>("PIB Total (R$ mil)");
        colPibTotal.setCellValueFactory(new PropertyValueFactory<>("pibTotal"));

        TableColumn<Municipio, String> colRendaMedia = new TableColumn<>("Renda Média");
        colRendaMedia.setCellValueFactory(new PropertyValueFactory<>("rendaMedia"));

        TableColumn<Municipio, String> colRendaNominal = new TableColumn<>("Renda Nominal");
        colRendaNominal.setCellValueFactory(new PropertyValueFactory<>("rendaNominal"));

        TableColumn<Municipio, String> colPeaDia = new TableColumn<>("PEA Dia");
        colPeaDia.setCellValueFactory(new PropertyValueFactory<>("peaDia"));

        TableColumn<Municipio, String> colIdhEducacao = new TableColumn<>("IDH Educação");
        colIdhEducacao.setCellValueFactory(new PropertyValueFactory<>("idhEducacao"));

        TableColumn<Municipio, String> colIdhLongevidade = new TableColumn<>("IDH Longevidade");
        colIdhLongevidade.setCellValueFactory(new PropertyValueFactory<>("idhLongevidade"));

        TableColumn<Municipio, String> colIdh = new TableColumn<>("IDH");
        colIdh.setCellValueFactory(new PropertyValueFactory<>("idh"));

        TableColumn<Municipio, String> colClassificacaoIDH = new TableColumn<>("C IDH");
        colClassificacaoIDH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDH()));

        TableColumn<Municipio, String> colClassificacaoIDHLongevidade = new TableColumn<>("C IDH Longevidade");
        colClassificacaoIDHLongevidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDHLongevidade()));

        TableColumn<Municipio, String> colClassificacaoIDHEducacao = new TableColumn<>("C IDH Educação");
        colClassificacaoIDHEducacao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().classificarIDHEducacao()));

        TableColumn<Municipio, String> colDataUltimaAtualizacao = new TableColumn<>("Data Última Atualização");
        colDataUltimaAtualizacao.setCellValueFactory(new PropertyValueFactory<>("dataUltimaAtualizacao"));

        tableView.getColumns().addAll(
                colCodigoIBGE, colNome, colMicrorregiao, colEstado, colRegiaoGeografica,
                colAreaKm2, colPopulacao, colDomicilios, colPibTotal, colIdh, colRendaMedia,
                colRendaNominal, colPeaDia, colIdhEducacao, colIdhLongevidade,
                colClassificacaoIDH, colClassificacaoIDHLongevidade, colClassificacaoIDHEducacao,
                colDataUltimaAtualizacao
        );

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
            if (removerAcentos(municipio.getNome().toLowerCase()).contains(busca) ||
                removerAcentos(municipio.getCodigoIBGE().toLowerCase()).contains(busca)) {
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

    public static void main(String[] args) {
        launch(args);
    }
}
