package core;

import java.util.ArrayList;

public class Player {

	// players name
	private String pName;

	// players hand
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	// indicates if player is playing or waiting for their turn
	private boolean DoneTurn = false;

	public Player(String PName) {
		pName = PName;
	}

	public boolean addTile(Tile tile) {
		hand.add(tile);
		return true;
	}
	public String getName() {
		return pName; 
	}

	public Tile getTile(int i) {
		return hand.get(i);

	}
	public boolean checkWinner() {
		if(this.getHandSize() == 0)
			return true;
		return false; 
	}

	public int getHandSize() {
		return hand.size();
	}

	public boolean RemoveTile(int i) {
		if (i > hand.size() - 1) {
			return false;
		}
		hand.remove(i);
		return true;
	}

}
