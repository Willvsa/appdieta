package com.example.controller;

import com.example.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.IOException;


public class LoginControler {
    private UserService userService = new UserService();
    @FXML
    private TextField UserNameLog;
    @FXML
    private Label ErrorLogin;
    @FXML
    private PasswordField PassLog;

    //Evento Onclic Inicio de sesion
    @FXML
    private void LogginButtonPress(ActionEvent event) {
        // Obtén el nombre de usuario y la contraseña desde los campos de entrada.
        String username = UserNameLog.getText();
        String rawPassword = PassLog.getText();

        // Implementa la lógica de autenticación aquí.
        // Por ejemplo, suponiendo que tienes una clase UserService con un método authenticate:
        boolean authenticationResult = userService.authenticate(username, rawPassword); // Asegúrate de haber inicializado userService

        System.out.println("Resultado de autenticación: " + authenticationResult);

        if (authenticationResult) {
            try {
                // Cargar la vista de la página principal
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/view/PaginaPrincipal.fxml")); // Asegúrate de tener la ruta correcta
                Parent paginaPrincipalParent = loader.load();

                // Obtener el Stage actual (la ventana actual)
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Establecer la escena para el Stage con la vista de la página principal
                Scene paginaPrincipalScene = new Scene(paginaPrincipalParent);
                stage.setScene(paginaPrincipalScene);

                // Mostrar la ventana
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                // Manejar la excepción, por ejemplo, mostrar un diálogo de error.
            }
        } else {
            ErrorLogin.setText("Error en el inicio de sesion, corrige el usuario o la contraseña y vuelve a intentarlo.");
        }
    }


    //Evento Onclick cambiar a pestaña de inicio de sesion
    @FXML
    private void GoRegisterButtonPress(ActionEvent event) {
        try {
            // Carga el FXML de la ventana de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/Register.fxml"));
            Parent registerView = loader.load();

            // Obtiene la ventana actual y establece la nueva escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(registerView, 1200, 800));
            stage.setMaximized(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            // Aquí podrías manejar el error, por ejemplo, mostrando un mensaje al usuario
        }
    }

}