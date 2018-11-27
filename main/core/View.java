package core;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class View extends Pane{
	
	public View() {
		Pane viewPane = new Pane();

		SelectPlayersView numPlayers = new SelectPlayersView();
	
		(viewPane.getChildren()).addAll(numPlayers);	
		getChildren().addAll(viewPane);
	}
}
