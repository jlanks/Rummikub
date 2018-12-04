package core;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AddToMeldView extends Pane {

	TextField newMeldTF = new TextField();
	ComboBox selectionBox;
	TextField positionTF = new TextField();
	Button addButton = new Button("ADD");
	Button doneButton = new Button("DONE");

	Game game;
	final ArrayList<String> newHand;

	public AddToMeldView(final Controller controller, String meldStr) {
		//game.InitGame();	//Resets the game whenever the "Create New Meld" button is pressed in MainView
		game = controller.getGame();
		final Pane innerPane = new Pane();
		final ArrayList<String> oldMeld = new ArrayList<String>(Arrays.asList(meldStr.split(" "))); //Casts meldStr to ArrayList of Tiles (in String representation)
		final ArrayList<String> newMeld = oldMeld;
		final int meldIndex = controller.indexOfMeld(meldStr);
		newHand = controller.getCurrHand();
		
		Label originalMeldLabel = new Label("Original Meld: ");
		originalMeldLabel.relocate(10, 10);
		originalMeldLabel.setPrefSize(150, 25);
		TextField oMeldTF = new TextField();
		oMeldTF.setText(oldMeld.toString());
		oMeldTF.setEditable(false);
		oMeldTF.relocate(170, 10);
		oMeldTF.setPrefSize(220, 25);
		
		Label newMeldLabel = new Label("New Meld: ");
		newMeldLabel.relocate(10, 45);
		newMeldLabel.setPrefSize(150, 35);
		final TextField newMeldTF = new TextField();
		newMeldTF.setText(newMeld.toString());
		newMeldTF.setEditable(false);
		newMeldTF.relocate(170, 45);
		newMeldTF.setPrefSize(220, 25);

		Label handLabel = new Label("Select tile from hand: ");
		handLabel.relocate(10, 100);
		handLabel.setPrefSize(200, 25);
		ObservableList<String> newHandOL = FXCollections.observableArrayList(newHand);
		selectionBox = new ComboBox(newHandOL);
		selectionBox.relocate(210, 100);
		selectionBox.setPrefSize(100, 25);

		final Label positionLabel = new Label("Position to insert in new meld:\n( 0-" + newMeld.size() + ", inclusive )");
		positionLabel.relocate(10, 135);
		positionLabel.setPrefSize(200, 50);
		positionTF.setText("0");
		positionTF.relocate(210, 135);
		positionTF.setPrefSize(50, 25);
		
		addButton.relocate(210, 200);
		addButton.setPrefSize(170, 25);

		doneButton.relocate(100, 365);
		doneButton.setPrefSize(200, 25);

		innerPane.getChildren().addAll(originalMeldLabel, oMeldTF, newMeldLabel, newMeldTF, handLabel, positionLabel, positionTF, selectionBox, addButton, doneButton);
		getChildren().addAll(innerPane);

		// *** EVENT HANDLERS ***//
		addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				String tile = selectionBox.getSelectionModel().getSelectedItem().toString();
				int position = Integer.parseInt(positionTF.getText());
				
				newMeld.add(position, tile);
				newMeldTF.setText(newMeld.toString());
				newHand.remove(tile);
				positionLabel.setText("Position to insert in new meld:\n( 0-" + newMeld.size() + ", inclusive )");
				ObservableList<String> newHandOL = FXCollections.observableArrayList(newHand);
				selectionBox = new ComboBox(newHandOL);
			}
		});
		doneButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				//TODO update the player's real Hand and the real Meld through the controller
				controller.updateHand(newHand);
				System.out.println();
				controller.updateMeld(meldIndex, newMeld);
				innerPane.getChildren().clear();
				GameInfoView giv = new GameInfoView(controller);
				Pane infoPane = new Pane();
				infoPane.getChildren().add(giv);
				infoPane.relocate(0, 0);
				innerPane.getChildren().add(infoPane);
			}
		});
	}
}
