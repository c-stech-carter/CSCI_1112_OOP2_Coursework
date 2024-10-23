/**
 * Author: Charles T. Carter
 * Date: 10/23/2024
 *
 * This Program creates a ball on the screen in a pane and allows the user to use the arrow keys
 * to move it up to the edges of the window.
 *
 * The program requires the installation of Open JavaFX libraries
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class JavaFX_Listeners extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle ball = new Circle(200,200,20); //Creates a default black ball with radius 20 at center of pane
        pane.getChildren().add(ball);

        Scene scene = new Scene(pane, 400, 400);
        scene.setOnKeyPressed(event -> handleKeyPress(event, ball, pane));

        primaryStage.setTitle("Move ball on screen with arrow keys");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();


    }

    private void handleKeyPress (KeyEvent event, Circle ball, Pane pane){
        switch (event.getCode()) {
            case UP:
                if (ball.getCenterY() - ball.getRadius() > 0) {
                    ball.setCenterY(ball.getCenterY() - 10);
                }
                break;
            case DOWN:
                if (ball.getCenterY() + ball.getRadius() < pane.getHeight()) {
                    ball.setCenterY(ball.getCenterY() + 10);
                }
                break;
            case LEFT:
                if (ball.getCenterX() - ball.getRadius() > 0) {
                    ball.setCenterX(ball.getCenterX() - 10);
                }
                break;
            case RIGHT:
                if (ball.getCenterX() + ball.getRadius() < pane.getWidth()) {
                    ball.setCenterX(ball.getCenterX() + 10);
                }
                break;
        }
    }

    /**
     * The main method is only needed for IDEs with limited
     * JavaFX support. It is not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
