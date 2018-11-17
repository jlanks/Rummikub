package core;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class CreateMeldViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		CreateMeldView myPannel = new CreateMeldView(); 
		primaryStage.setTitle("Rummikub");
		 primaryStage.setResizable(true);
		 primaryStage.setScene(new Scene(myPannel, 170,300));
		 primaryStage.show();
	}
	public static void main(String[] args) {
		 launch(args);

	}

}
