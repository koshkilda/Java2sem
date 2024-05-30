module com.example.scroll {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scroll to javafx.fxml;
    exports com.example.scroll;
}