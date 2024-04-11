module com.example.appdieta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.appdieta to javafx.fxml;
    exports com.example.appdieta;
}