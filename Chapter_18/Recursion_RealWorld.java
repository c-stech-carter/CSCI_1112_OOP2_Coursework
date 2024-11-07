import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * Author: Charles Carter  - Only of small modifications to the class taken from
 *                           Intro to Java by Daniel Liang
 * Date: 11/7/2024
 *
 * This program draws a Sierpinski Triangle using plus and minus buttons.   My changes are
 * adding buttons that increase and decrease the order of triangles.   The minus button decreases
 * until it is zero and then goes no further.
 *
 * I've also changed the color to red instead of white.
 *
 * This program uses OpenJavaFX and requires its libraries to function
 */



public class Recursion_RealWorld extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        //Adding buttons instead of original TextField
        Button btnAdd = new Button("+");
        Button btnSub = new Button("-");


        //One of my modifications: button behavior
        btnAdd.setOnAction(e-> {
            pane.setOrder(pane.getOrder() + 1); //Using the new method I added to the S.Triangle class
        });

        btnSub.setOnAction(e -> {
            if (pane.getOrder() > 0) {
                pane.setOrder(pane.getOrder() - 1);
            }
        });

        // HBox to hold label and text field
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btnAdd, btnSub);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    /** Pane for displaying triangles */
    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;

        /** Set a new order */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        //This is one of my modifications
        public int getOrder() {
            return order;
        }

        SierpinskiTrianglePane() {
        }

        protected void paint() {
            // Select three points in proportion to the panel size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear(); // Clear the pane before redisplay

            displayTriangles(order, p1, p2, p3);
        }

        private void displayTriangles(int order, Point2D p1,
                                      Point2D p2, Point2D p3) {
            if (order == 0) {
                // Draw a triangle to connect three points
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(),
                        p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.RED);  //I changed the color just for fun

                this.getChildren().add(triangle);
            }
            else {
                // Get the midpoint on each edge in the triangle
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                // Recursively display three triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
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