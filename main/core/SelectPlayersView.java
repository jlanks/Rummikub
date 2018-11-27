package core;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
		
		Button nextButton = new Button("Next");
		nextButton.relocate(10,90);
		nextButton.setPrefSize(75, 25);
		
		innerPane.getChildren().addAll(playerBox,enterName, nextButton);
		 
		getChildren().addAll(innerPane);
		
		
		//*** EVENT HANDLERS ***//
		nextButton.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        System.out.println("Mouse pressed");
		        //TODO update number of InitPlayer panes
		    }
		});
		
		playerBox.setOnMousePressed(getOnMouseClicked());
	}
}
