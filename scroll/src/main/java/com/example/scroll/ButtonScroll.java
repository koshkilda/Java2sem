package com.example.scroll;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonScroll extends Application {
    @Override

    public void start(Stage stage) {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setTitle("ButtonScroll");
        stage.setScene(scene);
        stage.show();

        Button button = new Button();
        button.setText("button");
        button.setMinSize(10, 10);

        pane.getChildren().add(button);

        button.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                button.setStyle("-fx-font-size: " + (button.getFont().getSize() + scrollEvent.getDeltaY()) + "px;");
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}