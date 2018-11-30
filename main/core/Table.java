package core;

import java.util.ArrayList;

public class Table {
	private Deck deck;
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private ArrayList<Meld> melds = new ArrayList<Meld>();
	private StrategyOne s1 = new StrategyOne();
	private StrategyTwo s2 = new StrategyTwo();
	private StrategyHuman sh = new StrategyHuman();

	public Table() {
		deck = new Deck();
		p1 = new Player("Human Player", sh);
		p2 = new Player("Player 1", s1);
		p3 = new Player("Player 3", s2);
		p4 = new Player("Player 4");	//dummy player; won't be implemented in game
	}

	
	
	public ArrayList<String> getMeldsString(){
		
		ArrayList<String> stringMelds = new ArrayList<String>(); 
		for(int i=0;i<melds.size();i++) {
			
			stringMelds.add(melds.get(i).StringVersion()); 
			
		}
		return stringMelds; 
		
		
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
	public void clearMT() {
		
		melds.clear(); 
	}

	public void remMeld(int i) {
		melds.remove(i);
	}

	public Meld getMeld(int i) {
		return melds.get(i);
	}

	public Meld getMeldList() {
		return melds;
	}

}
