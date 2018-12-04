package core;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MainView extends Pane {

	Pane innerPane = new Pane();
	Button addToButton = new Button("Add To Meld");
	Button createNewButton = new Button("Create New Meld");
	ListView<String> meldList = new ListView<String>();

	//TODO add a pane that displays the game to be shown in between adding/editing melds
	// have to make panes close after ok/done is pressed

	public MainView() {
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

		// Position the "Add To Meld" Button
		addToButton.relocate(10, 330);
		addToButton.setPrefSize(150, 25);

		// Position the "Create New Meld" Button
		createNewButton.relocate(10, 365);
		createNewButton.setPrefSize(150, 25);

		// each row needs to be an array of tile representations
		// make a method in meld class which represents
		// the meld in a string form.
		// array of melds in string form can then populate
		// the listview
		//
		meldList.setItems(FXCollections.observableArrayList(game.getTable().getMeldsString()));
		meldList.relocate(10, 45);
		meldList.setPrefSize(150, 280);
		// Adding elements to the pane
		innerPane.getChildren().addAll(meldlabel, addToButton, createNewButton, meldList);
		getChildren().addAll(innerPane);

		// *** EVENT HANDLERS ***//
		addToButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				String meldStr = meldList.getSelectionModel().getSelectedItem();
				System.out.println(meldStr);
				AddToMeldView atv = new AddToMeldView(meldStr);
				atv.relocate(200, 0);
				innerPane.getChildren().add(atv);
			}
		});
		
		createNewButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				CreateMeldView cmv = new CreateMeldView();
				cmv.relocate(200, 0);
				innerPane.getChildren().add(cmv);
			}
		});
	}
}
