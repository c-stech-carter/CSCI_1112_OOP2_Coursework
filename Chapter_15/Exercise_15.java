/**
 * Author: Charles T. Carter
 * Date: 10/23/2024
 *
 * This program creates a pentagon and has a rectangle follow its outline.
 * The animation can be paused by clicking the right mouse button, then resumed by
 * clicking the left mouse button.
 *
 * The rectangle will also fade in and out of its opacity while the program is running.
 *
 * This program requires JavaFX which will need to be set up in order for this to run.
 */


import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exercise_15 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Polygon pentagon = new Polygon();
        pentagon.getPoints().addAll(
                200.0, 100.0,  // Top point
                300.0, 150.0,
                250.0, 250.0,
                150.0, 250.0,
                100.0, 150.0
        );
        pentagon.setFill(null); //Causes the fill color to not be set
        pentagon.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(30, 20, Color.GREEN);


        //Creating the path transition animation for the pentagon and rectangle
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(5));
        pt.setPath(pentagon);
        pt.setNode(rectangle);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setAutoReverse(false);

        FadeTransition ft = new FadeTransition(Duration.seconds(5), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);  //I chose to make it not fully invisible at the end of its fade.
        ft.setCycleCount(FadeTransition.INDEFINITE);
        ft.setAutoReverse(true); //Repeats the fade backwards

        //Starting the transitions
        pt.play();
        ft.play();


        //Adding ability to pause animation
        pane.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)) { //Pause on right-click
                pt.pause();
            } else if (e.getButton().equals(MouseButton.PRIMARY)) {  //Play on left-click
                pt.play();
            }
        });

        pane.getChildren().addAll(pentagon, rectangle);

        Scene scene = new Scene(pane,400, 400);
        primaryStage.setTitle("Exercise 15");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    /**
     * The main method is only needed for IDEs with limited
     * JavaFX support. It is not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
