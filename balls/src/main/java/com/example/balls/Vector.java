package com.example.balls;

import javafx.scene.control.Button;


public class Vector {
    private double vx;
    private double vy;

    public Vector(double Vx, double Vy) {
        this.vx = Vx;
        this.vy = Vy;
    }

    public double getVx() {
        return this.vx;
    }

    public double getVy() {
        return this.vy;
    }

    public void setVx(double Vx) {
        this.vx = Vx;
    }

    public void setVy(double Vy) {
        this.vy = Vy;
    }

    public void collisionWithBorders(Button button, int bx, int by) {

        if ((button.getLayoutX() <= 1) || (button.getLayoutX() + button.getWidth() >= bx)) {
            this.vx = -this.vx;
        }

        if ((button.getLayoutY() <= 1) || (button.getLayoutY() + button.getHeight() >= by)) {
            this.vy = -this.vy;
        }
    }

    public static int is_equal(double a, double b) {
        if (Math.abs(a - b) < 0.1) {
            return 1;
        } else return 0;

    }

    public static int borderInsideY(Button button1, Button button2) {
        if (Math.min(button1.getLayoutY() + button1.getHeight(),
                button2.getLayoutY() + button2.getHeight()) >=
                Math.max(button1.getLayoutY(),
                        button2.getLayoutY())) {
            return 1;
        } else
            return 0;
    }

    public static int borderInsideX(Button button1, Button button2) {
        if (Math.max(button1.getLayoutX(),
                button2.getLayoutX()) <=
                Math.min(button1.getLayoutX() + button1.getWidth(),
                        button2.getLayoutX() + button2.getWidth())) {
            return 1;
        } else
            return 0;
    }

    public static int crossedX(Button button1, Button button2) {
        if (is_equal(Math.min(button1.getLayoutX() + button1.getWidth(),
                        button2.getLayoutX() + button2.getWidth()),
                Math.max(button1.getLayoutX(),
                        button2.getLayoutX())) == 1 &&
                Vector.borderInsideY(button1, button2) == 1) {
            return 1;
        } else
            return 0;
    }

    public static int crossedY(Button button1, Button button2) {
        if (is_equal(Math.min(button1.getLayoutY() + button1.getHeight(),
                        button2.getLayoutY() + button2.getHeight()),
                Math.max(button1.getLayoutY(),
                        button2.getLayoutY())) == 1 &&
                Vector.borderInsideX(button1, button2) == 1) {
            return 1;
        }
        else
            return 0;
    }

    public static void collisionOfButtons(Button button1, Vector vector1, Button button2, Vector vector2) {

        if (Vector.crossedX(button1, button2) == 1) {

            double Vx1 = vector1.getVx();
            double Vx2 = vector2.getVx();

            if (Vx1 * Vx2 < 0) {
                vector1.setVx(-Vx1);
                vector2.setVx(-Vx2);
            }

            else {
                double sign = Math.signum(Vx1);
                if (button1.getLayoutX() * sign < button2.getLayoutX() * sign)
                    vector1.setVx(-Vx1);
                else
                    vector2.setVx(-Vx2);
            }
        }

        if (Vector.crossedY(button1, button2) == 1) {

            double Vy1 = vector1.getVy();
            double Vy2 = vector2.getVy();

            if (Vy1 * Vy2 < 0) {
                vector1.setVy(-Vy1);
                vector2.setVy(-Vy2);
            }

            else {
                double sign = Math.signum(Vy1);
                if (button1.getLayoutY() * sign < button2.getLayoutY() * sign)
                    vector1.setVy(-Vy1);
                else
                    vector2.setVy(-Vy2);
            }
        }
    }
}