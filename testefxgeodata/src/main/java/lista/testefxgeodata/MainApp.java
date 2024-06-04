package lista.testefxgeodata;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainApp extends Application {
    private String classificarIDH(double idh) {
        if (idh > 0.80) {
            return "Muito alto";
        } else if (idh >= 0.70) {
            return "Alto";
        } else if (idh >= 0.55) {
            return "Médio";
        } else {
            return "Baixo";
        }
    }

    private double calcularDensidadeDemografica(int populacao, double areaKm2) {
        return (double) populacao / areaKm2;
    }

    private TableView<Municipio> tableView;
    private ObservableList<Municipio> municipios;
    private TextField txtBusca;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestão de Municípios");

        tableView = new TableView<>();
        municipios = FXCollections.observableArrayList();

        TableColumn<Municipio, String> colCodigoIBGE = new TableColumn<>("Código IBGE");
        colCodigoIBGE.setCellValueFactory(new PropertyValueFactory<>("codigoIBGE"));

        TableColumn<Municipio, String> colNome = new TableColumn<>("Municípios");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Municipio, String> colMicrorregiao = new TableColumn<>("Microrregião");
        colMicrorregiao.setCellValueFactory(new PropertyValueFactory<>("microrregiao"));

        TableColumn<Municipio, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        TableColumn<Municipio, String> colRegiaoGeografica = new TableColumn<>("Região Geográfica");
        colRegiaoGeografica.setCellValueFactory(new PropertyValueFactory<>("regiaoGeografica"));

        TableColumn<Municipio, Double> colAreaKm2 = new TableColumn<>("Área km2");
        colAreaKm2.setCellValueFactory(new PropertyValueFactory<>("areaKm2"));

        TableColumn<Municipio, Integer> colPopulacao = new TableColumn<>("População");
        colPopulacao.setCellValueFactory(new PropertyValueFactory<>("populacao"));

        // Definindo colunas para os cálculos de IDH e densidade demográfica
        TableColumn<Municipio, String> colClassificacaoIDH = new TableColumn<>("Classificação IDH");
        colClassificacaoIDH.setCellValueFactory(cellData -> {
            double idh = cellData.getValue().getIdh();
            return new SimpleStringProperty(classificarIDH(idh));
        });

        TableColumn<Municipio, Double> colDensidadeDemografica = new TableColumn<>("Densidade Demográfica");
        colDensidadeDemografica.setCellValueFactory(cellData -> {
            int populacao = cellData.getValue().getPopulacao();
            double areaKm2 = cellData.getValue().getAreaKm2();
            return new SimpleDoubleProperty(calcularDensidadeDemografica(populacao, areaKm2)).asObject();
        });

        tableView.getColumns().addAll(colCodigoIBGE, colNome, colMicrorregiao, colEstado, colRegiaoGeografica, colAreaKm2, colPopulacao, colClassificacaoIDH, colDensidadeDemografica);

        Button btnCarregar = new Button("Carregar Dados");
        btnCarregar.setOnAction(e -> carregarDados());

        txtBusca = new TextField();
        txtBusca.setPromptText("Digite o nome ou código IBGE do município");

        Button btnBuscar = new Button("Buscar");
        btnBuscar.setOnAction(e -> buscarMunicipio());

        HBox hBoxBusca = new HBox(txtBusca, btnBuscar);
        hBoxBusca.setSpacing(10);

        VBox vbox = new VBox(btnCarregar, hBoxBusca, tableView);
        Scene scene = new Scene(vbox, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void carregarDados() {
        List<Municipio> lista = CSVUtils.lerCSV("C:\\ProjetoIntegrador\\Entrada\\CSV.csv");
        municipios.setAll(lista);
        tableView.setItems(municipios);
    }

    private void buscarMunicipio() {
        String busca = txtBusca.getText().toLowerCase();
        ObservableList<Municipio> resultadoBusca = FXCollections.observableArrayList();

        for (Municipio municipio : municipios) {
            if (municipio.getNome().toLowerCase().contains(busca) || municipio.getCodigoIBGE().toLowerCase().contains(busca)) {
                resultadoBusca.add(municipio);
            }
        }

        tableView.setItems(resultadoBusca);
    }

    public static void main(String[] args) {
        launch(args);
    }
}