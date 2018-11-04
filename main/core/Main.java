package core;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.getTable().init();
		
		while(!game.hasWinner()) {
			System.out.println("\n");
			game.show();
			game.getPlayer().Play(game);
			game.nextTurn();
		}
		
		game.end();
	}

}
