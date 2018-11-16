package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		WelcomeView myPannel = new WelcomeView(); 
		primaryStage.setTitle("Rummikub");
		 primaryStage.setResizable(true);
		 primaryStage.setScene(new Scene(myPannel, 500,100));
		 primaryStage.show();
		 }
		 public static void main(String[] args) {
		 launch(args);
		 }
		
		
	}


