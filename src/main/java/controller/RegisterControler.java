package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;
public class RegisterControler {
    @FXML
    private Label ErrorCorreo;
    @FXML
    private TextField NombreUsuarioReg;

    @FXML
    private TextField CorreoElectronicoReg;

    @FXML
    private PasswordField PassReg;


    @FXML
    private void GoLoginButtonPress(ActionEvent event) {
        try {
            // Carga el archivo FXML para la vista de login
            Parent loginView = FXMLLoader.load(getClass().getResource("/com/example/view/Login.fxml"));


            Stage stage = (Stage) NombreUsuarioReg.getScene().getWindow();
            stage.setMaximized(true);
            // Establece la nueva escena en el stage actual. Ajusta el tamaño según necesites
            stage.setScene(new Scene(loginView, 1200, 800)); // Ajusta el tamaño según sea necesario para tu aplicación
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Maneja la excepción como consideres necesario. Por ejemplo, mostrando un mensaje de error.
        }
    }

    // Este método se llamará cuando se presione el botón "Registrarse"
    @FXML
    private void RegisterButtonPress(ActionEvent event) {
        String username = NombreUsuarioReg.getText();
        String email = CorreoElectronicoReg.getText();
        String password = PassReg.getText();

        // Validar el correo electrónico
        if (isValidEmail(email)) {
            // El correo es válido, proceder con el registro
            ErrorCorreo.setText("Registro exitoso. Por favor, inicia sesión.");
        } else {
            // El correo no es válido
            ErrorCorreo.setText("El correo electrónico no es válido.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailRegex);
    }
}

