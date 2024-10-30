/**
 * Author: Charles T. Carter
 * Date: 10/30/2024
 *
 * This program creates a TextField that allows the user to enter a number of seconds,
 * the seconds then count down to zero and an MP3 is played.
 *
 * This program requires the use of JavaFX
 */



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {
    private Timeline timeline;
    private int remainingSeconds;

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setAlignment(Pos.CENTER);
        textField.setFont(Font.font(70));

        textField.setOnAction(e -> {
            remainingSeconds = Integer.parseInt(textField.getText());
            startCountdown(textField);
        });

        Scene scene = new Scene(textField, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 16 21");
        primaryStage.show();
    }


    private void startCountdown(TextField textField) {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    remainingSeconds--;
                    textField.setText(String.valueOf(remainingSeconds));

                    if (remainingSeconds <= 0) {
                        timeline.stop();
                        playMusic();
                    }
                })
        );

        timeline.setCycleCount(remainingSeconds);
        timeline.play();
    }

    private void playMusic() {
        Media media = new Media ("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);  //Set to loop continuously
        mediaPlayer.play();
    }

}
