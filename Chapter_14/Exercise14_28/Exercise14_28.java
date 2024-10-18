/**
 * Author: Charles T. Carter
 * Date: 10/17/2024
 *
 * This program is modified from a java class in Daniel Liang's Intro to Java
 * The original is DisplayClock, and Exercise14_28 is meant to display
 * random times with only the hour and minute hand.
 * The JavaFX SDK needs to be set up in order for this to run.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise14_28 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock and a label
        //This Line is one of only two modifications, it sets the hour hand up to 11, and the minute hand to either 0 or 30:
        ClockPane clock = new ClockPane((int)(Math.random()*12),(int)(Math.random() < 0.5 ? 0 : 30),0 );
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        //This second line is the second modification, simply setting the second hand to invisible
        clock.setSecondHandVisble(false);
        Label lblCurrentTime = new Label(timeString);

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for IDEs with limited
     * JavaFX support. It is not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
