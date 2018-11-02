package core;

public class Game {
	private Table table;
	private boolean isOver = false;
	private Player currPlayer;

	public Game() {

		table = new Table();
		// table.init();
		currPlayer = table.player1();

	}

	public boolean getOver() {
		return isOver;
	}

	public Table getTable() {

		return table;
	}

	public Player getPlayer() {
		return currPlayer;
	}

	public Player getNextPlayer() {

		if (currPlayer.getName() == "Player 1") {
			return table.player2();

		}
		if (currPlayer.getName() == "Player 2") {
			return table.player3();
		}
		return table.player1();
	}

	public void nextTurn() {

		currPlayer = this.getNextPlayer();

	}

	public void show() {
		String gameStr = "";

		gameStr += currPlayer.getName() + "'s Turn: \n\n";
		gameStr += "Melds: \n";
		for (int i = 0; i < table.numMelds(); i++) {
			gameStr += "[" + table.getMeld(i) + "]\n";
		}

		if (currPlayer.getName() == "Human Player") {
			gameStr += "\nTiles: " + currPlayer.getHand();
		}

		System.out.println(gameStr);
	}

	public void end() {
		System.out.println("\nThank you for playing!\n\n");
		isOver = true;
	}
}
