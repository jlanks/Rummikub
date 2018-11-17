package core;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainViewTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainView myPannel = new MainView(); 
		primaryStage.setTitle("Rummikub");
		 primaryStage.setResizable(true);
		 primaryStage.setScene(new Scene(myPannel, 600,400));
		 primaryStage.show();
		
	}
	public static void main(String[] args) {
		 launch(args);

	}
}
