package core;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class InitPlayerView extends Pane {
	TextField nameField = new TextField();
	ObservableList<String> options = FXCollections.observableArrayList("StrategyHuman", "StrategyOne", "StrategyTwo");
	ComboBox stratBox = new ComboBox(options);
	Button nextButton = new Button("Done");

	public InitPlayerView() {

		Pane innerPane = new Pane();
		Label enterName = new Label("ENTER NAME:");
		enterName.relocate(10, 10);
		enterName.setPrefSize(150, 25);

		nameField.relocate(100, 10);
		nameField.setPrefSize(150, 25);

		stratBox.setPromptText("Choose Player's Strategy:");
		stratBox.relocate(260, 10);
		stratBox.setPrefSize(200, 25);

		nextButton.relocate(480, 10);
		nextButton.setPrefSize(75, 25);

		// Adding elements to the pane
		innerPane.getChildren().addAll(enterName, nameField, stratBox, nextButton);
		getChildren().addAll(innerPane);

		// *** EVENT HANDLERS ***//
		nextButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				String name = nameField.getText();
				String strat = stratBox.getSelectionModel().getSelectedItem().toString();
				// TODO CREATE NEW PLAYER
				nameField.setEditable(false);
				stratBox.setDisable(true);
				nextButton.setDisable(true);
			}
		});
	}
}
