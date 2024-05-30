package com.example.fillintersection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1500, 1000);
        FillIntersection fillIntersection = new FillIntersection();

        Button button1 = new MyButton("Кнопка 1.", fillIntersection);
        button1.setMinWidth(1000);
        button1.setMinHeight(100);
        button1.setLayoutX(200);
        button1.setLayoutY(200);
        pane.getChildren().add(button1);

        Button button2 = new MyButton("Кнопка 2", fillIntersection);
        pane.getChildren().add(button2);

        fillIntersection.button1 = button1;
        fillIntersection.button2 = button2;

        Rectangle rectangle = new Rectangle(0,0);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        fillIntersection.rectangle = rectangle;

        System.out.println("X:" + button1.getLayoutX());
        System.out.println("Y:" + button1.getLayoutY());
        // System.out.println("maxX:" + button1.getBoundsInParent().get());
        // long startTime = System.currentTimeMillis();

//        AnimationTimer animationTimer = new AnimationTimer() {
//            double counter = 0;
//            @Override
//            public void handle(long l) {
//                counter++;
//                double timePassed = (System.currentTimeMillis() - startTime);
//                button1.setText(String.valueOf(counter/timePassed * 1000));
//                System.out.println(counter + " : " + timePassed);
////                button1.setLayoutX(button1.getLayoutX() + 1);
////                button1.setLayoutY(button1.getLayoutY() + 1);
//            }
//        }; //класс без имени
//        animationTimer.start();

        stage.setScene(scene);
        stage.show();
    }
}

class FillIntersection{
    Button button1;
    Button button2;
    Rectangle rectangle;

    public FillIntersection() {
    }

    public  void intersects(){
        if (button1.getBoundsInLocal().intersects(button2.getBoundsInLocal())) {
            double dx = Math.min(button1.getLayoutX() + button1.getWidth(), button2.getLayoutX() + button2.getWidth())
                    - Math.max(button1.getLayoutX(), button2.getLayoutX());
            double dy = Math.min(button1.getLayoutY() + button1.getHeight(), button2.getLayoutY() + button2.getHeight())
                    - Math.max(button1.getLayoutY(), button2.getLayoutY());

            rectangle.setWidth(dx);
            rectangle.setHeight(dy);

            if (button1.getLayoutX() > button2.getLayoutX()) {
                rectangle.setLayoutX(button2.getLayoutX() + (button2.getWidth() - dx));
                rectangle.setLayoutY(button2.getLayoutY());
            } else {
                rectangle.setLayoutX(button2.getLayoutX());
                rectangle.setLayoutY(button2.getLayoutY());
            }

            if (button1.getLayoutY() > button2.getLayoutY()) {
                rectangle.setLayoutX(button2.getLayoutX() + (button2.getWidth() - dx));
                rectangle.setLayoutY(button2.getLayoutY() + (button2.getHeight() - dy));
            } else {
                rectangle.setLayoutX(button2.getLayoutX());
                rectangle.setLayoutY(button2.getLayoutY());
            }
        }
    }
}

class MyButton extends Button{
    private double mouseClickedX = 0.;
    private double mouseClickedY = 0.;
    private FillIntersection fillIntersection;

    public MyButton(String text, FillIntersection fillIntersection) {
        super(text);
        this.fillIntersection = fillIntersection;

        super.setOnMousePressed(mouseEvent -> {
            mouseClickedX = mouseEvent.getSceneX() - super.getLayoutX();
            mouseClickedY = mouseEvent.getSceneY() - super.getLayoutY();
            System.out.println("mouse pressed x: " + mouseEvent.getSceneX());
            System.out.println("mouse pressed y: " + mouseEvent.getSceneY());
            super.setText("Pressed");
        });

        super.setOnMouseDragged(mouseEvent -> {
            super.setLayoutX(mouseEvent.getSceneX() - mouseClickedX);
//            super.setLayoutX(super.getLayoutX());
            super.setLayoutY(mouseEvent.getSceneY() - mouseClickedY);
            fillIntersection.intersects();
//            super.setLayoutY(super.getLayoutY());
        });

        super.setOnMouseReleased(mouseEvent -> {
            super.setText("Click me!");
        });
    }
}