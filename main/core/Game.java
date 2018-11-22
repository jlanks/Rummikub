package core;

import java.util.ArrayList;

public class Game {
	private Table table;
	private boolean isOver = false;
	private Player currPlayer;

	public Game() {
		table = new Table();
		currPlayer = table.player1();
	}

	
	public boolean isOver() {
		return isOver;
	}
	public boolean InitGame() {
		
		table.init(); 
		return true; 
	}
	public ArrayList<String> getCurrHand() {
		return currPlayer.getSHand(); 
	}
	public Table getTable() {
		return table;
	}
	public int getNumMelds() {
		return table.numMelds(); 
	}
	public int currHandSize() {
		
		return currPlayer.getHandSize();
	}
	public ArrayList<String> getMeldsStrings(){
		return table.getMeldsString(); 
	}

	public Player getPlayer() {
		return currPlayer;
	}
	public boolean checkFirst() {
		
		return this.getPlayer().checkFirst();
	}
	public void playFirst() {
		this.getPlayer().playedFirst();
	}
	public int getAvailMeldSum() {
		return currPlayer.getAvailMeldSum(); 
	}
	public Player getNextPlayer() {
		if (currPlayer.getName() == "Human Player") {
			return table.player2();
		} else if (currPlayer.getName() == "Player 1") {
			return table.player3();
		} else {
			return table.player1();
		}
	}

	public void nextTurn() {
		table.drawTile(currPlayer);
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
			currPlayer.sortHand();
			gameStr += "\nTiles: " + currPlayer.getHand();
		}

		System.out.println(gameStr);
	}

	public void end() {
		System.out.println("\nThank you for playing!\n\n");
		isOver = true;
	}
	
	//Tests if the current player has won the game
	public boolean hasWinner() {
		if(currPlayer.getHandSize() <= 0) {
			isOver = true;
			return true;
		} else {
			return false;
		}
	}
}
