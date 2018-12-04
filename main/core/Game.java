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

	public void Play() {
		currPlayer.Play(this);
	}
	
	public boolean isOver() {
		return isOver;
	}
	public boolean InitGame() {
		
		table.init(); 
		return true; 
	}
	public ArrayList<String> getCurrSHand() {
		return currPlayer.getSHand(); 
	}
	public Hand getCurrHand() {
		return currPlayer.getHand(); 
	}
	public Table getTable() {
		return table;
	}
	public int getHandsum() {
		return currPlayer.getSum(); 
	}
	public ArrayList<Meld> getMelds(){
		return table.getMeldList();
	}
	public ArrayList<Meld> getFakeMelds(){
		ArrayList<Meld> m  = new ArrayList<Meld>(); 
		for(Meld mel:table.getMeldList()) {
			m.add(mel);
		}
		return m;
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
		return currPlayer.getHand().IdRuns() + currPlayer.getHand().IdSets();
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
	public Hand fakeHand() {
		Hand hand = new Hand(this.currPlayer.getHand());
		return hand; 
	}
	public void nextTurn() {
		//table.drawTile(currPlayer);  Don't think this should be here so commented it out. May or may not be important. -Noah
		// ^could be an issue if our AI no longer have a method of drawing a tile. -N
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
