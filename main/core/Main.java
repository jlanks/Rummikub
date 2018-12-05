package core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Game game = new Game();
		game.getTable().init();	// Does the same thing as game.InitGame()
		
		/** GAME RIGGING **/
		//Give to HumanPlayer:
		game.getTable().player1().addTile(new Tile("R9"));
		game.getTable().player1().addTile(new Tile("R10"));
		game.getTable().player1().addTile(new Tile("R11"));
		game.getTable().player1().addTile(new Tile("G5"));
		game.getTable().player1().addTile(new Tile("B5"));
		game.getTable().player1().addTile(new Tile("O5"));
		
		//Give to S1:
		game.getTable().player2().addTile(new Tile("G9"));
		game.getTable().player2().addTile(new Tile("G10"));
		game.getTable().player2().addTile(new Tile("G11"));
		
		//Give to S2:
		game.getTable().player3().addTile(new Tile("R8"));
		game.getTable().player3().addTile(new Tile("R5"));
		game.getTable().player3().addTile(new Tile("R12"));
		
		//Give to S3:
		game.getTable().player4().addTile(new Tile("B9"));
		game.getTable().player4().addTile(new Tile("B10"));
		game.getTable().player4().addTile(new Tile("B11"));
		game.getTable().player4().addTile(new Tile("R13"));
		game.getTable().player4().addTile(new Tile("R7"));
		game.getTable().player4().addTile(new Tile("R5"));
		
		
		//Sort the new hands
		game.getTable().player1().getHand().sortHand();
		game.getTable().player2().getHand().sortHand();
		game.getTable().player3().getHand().sortHand();
		game.getTable().player4().getHand().sortHand();
		/******************/

		Controller controller = new Controller(game);
		MainView myPannel = new MainView(controller);
		
		primaryStage.setTitle("Rummikub");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(myPannel, 600, 400)); // Keep the X value consistent with the X value of the SelectPlayersView
		primaryStage.show();
	}
}
