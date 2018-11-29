package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InitPlayerViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		InitPlayerView myPannel = new InitPlayerView(); 
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 575 ,50));
		primaryStage.show();
		}
		public static void main(String[] args) {
		launch(args);
		}
	}


