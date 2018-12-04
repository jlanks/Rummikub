package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddToMeldViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AddToMeldView myPannel = new AddToMeldView("R4 R5 R6");		//adding to meld [R4 R5 R6]
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 400, 400)); // Keep these dimensions consistent for a nice MainView
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
