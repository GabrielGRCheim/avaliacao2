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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

    private static final String USUARIO_CORRETO = "IBGE550234";
    private static final String SENHA_CORRETA = "IBGE1234";
    private int tentativasRestantes = 3;

    private Geotec mainApp;

    public LoginApp(Geotec mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void start(Stage loginStage) {
        loginStage.setTitle("Login");

        VBox vbox = new VBox();
        vbox.setSpacing(10);

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuário");

        PasswordField txtSenha = new PasswordField();
        txtSenha.setPromptText("Senha");

        Label lblMensagem = new Label();

        Button btnEntrar = new Button("Entrar");
        btnEntrar.setOnAction(e -> {
            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();

            if (USUARIO_CORRETO.equals(usuario) && SENHA_CORRETA.equals(senha)) {
                loginStage.close();
                mainApp.iniciarTelaPrincipal(new Stage());
            } else {
                tentativasRestantes--;
                if (tentativasRestantes > 0) {
                    lblMensagem.setText("Usuário ou senha incorretos. Tentativas restantes: " + tentativasRestantes);
                } else {
                    lblMensagem.setText("Número de tentativas excedido. O programa será fechado.");
                    loginStage.close();
                    System.exit(0);
                }
            }
        });

        vbox.getChildren().addAll(txtUsuario, txtSenha, btnEntrar, lblMensagem);

        Scene scene = new Scene(vbox, 300, 200);
        loginStage.setScene(scene);
        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
