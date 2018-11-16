package core;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SelectPlayersView extends Pane {
	
	public SelectPlayersView()  {
		
		Pane innerPane = new Pane(); 
		Label enterName = new Label("SELECT NUMBER OF PLAYERS:"); 
		enterName.relocate(10, 10);
		enterName.setPrefSize(300, 25);
		
		ObservableList<String> options = FXCollections.observableArrayList("2", "3", "4");
		ComboBox playerBox = new ComboBox(options);
		 
		playerBox.setPromptText("Choose # Players");
		
		playerBox.relocate(10,50);
		playerBox.setPrefSize(200,30);
		
		innerPane.getChildren().addAll(playerBox,enterName);
		 
		getChildren().addAll(innerPane);
	}

}
