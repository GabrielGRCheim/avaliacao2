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
import entities.Municipio;
import static entities.Municipio.limparMunicipio;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.stream.Collectors;

public class DelecaoMunicipioApp extends Application {

    private ObservableList<Municipio> municipios;
    private Municipio municipioSelecionado;
    private ComboBox<String> cmbMunicipios;

    public DelecaoMunicipioApp(ObservableList<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Deletar Município");

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        Label lblMunicipio = new Label("Selecionar Município:");
        cmbMunicipios = new ComboBox<>();
        cmbMunicipios.setPromptText("Selecione um município...");
        cmbMunicipios.getItems().addAll(municipios.stream().map(Municipio::getNome).collect(Collectors.toList()));
        cmbMunicipios.setOnAction(e -> {
            String selectedMunicipioName = cmbMunicipios.getSelectionModel().getSelectedItem();
            municipioSelecionado = municipios.stream().filter(m -> m.getNome().equals(selectedMunicipioName)).findFirst().orElse(null);
            System.out.println("Município selecionado: " + (municipioSelecionado != null ? municipioSelecionado.getNome() : "nenhum"));
        });

        Button btnSim = new Button("Sim");
        btnSim.setOnAction(e -> confirmarDelecao(primaryStage));

        Button btnSair = new Button("Sair");
        btnSair.setOnAction(e -> primaryStage.close());

        vbox.getChildren().addAll(lblMunicipio, cmbMunicipios, btnSim, btnSair);

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void confirmarDelecao(Stage primaryStage) {
        if (municipioSelecionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um município para deletar.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar Deleção");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Tem certeza que deseja deletar as informações do município " + municipioSelecionado.getNome() + "?");

        ButtonType buttonTypeSim = new ButtonType("Sim");
        ButtonType buttonTypeNao = new ButtonType("Não");
        confirmAlert.getButtonTypes().setAll(buttonTypeSim, buttonTypeNao);

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeSim) {
                limparMunicipio(municipioSelecionado);
                primaryStage.close();
            }
        });
    }
}
