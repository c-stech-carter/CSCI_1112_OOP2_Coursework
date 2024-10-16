/**
 * Author: Charles Carter
 * Date 10/15/2024
 *
 * This program displays a STOP sign.   It can be scaled  in the window in which it opens,
 * and still, in most cases, retain its shape.   Nearly all the original code is from Daniel
 * Liang's Intro to Java 13th edition.   His code displays a hexagonal polygon,
 * and I've modified it to display a STOP sign.
 * 
 * You will need to set up JavaFX in order for this program to work in your IDE.
 */


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.beans.binding.StringBinding;

public class JavaFXBasics_RealWorld extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a stackpane
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane, 400, 400);
        MyPolygon myPolygon = new MyPolygon();
        Label stopLabel = new Label("STOP");
        stopLabel.setTextFill(Color.WHITE);
        // Create a StringBinding for the label's style property
        StringBinding fontSizeBinding = Bindings.createStringBinding(() -> {
            double fontSize = stackPane.getWidth() * 0.20; // Calculate font size based on the pane's width
            return String.format("-fx-font-size: %.2fpx; -fx-font-weight: bold;", fontSize);
        }, stackPane.widthProperty());

        // Bind the style property to the created binding
        // This allows the lettering 'STOP' to scale when resizing the window
        stopLabel.styleProperty().bind(fontSizeBinding);
        stackPane.getChildren().addAll(myPolygon, stopLabel);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
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

class MyPolygon extends Pane {
    private void paint() {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.RED);
        ObservableList<Double> list = polygon.getPoints();

        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < 8; i++) {
            polygon.setRotate(22.5);
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }

        getChildren().clear(); // Clear pane
        getChildren().add(polygon);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
