package core;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;

public class GameInfoView extends Pane {
	
	public GameInfoView(Controller c) {
		Pane innerPane = new Pane();
		
		TextArea tf = new TextArea();
		tf.setEditable(false);
		tf.setPrefSize(390, 390);
		tf.relocate(0, 0);
		tf.setText(c.gameString());
		
		innerPane.getChildren().addAll(tf);
		getChildren().addAll(innerPane);
	}
}
