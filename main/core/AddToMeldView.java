package core;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AddToMeldView extends Pane {

	ComboBox selectionBox;
	ListView<String> tileList = new ListView<String>();
	Button OKButton = new Button("OK");

	Game game = new Game();
	Controller controller = new Controller(game);

	public AddToMeldView(String meldStr) {
		game.InitGame();
		Pane innerPane = new Pane();

		Label meldTypeLabel = new Label("Are you making a set or run? ");
		meldTypeLabel.relocate(10, 10);
		meldTypeLabel.setPrefSize(200, 25);

		ObservableList<String> meldTypes = FXCollections.observableArrayList("Set", "Run");
		selectionBox = new ComboBox(meldTypes);
		selectionBox.relocate(200, 10);
		selectionBox.setPrefSize(100, 25);

		Label tileSelectionLabel = new Label("Select your tiles (hold ctrl)");
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
				//TODO HANDLE
			}
		});
	}
}
