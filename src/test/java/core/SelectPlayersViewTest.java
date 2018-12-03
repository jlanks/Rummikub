package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SelectPlayersViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		SelectPlayersView myPannel = new SelectPlayersView(); 
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 600, 325)); //Keep the X value consistent with the X value of the MainView
		primaryStage.show();
		}
		public static void main(String[] args) {
		launch(args);
	}

}
