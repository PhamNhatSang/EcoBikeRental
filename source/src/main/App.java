package main;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.home.HomeScreenHandler;
import javafx.util.Duration;
import java.io.IOException;
//import java.time.Duration;
import java.time.LocalTime;
    /**
     * this is main class
     * @author NhatSang
     * @version 1.0
     */
public class App extends Application {

	@FXML
	ImageView logo;

	/**
	 * start application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {

			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(Configs.SPLASH_SCREEN_PATH));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

			
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);

			
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);

			fadeIn.play();
			fadeIn.setOnFinished((e) -> {
				fadeOut.play();
			});

			fadeOut.setOnFinished((e) -> {
			try {
					HomeScreenHandler homeHandler = new HomeScreenHandler(primaryStage, Configs.HOME_PATH);
					homeHandler.setScreenTitle("Home Screen");
					homeHandler.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
