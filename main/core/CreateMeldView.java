package core;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
public class CreateMeldView extends Pane{
	
	public CreateMeldView() {
		Pane innerPane = new Pane(); 
		Label chooseTiles = new Label("Choose Your Tiles: "); 
		
		chooseTiles.relocate(10, 10);
		chooseTiles.setPrefSize(150, 25);
		
		// Create and position the "Add To Meld" Button
		 Button createButton = new Button("Create");
		 createButton.relocate(10, 200);
		 createButton.setPrefSize(150, 25);
		 
		// Create and position the "Create New Meld" Button
		 Button exitButton = new Button("EXIT");
		 exitButton.relocate(10, 235);
		 exitButton.setPrefSize(150, 25);
		 
		 ListView<String> tileList = new ListView<String>();
		//meldList.setItems(FXCollections.observableArrayList());
		 tileList.relocate(10, 45);
		 tileList.setPrefSize(150, 150);
		// Adding elements to the pane 
		innerPane.getChildren().addAll(chooseTiles,exitButton,createButton,tileList);
				
				
				
		getChildren().addAll(innerPane);
	}

}
