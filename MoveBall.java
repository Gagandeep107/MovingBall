package com.example.assignment5;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MoveBall extends Application {
    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();

        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        btLeft.setOnAction(e -> ballPane.moveLeft());
        btRight.setOnAction(e -> ballPane.moveRight());
        btUp.setOnAction(e -> ballPane.moveUp());
        btDown.setOnAction(e -> ballPane.moveDown());

        HBox hBox = new HBox(btLeft, btRight, btUp, btDown);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(ballPane);
        borderPane.setBottom(hBox);


        Scene scene = new Scene(borderPane, 450, 450);
        primaryStage.setTitle("Move the Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

class BallPane extends Pane {
    private Circle ball;
    private double x = 1;
    private double y = 1;

    public BallPane() {
        ball = new Circle(200, 200, 40);
        ball.setFill(Color.RED);
        getChildren().add(ball);
    }

    public void moveLeft() {
        if (ball.getCenterX() - x - ball.getRadius() >= 0) {
            ball.setCenterX(ball.getCenterX() - x);
        }
    }

    public void moveRight() {
        if (ball.getCenterX() + x + ball.getRadius() <= getWidth()) {
            ball.setCenterX(ball.getCenterX() + x);
        }
    }

    public void moveUp() {
        if (ball.getCenterY() - y - ball.getRadius() >= 0) {
            ball.setCenterY(ball.getCenterY() - y);
        }
    }

    public void moveDown() {
        if (ball.getCenterY() + y + ball.getRadius() <= getHeight()) {
            ball.setCenterY(ball.getCenterY() + y);
        }
    }
}
