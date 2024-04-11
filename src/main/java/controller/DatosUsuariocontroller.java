package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DatosUsuariocontroller {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField pesoField;

    @FXML
    private TextField alturaField;

    @FXML
    private void guardarDatos() {
        // Aquí puedes obtener los datos ingresados por el usuario y realizar alguna acción, como guardarlos en una base de datos o mostrarlos en la consola.
        String nombre = nombreField.getText();
        double peso = Double.parseDouble(pesoField.getText());
        double altura = Double.parseDouble(alturaField.getText());

        // Por ejemplo, aquí simplemente los mostramos en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
    }
}
