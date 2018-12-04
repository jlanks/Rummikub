//TEST ONLY WORKS WHEN VIEWS TAKE GAME ARGUMENT


//package core;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//@SuppressWarnings("restriction")
//public class MainViewTest extends Application {
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		Game game = new Game();
//		game.InitGame();
//		// give player2 the tiles to play a melds to the table
//		game.nextTurn();
//		game.getPlayer().addTile(new Tile("O10"));
//		game.getPlayer().addTile(new Tile("G10"));
//		game.getPlayer().addTile(new Tile("B10"));
//		game.getPlayer().Play(game);
//		MainView myPannel = new MainView(game);
//		primaryStage.setTitle("Rummikub");
//		primaryStage.setResizable(true);
//		primaryStage.setScene(new Scene(myPannel, 600, 400)); // Keep the X value consistent with the X value of the SelectPlayersView
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//}