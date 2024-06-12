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

import entities.Municipio;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AtualizacaoRegistrosApp extends Application {

    private ObservableList<Municipio> municipios;
    private Municipio municipioSelecionado;

    private TextField txtCodigoIBGE;
    private TextField txtNome;
    private TextField txtPopulacao;
    private TextField txtDomicilios;
    private TextField txtPibTotal;
    private TextField txtIdh;
    private TextField txtRendaMedia;
    private TextField txtRendaNominal;
    private TextField txtPeaDia;
    private TextField txtIdhEducacao;
    private TextField txtIdhLongevidade;

    private ComboBox<String> cmbMunicipios;

    public AtualizacaoRegistrosApp(ObservableList<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atualização de Registros");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label lblMunicipio = new Label("Selecionar Município:");
        cmbMunicipios = new ComboBox<>();
        cmbMunicipios.setPromptText("Selecione um município...");
        cmbMunicipios.getItems().addAll(municipios.stream().map(Municipio::getNome).collect(Collectors.toList()));
        cmbMunicipios.setOnAction(e -> {
            String selectedMunicipioName = cmbMunicipios.getSelectionModel().getSelectedItem();
            municipioSelecionado = municipios.stream().filter(m -> m.getNome().equals(selectedMunicipioName)).findFirst().orElse(null);
            exibirDetalhesMunicipio();
        });

        Label lblCodigoIBGE = new Label("Código IBGE:");
        txtCodigoIBGE = new TextField();
        txtCodigoIBGE.setDisable(true);

        Label lblNome = new Label("Município:");
        txtNome = new TextField();
        txtNome.setDisable(true);

        Label lblPopulacao = new Label("População:");
        txtPopulacao = new TextField();

        Label lblDomicilios = new Label("Domicílios:");
        txtDomicilios = new TextField();

        Label lblPibTotal = new Label("PIB Total (R$ mil):");
        txtPibTotal = new TextField();

        Label lblIdh = new Label("IDH:");
        txtIdh = new TextField();

        Label lblRendaMedia = new Label("Renda Média:");
        txtRendaMedia = new TextField();

        Label lblRendaNominal = new Label("Renda Nominal:");
        txtRendaNominal = new TextField();

        Label lblPeaDia = new Label("PEA Dia:");
        txtPeaDia = new TextField();

        Label lblIdhEducacao = new Label("IDH Educação:");
        txtIdhEducacao = new TextField();

        Label lblIdhLongevidade = new Label("IDH Longevidade:");
        txtIdhLongevidade = new TextField();

        Button btnAtualizar = new Button("Atualizar");
        btnAtualizar.setOnAction(e -> atualizarRegistro(txtPopulacao.getText(), txtDomicilios.getText(), txtPibTotal.getText(),
                txtIdh.getText(), txtRendaMedia.getText(), txtRendaNominal.getText(), txtPeaDia.getText(),
                txtIdhEducacao.getText(), txtIdhLongevidade.getText()));

        Button btnSalvarSair = new Button("Salvar e Sair");
        btnSalvarSair.setOnAction(e -> {
            atualizarRegistro(txtPopulacao.getText(), txtDomicilios.getText(), txtPibTotal.getText(),
                    txtIdh.getText(), txtRendaMedia.getText(), txtRendaNominal.getText(), txtPeaDia.getText(),
                    txtIdhEducacao.getText(), txtIdhLongevidade.getText());
            primaryStage.close();
        });

        HBox buttonsBox = new HBox(btnAtualizar, btnSalvarSair);
        buttonsBox.setSpacing(10);

        VBox vbox = new VBox(lblMunicipio, cmbMunicipios, lblCodigoIBGE, txtCodigoIBGE, lblNome, txtNome, lblPopulacao, txtPopulacao, lblDomicilios,
                txtDomicilios, lblPibTotal, txtPibTotal, lblIdh, txtIdh, lblRendaMedia, txtRendaMedia, lblRendaNominal,
                txtRendaNominal, lblPeaDia, txtPeaDia, lblIdhEducacao, txtIdhEducacao, lblIdhLongevidade, txtIdhLongevidade,
                buttonsBox);
        vbox.setSpacing(10);

        grid.getChildren().addAll(vbox);

        Scene scene = new Scene(grid, 400, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void exibirDetalhesMunicipio() {
        if (municipioSelecionado != null) {
            txtCodigoIBGE.setText(municipioSelecionado.getCodigoIBGE());
            txtNome.setText(municipioSelecionado.getNome());
            txtPopulacao.setText(municipioSelecionado.getPopulacao());
            txtDomicilios.setText(municipioSelecionado.getDomicilios());
            txtPibTotal.setText(municipioSelecionado.getPibTotal());
            txtIdh.setText(municipioSelecionado.getIdh());
            txtRendaMedia.setText(municipioSelecionado.getRendaMedia());
            txtRendaNominal.setText(municipioSelecionado.getRendaNominal());
            txtPeaDia.setText(municipioSelecionado.getPeaDia());
            txtIdhEducacao.setText(municipioSelecionado.getIdhEducacao());
            txtIdhLongevidade.setText(municipioSelecionado.getIdhLongevidade());
        }
    }

    private List<String> validarCampos(String populacao, String domicilios, String pibTotal, String idh,
            String rendaMedia, String rendaNominal, String peaDia,
            String idhEducacao, String idhLongevidade) {
        List<String> erros = new ArrayList<>();

        // Verificar se campos obrigatórios estão vazios
        if (populacao.isEmpty()) {
            erros.add("O campo 'População' é obrigatório.");
        } else {
            try {
                double populacaoDouble = Double.parseDouble(populacao.replace(".", "").replace(",", "."));
                if (populacaoDouble <= 0 || populacaoDouble > 7_900_000_000L) {
                    erros.add("O campo 'População' deve ser um número entre 1 e 7.900.000.000.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'População' deve conter apenas números.");
            }
        }
        if (domicilios.isEmpty()) {
            erros.add("O campo 'Domicílios' é obrigatório.");
        } else {
            // Verificar se o número de domicílios é um número válido e está dentro do limite
            try {
                double domiciliosDouble = Double.parseDouble(domicilios.replace(".", "").replace(",", "."));
                if (domiciliosDouble <= 0 || domiciliosDouble > 12000) {
                    erros.add("O campo 'Domicílios' deve ser um número entre 1 e 12.000.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'Domicílios' deve conter apenas números.");
            }

        }
        if (pibTotal.isEmpty()) {
            erros.add("O campo 'PIB Total' é obrigatório.");
        } else {
            try {
                double pibTotalDouble = Double.parseDouble(pibTotal.replace(".", "").replace(",", "."));
                double limitePib = 1200000.00; // Limite máximo de PIB Total
                if (pibTotalDouble > limitePib) {
                    erros.add("O campo 'PIB Total' deve ser no máximo R$ 1.200.000,00.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'PIB Total' deve conter apenas números.");
            }

        }
        if (idh.isEmpty()) {
            erros.add("O campo 'IDH' é obrigatório.");
        } else {
            // Verificar se o IDH é um número válido e está dentro do limite
            try {
                double idhDouble = Double.parseDouble(idh.replace(".", "").replace(",", "."));
                if (idhDouble < 0 || idhDouble > 1) {
                    erros.add("O campo 'IDH' deve ser um número entre 0 e 1.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'IDH' deve conter apenas números.");
            }
        }
        if (rendaMedia.isEmpty()) {
            erros.add("O campo 'Renda Média' é obrigatório.");
        } else {
            // Verificar se a Renda Média é um número válido e está dentro do limite
            try {
                double rendaMediaDouble = Double.parseDouble(rendaMedia.replace(".", "").replace(",", "."));
                double limiteRendaMedia = 6840.00; // Limite máximo da Renda Média (20% a mais que 5700.00)
                if (rendaMediaDouble > limiteRendaMedia) {
                    erros.add("O campo 'Renda Média' deve ser no máximo R$ 6.840,00.");
                }
                if (rendaMediaDouble < 0) {
                    erros.add("O campo 'Renda Média' não pode ser negativo.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'Renda Média' deve conter apenas números.");
            }
        }
        if (rendaNominal.isEmpty()) {
            erros.add("O campo 'Renda Nominal' é obrigatório.");
        } else {
            // Verificar se a Renda Nominal é um número válido e está dentro do limite
            try {
                double rendaNominalDouble = Double.parseDouble(rendaNominal.replace(".", "").replace(",", "."));
                double limiteRendaNominal = 108960000.00; // 90.800.000,00 + 20%
                if (rendaNominalDouble > limiteRendaNominal) {
                    erros.add("O campo 'Renda Nominal' deve ser no máximo R$ 108.960.000,00.");
                }
                if (rendaNominalDouble < 0) {
                    erros.add("O campo 'Renda Nominal' deve ser no mínimo R$ 0,00.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'Renda Nominal' deve conter apenas números.");
            }
        }
        if (peaDia.isEmpty()) {
            erros.add("O campo 'PEA Dia' é obrigatório.");
        } else {
            try {
                double peaDiaDouble = Double.parseDouble(peaDia.replace(".", "").replace(",", "."));
                double maxPeaDia = 80000 * 1.2; // 20% a mais de 80.000,00
                if (peaDiaDouble > maxPeaDia) {
                    erros.add("O campo 'PEA Dia' deve ser no máximo 20% a mais de 80.000,00.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'PEA Dia' deve conter apenas números.");
            }
        }
        if (idhEducacao.isEmpty()) {
            erros.add("O campo 'IDH Educação' é obrigatório.");
        } else {
            try {
                double idhEducacaoDouble = Double.parseDouble(idhEducacao.replace(".", "").replace(",", "."));
                if (idhEducacaoDouble < 0 || idhEducacaoDouble > 1) {
                    erros.add("O campo 'IDH Educação' deve ser um número entre 0 e 1.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'IDH Educação' deve conter apenas números.");
            }
        }
        if (idhLongevidade.isEmpty()) {
            erros.add("O campo 'IDH Longevidade' é obrigatório.");
        } else {
            try {
                double idhLongevidadeDouble = Double.parseDouble(idhLongevidade.replace(".", "").replace(",", "."));
                if (idhLongevidadeDouble < 0 || idhLongevidadeDouble > 1) {
                    erros.add("O campo 'IDH Longevidade' deve ser um número entre 0 e 1.");
                }
            } catch (NumberFormatException e) {
                erros.add("O campo 'IDH Longevidade' deve conter apenas números.");
            }
        }

        // Verificar se campos numéricos contêm apenas números, pontos e vírgulas
        if (!populacao.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'População' deve conter apenas números no formato 1.000,00.");
        }
        if (!domicilios.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,})?")) {
            erros.add("O campo 'Domicílios' deve conter apenas números no formato 1.000,00.");
        }
        if (!pibTotal.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'PIB Total' deve conter apenas números no formato 1.000,00.");
        }
        if (!rendaMedia.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'Renda Média' deve conter apenas números no formato 1.000,00.");
        }
        if (!rendaNominal.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'Renda Nominal' deve conter apenas números no formato 1.000,00.");
        }
        if (!peaDia.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'PEA Dia' deve conter apenas números no formato 1.000,00.");
        }
        if (!idh.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'IDH' deve conter apenas números no formato Ex:(1.000,00).");
        }
        if (!idhEducacao.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'IDH Educação' deve conter apenas números no formato 1.000,00.");
        }
        if (!idhLongevidade.matches("\\d{1,3}(\\.\\d{3})*(,\\d{1,5})?")) {
            erros.add("O campo 'IDH Longevidade' deve conter apenas números no formato 1.000,00.");
        }

        return erros;
    }

    private void atualizarRegistro(String populacao, String domicilios, String pibTotal, String idh,
            String rendaMedia, String rendaNominal, String peaDia,
            String idhEducacao, String idhLongevidade) {

        if (municipioSelecionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText("Nenhum Município Selecionado");
            alert.setContentText("Por favor, selecione um município antes de tentar atualizar.");
            alert.showAndWait();
            return;
        }

        List<String> erros = validarCampos(populacao, domicilios, pibTotal, idh, rendaMedia, rendaNominal, peaDia, idhEducacao, idhLongevidade);
        if (!erros.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Validação");
            alert.setHeaderText("Por favor, corrija os seguintes erros:");
            alert.setContentText(String.join("\n", erros));
            alert.showAndWait();
            return;
        }

        municipioSelecionado.setPopulacao(populacao);
        municipioSelecionado.setDomicilios(domicilios);
        municipioSelecionado.setPibTotal(pibTotal);
        municipioSelecionado.setIdh(idh);
        municipioSelecionado.setRendaMedia(rendaMedia);
        municipioSelecionado.setRendaNominal(rendaNominal);
        municipioSelecionado.setPeaDia(peaDia);
        municipioSelecionado.setIdhEducacao(idhEducacao);
        municipioSelecionado.setIdhLongevidade(idhLongevidade);

        // Registra a data da última atualização
        LocalDateTime dataAtualizacao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataAtualizacao.format(formatter);
        municipioSelecionado.setDataUltimaAtualizacao(dataFormatada);

        // Atualiza a exibição dos detalhes do município na interface
        exibirDetalhesMunicipio();
    }
}
