module com.example.fillintersection {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fillintersection to javafx.fxml;
    exports com.example.fillintersection;
}