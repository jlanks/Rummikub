package core;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CreateMeldView extends Pane {

	ComboBox selectionBox;
	ListView<String> tileList = new ListView<String>();
	Button OKButton = new Button("OK");
	Label tileSelectionLabel = new Label("Select your tiles (hold ctrl)");
	Label meldTypeLabel = new Label("Are you making a set or run? ");

	Game game;

	public CreateMeldView(final Controller controller) {
		//game.InitGame(); //Resets the game whenever the "Create New Meld" button is pressed in MainView
		game = controller.getGame();
		final Pane innerPane = new Pane();

		meldTypeLabel.relocate(10, 10);
		meldTypeLabel.setPrefSize(200, 25);
		
		ObservableList<String> meldTypes = FXCollections.observableArrayList("Set", "Run");
		selectionBox = new ComboBox(meldTypes);
		selectionBox.relocate(200, 10);
		selectionBox.setPrefSize(100, 25);
		
		tileSelectionLabel.relocate(10, 50);
		tileSelectionLabel.setPrefSize(200, 25);
		
		tileList.setItems(FXCollections.observableArrayList(controller.getCurrHand()));
		tileList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tileList.relocate(10, 75);
		tileList.setPrefSize(380, 280);
		
		OKButton.relocate(100, 365);
		OKButton.setPrefSize(200, 25);
		
		innerPane.getChildren().addAll(meldTypeLabel, selectionBox, tileList, OKButton, tileSelectionLabel);
		getChildren().addAll(innerPane);
		
		

		// *** EVENT HANDLERS ***//
		OKButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				String meldTypeStr = (String) selectionBox.getSelectionModel().getSelectedItem();
								
				//innerPane.getChildren().clear();
				//innerPane.getChildren().addAll(meldTypeLabel, selectionBox, tileList, OKButton, tileSelectionLabel);
				
				//TODO only returns ONE index!!!
				System.out.println(tileList.getSelectionModel().getSelectedIndices());
				ObservableList<Integer> indexList = tileList.getSelectionModel().getSelectedIndices();
				ArrayList<String> handList = controller.getCurrHand();
				
				ArrayList<String> meldStr = new ArrayList<String>();
				ArrayList<String> newHand = handList;
				
				int meldSize = indexList.size();
				System.out.println("indexList: " + indexList.toString() + "\ntilesList: " + handList + "\nmeldSize: " + meldSize);
				for(int i = 0; i < meldSize; i++) {
					String tile = handList.get(indexList.get(i));
					meldStr.add(tile);
					//newHand.remove(tile);
				}
				
				for(int i = 0; i < meldSize; i++) {
					String tile = handList.get(indexList.get(i));
					//meldStr.add(tile);
					newHand.remove(tile);
				}
				//System.out.println(meldTypeStr + " : " + meldStr);
				

				//tileList.setItems(FXCollections.observableArrayList(controller.getCurrHand()));
				
				controller.updateHand(newHand);
				controller.addMeld(meldStr);
				
				
				GameInfoView giv = new GameInfoView(controller);
				Pane infoPane = new Pane();
				infoPane.getChildren().add(giv);
				infoPane.relocate(0, 0);
				innerPane.getChildren().clear();
				innerPane.getChildren().add(infoPane);
			}
		});
	}
}
