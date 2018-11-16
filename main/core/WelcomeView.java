package core;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class WelcomeView extends Pane{
	
	public WelcomeView() {
		
	    // Welcome Greeting Title
		Pane innerPane = new Pane(); 
		Label title = new Label("WELCOME TO RUMMIKUB"); 
		title.relocate(265, 20);
		
		// Making Play Button
		
		Button playButton = new Button("PLAY");
		 playButton.relocate(75, 10);
		 playButton.setPrefSize(100, 25);
		
		// Making Watch Button
		 Button watchButton = new Button("WATCH");
		 watchButton.relocate(75, 40);
		 watchButton.setPrefSize(100, 25);
		
		// Adding elements to the pane 
		innerPane.getChildren().addAll(title,playButton,watchButton);
		
		
		
		getChildren().addAll(innerPane);
		
		
	}
	
	

}
