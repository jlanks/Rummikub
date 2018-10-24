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

	public Tile getTile(int i) {
		return hand.get(i);

	}

	public int getHandSize() {
		return hand.size();
	}

	public RemoveTile(int i) {
		if (i > hand.size() - 1) {
			//System.out.println("INDEX ERROR: PLAYER.JAVA: REMOVETILE: LINE 30");
			return false;
		}
		hand.remove(i);
		return true;
	}

}
