package core;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


public class InitPlayerView extends Pane{
	
	public InitPlayerView(){
		
		Pane innerPane = new Pane(); 
		Label enterName = new Label("ENTER NAME:"); 
		enterName.relocate(10, 10);
		enterName.setPrefSize(150, 25);
		
		TextField nameField = new TextField();
		nameField.relocate(100,10);
		nameField.setPrefSize(150, 25);
		
		
		// Adding elements to the pane 
		innerPane.getChildren().addAll(enterName,nameField);
		
		
		
		getChildren().addAll(innerPane);
				
		
	}
	
	

}
