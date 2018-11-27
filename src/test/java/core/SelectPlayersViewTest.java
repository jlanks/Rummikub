package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SelectPlayersViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		SelectPlayersView myPannel = new SelectPlayersView(); 
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 300, 125));
		primaryStage.show();
		}
		public static void main(String[] args) {
		launch(args);
	}

}
