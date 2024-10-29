/**
 * Author: Charles T. Carter
 * Date: 10/28/2024
 *
 * This program creates a window with the text "Programming is fun"  And allows the user
 * to move it left and right with some clickable buttons.  There is also the option
 * to change the color of this text from a selection of four colors.
 *
 * This program requires Open JavaFX to be set up in order to run the program.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFX_Events extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Setting up the text
        Text text = new Text(90,70,"Programming is fun");
        text.setFont(new Font("Arial", 20));

        //Setting up the direction buttons for Left and Right
        HBox directionPane = new HBox(20);
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");

        directionPane.getChildren().addAll(leftButton, rightButton);
        directionPane.setAlignment(Pos.CENTER);
        directionPane.setStyle("-fx-border-color: black");

        //Setting up the Radio buttons for choosing the colors
        VBox colorPane = new VBox(20);
        colorPane.setPadding(new Insets(5,5,5,5));
        colorPane.setStyle("-fx-border-color: black");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbBlue = new RadioButton("Blue");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlack = new RadioButton("Black");

        colorPane.getChildren().addAll(rbRed, rbBlue, rbGreen, rbBlack);


        //Setting up panes
        BorderPane borderPane = new BorderPane();

        Pane textPane = new Pane();
        textPane.getChildren().add(text);

        borderPane.setCenter(textPane);
        borderPane.setBottom(directionPane);
        borderPane.setLeft(colorPane);

        //Assigning actions for directions
        leftButton.setOnAction(e -> {
            if (text.getX() > 0) {  //Prevents leaving the pane
                text.setX(text.getX() - 10);
            }
        });

        rightButton.setOnAction(e -> {
            //Preventing it from moving too far to the right a little more complex
            if (text.getX() + text.getLayoutBounds().getWidth() <= textPane.getWidth() - 10) {
                text.setX(text.getX() + 10);
            }
        });

        //Assigning actions for color radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        rbRed.setToggleGroup(toggleGroup);
        rbBlue.setToggleGroup(toggleGroup);
        rbGreen.setToggleGroup(toggleGroup);
        rbBlack.setToggleGroup(toggleGroup);

        rbRed.setOnAction(e-> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbBlue.setOnAction(e-> {
            if (rbBlue.isSelected()) {
                text.setFill(Color.BLUE);
            }
        });

        rbGreen.setOnAction(e-> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        rbBlack.setOnAction(e-> {
            if (rbBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });

        //Setting up scene

        Scene scene = new Scene(borderPane, 450, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Events Assignment");
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
