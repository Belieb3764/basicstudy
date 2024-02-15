module com.example.ex1hellojpa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ex1hellojpa to javafx.fxml;
    exports com.example.ex1hellojpa;
}