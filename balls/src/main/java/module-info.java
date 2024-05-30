module com.example.balls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.balls to javafx.fxml;
    exports com.example.balls;
}