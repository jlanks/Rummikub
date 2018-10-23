package core;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	public LinkedList<Tile> Tiles = new LinkedList<Tile>();

	// constructors

	public Deck() {
		this(false);
	}

	public Deck(boolean shuff) {
		for (int r = 0; r < 2; r++) {
			// loops through suits
			for (int j = 0; j < 4; j++) {

				// loops through numbers
				for (int i = 1; i < 14; i++) {
					Tile CurrentC;
					CurrentC = new Tile(Colour.values()[j], i);
					Tiles.add(CurrentC);

				}

				if (shuff) {
					Shuffle();
				}
			}
		}
	}

	// shuffle method
	public boolean Shuffle() {

		Collections.shuffle(Tiles);

		return true;
	}

	// gets card at index specified

	public Tile getCard(int index) {
		return Tiles.get(index);
	}

	// returns the size of the deck
	public int getDeckSize() {
		return Tiles.size();
	}

	// gets and removes the top card from deck
	public Tile getTopTile() {
		return Tiles.pop();

	}

	public void printDeck() {
		for (int i = 0; i < Tiles.size(); i++) {
			System.out.printf(Tiles.get(i).toString() + "\n");

		}
	}
}
