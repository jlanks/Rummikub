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
	
	Pane innerPane = new Pane(); 
	Button startButton = new Button("START");

	public SelectPlayersView()  {		
		Label enterName = new Label("SELECT NUMBER OF PLAYERS:"); 
		enterName.relocate(10, 10);
		enterName.setPrefSize(300, 25);
		
		ObservableList<String> options = FXCollections.observableArrayList("2", "3", "4");
		final ComboBox playerBox = new ComboBox(options);
		playerBox.setPromptText("Choose # Players");
		playerBox.relocate(10,50);
		playerBox.setPrefSize(200,30);
		
		final Button nextButton = new Button("Next");
		nextButton.relocate(10,90);
		nextButton.setPrefSize(75, 25);
		
		innerPane.getChildren().addAll(playerBox, enterName, nextButton);
		getChildren().addAll(innerPane);
		
		
		//*** EVENT HANDLERS ***//
		nextButton.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	playerBox.setDisable(true);
		    	nextButton.setDisable(true);
		    	
		    	if(playerBox.getValue() == null) {
		    		System.exit(0);
		    	}
		    	
		        int numPlayers = Integer.parseInt((String) playerBox.getValue());
		        Pane initPane = new Pane();
		        initPane.getChildren().clear();
		        
		        for(int i = 0; i < numPlayers; i++) {
		        	InitPlayerView initView = new InitPlayerView();
		        	initView.relocate(10, 10 + (i*30));
		        	initPane.getChildren().add(initView);
		        }
		        
		        startButton.setPrefSize(75, 25);
	        	startButton.relocate(10, 50 + (numPlayers*30));
	        	initPane.getChildren().addAll(startButton);
	        	initPane.relocate(0, 125);
	        	innerPane.getChildren().add(initPane);
		    }
		});
		startButton.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		        //TODO close window and start game (open new mainView window?)
		    }
		});
	}
}
