package core;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class ViewTest extends Application{

	public void start(Stage primaryStage) throws Exception {
		Game game = new Game();
		game.InitGame();
		Controller c = new Controller(game);
		
		// give me tiles for a run
		game.getPlayer().addTile(new Tile("R10"));
		game.getPlayer().addTile(new Tile("R10"));
		game.getPlayer().addTile(new Tile("R11"));
		game.getPlayer().addTile(new Tile("R12"));
		
		
		// give player2 the tiles to play a melds to the table
		game.nextTurn();
		game.getPlayer().addTile(new Tile("O10"));
		game.getPlayer().addTile(new Tile("G10"));
		game.getPlayer().addTile(new Tile("B10"));
		game.getPlayer().Play(game);
		
		game.nextTurn(); //my turn
//		game.getTable().player1().getHand().sortHand();
//		game.getTable().player2().getHand().sortHand();
//		game.getTable().player3().getHand().sortHand();
		
		MainView myPannel = new MainView(c);
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 600, 400)); // Keep the X value consistent with the X value of the SelectPlayersView
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
