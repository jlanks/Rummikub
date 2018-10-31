package core;

import java.util.ArrayList;

public class Table {
	Deck deck;
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	ArrayList<Meld> melds = new ArrayList<Meld>();

	public Table() {
		deck = new Deck();
		p1 = new Player("Player 1");
		p2 = new Player("Player 2");
		p3 = new Player("Player 3");
		p4 = new Player("Player 4");
	}

	public int numMelds() {
		return melds.size();
	}

	public void addMeld(Meld m) {
		melds.add(m);
	}

	public void drawTile(Player p) {
		p.addTile(deck.getTopTile());
	}

	public void init() {
		deck.Shuffle();
		for (int i = 0; i < 14; i++) {
			p1.addTile(deck.getTopTile());
			p2.addTile(deck.getTopTile());
			p3.addTile(deck.getTopTile());
			p4.addTile(deck.getTopTile());
		}
	}

	public Player player1() {
		return p1;
	};

	public Player player2() {
		return p2;
	};

	public Player player3() {
		return p3;
	};

	public Player player4() {
		return p4;
	};

	public void remMeld(Meld m) {

		for (int i = 0; i < melds.size(); i++) {

			// THIS FUNCTION NEEDS TO BE IMPLEMENTED STILL
			// (EQUALS)
			// WILL SOLVE REMOVING MELDS THAT "LOOK" LIKE DUPLICATES
			// ALSO COULD BE SOLVED USING A RETURN ON THE FIRST MELD REMOVED

			if (melds.get(i).equals(m)) {

				melds.remove(i);

				// return;
			}
		}
	}

	public void remMeld(int i) {
		melds.remove(i);
	}

}
