package com.example.balls;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static com.example.balls.Vector.collisionOfButtons;

public class ButtonsCollision extends Application {
    @Override

    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 620, 620);
        stage.setTitle("Buttons Collision");
        stage.setScene(scene);
        stage.show();

        Button button1 = new Button("button1");
        button1.setLayoutX(260);
        button1.setLayoutY(260);
        button1.setMinWidth(70);
        button1.setMinHeight(100);

        Button button2 = new Button("button2");
        button2.setLayoutX(100);
        button2.setLayoutY(100);
        button2.setMinWidth(50);
        button2.setMinHeight(60);

        Vector vector  = new Vector(2,3);
        Vector vector1 = new Vector(1,1);
        Vector vector2 = new Vector(1,1);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                button1.setLayoutX(button1.getLayoutX() + vector1.getVx());
                button1.setLayoutY(button1.getLayoutY() + vector1.getVy());

                button2.setLayoutX(button2.getLayoutX() + vector2.getVx());
                button2.setLayoutY(button2.getLayoutY() + vector2.getVy());

                vector1.collisionWithBorders(button1, 620, 620);
                vector2.collisionWithBorders(button2, 620, 620);

                collisionOfButtons(button1, vector1, button2, vector2);
            }
        }.start();

        pane.getChildren().add(button1);
        pane.getChildren().add(button2);
    }

    public static void main(String[] args) {
        launch();
    }
}