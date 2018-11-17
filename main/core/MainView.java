package core;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
public class MainView extends Pane {
	
	public MainView() {
	Pane innerPane = new Pane(); 
	Label meldlabel = new Label("MELDS ON TABLE:"); 
	
	meldlabel.relocate(10, 10);
	meldlabel.setPrefSize(150, 25);
	
	
	// Create and position the "Add To Meld" Button
	 Button addButton = new Button("Add To Meld");
	 addButton.relocate(10, 200);
	 addButton.setPrefSize(150, 25);
	 
	// Create and position the "Create New Meld" Button
		 Button addButtontable = new Button("Create New Meld");
		 addButtontable.relocate(10, 235);
		 addButtontable.setPrefSize(150, 25);
	 
	 ListView<String> meldList = new ListView<String>();
	//meldList.setItems(FXCollections.observableArrayList());
	 meldList.relocate(10, 45);
	 meldList.setPrefSize(150, 150);
	// Adding elements to the pane 
	innerPane.getChildren().addAll(meldlabel,addButtontable,addButton,meldList);
			
			
			
	getChildren().addAll(innerPane);
}

}
