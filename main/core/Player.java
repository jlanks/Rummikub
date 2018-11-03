package core;

import java.util.ArrayList;

public class Player {

	// players name
	private String pName;
	private Play strat;
	// players hand
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	// indicates if player is playing or waiting for their turn
	private boolean DoneTurn = false;

	public Player(String PName, Play s) {
		this.strat = s;
		pName = PName;
	}

	public Player(String PName) {

		pName = PName;
	}

	public int Play(Game g) {
		return this.strat.play(g);
		// return 0;
	}
	public void ClearHand() {
		
		hand.clear();
	}

	public ArrayList<Tile> getHand() {

		return hand;
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
		if (this.getHandSize() == 0)
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

	public boolean RemoveTile(Tile t) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).equals(t)) {
				hand.remove(i);
				return true;
			}
		}
		return false;
	}
}
