package core;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
public class MainView extends Pane {
	
	public MainView() {
	Pane innerPane = new Pane(); 
	Label meldlabel = new Label("MELDS ON TABLE:"); 
	Game game = new Game(); 
	game.InitGame();
	// give player2 the tiles to play a melds to the table
	game.nextTurn();
	game.getPlayer().addTile(new Tile("O10"));
	game.getPlayer().addTile(new Tile("G10"));
	game.getPlayer().addTile(new Tile("B10"));
	game.getPlayer().Play(game); 
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
	 // each row needs to be an array of tile representations
	 // make a method in meld class which represents
	 // the meld in a string form. 
	 // array of melds in string form can then populate
	 // the listview
	 // 
	meldList.setItems(FXCollections.observableArrayList(game.getTable().getMeldsString()));
	 meldList.relocate(10, 45);
	 meldList.setPrefSize(150, 150);
	// Adding elements to the pane 
	innerPane.getChildren().addAll(meldlabel,addButtontable,addButton,meldList);
			
			
			
	getChildren().addAll(innerPane);
}

}
