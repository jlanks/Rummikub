package core;

import java.util.ArrayList;

public class Table {
	private Deck deck;
	private Player p1 = null;
	private Player p2 = null;
	private Player p3 = null;
	private Player p4 = null;
	private ArrayList<Player> player = new ArrayList<Player>();
	//this.player.add(p1); 
	//private Player p4;
	private ArrayList<Meld> melds = new ArrayList<Meld>();
	private StrategyOne s1 = new StrategyOne();
	private StrategyTwo s2 = new StrategyTwo();
	private StrategyTwo s3 = new StrategyTwo();	//CHANGE THIS LINE WHEN S3 IS DONE
	private StrategyHuman sh = new StrategyHuman();

	public Table() {
		deck = new Deck();
		p1 = new Player("Human Player", sh);
		p2 = new Player("S1", s1);
		p3 = new Player("S2", s2);
		p4 = new Player("S3", s3);
		//p4 = new Player("Player 4");
		player.add(p1); 
		player.add(p2); 
		player.add(p3); 
		player.add(p4); 
	}

	public void initPlayerN(Player p) {	//Sequentially initializes four players. VERY UNSTABLE.
		if(p1.getName().equals("Human Player")) {
			p1 = p;
		} else if (p2.getName().equals("S1")){
			p2 = p;
		} else if (p3.getName().equals("S2")) {
			p3 = p;
		}else if (p4.getName().equals("S3")) {
			p4 = p;
		}
	}
	public ArrayList<Player> getPlayers(){
		return player; 
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
		p.getHand().sortHand();
	}

	public void init() {
		deck.Shuffle();
		deck.Shuffle();	//three times for good randomness
		deck.Shuffle();
		for (int i = 0; i < 14; i++) {
			p1.addTile(deck.getTopTile());
			p2.addTile(deck.getTopTile());
			p3.addTile(deck.getTopTile());
			p4.addTile(deck.getTopTile());
		}
		p1.getHand().sortHand();
		p2.getHand().sortHand();
		p3.getHand().sortHand();
		p4.getHand().sortHand();
	}

	public Player player1() {
		return p1;
	}

	public Player player2() {
		return p2;
	}

	public Player player3() {
		return p3;
	}
	public Player player4() {
		return p4;
	}

	
	public Meld getNext(Meld m) {
		if(melds.indexOf(m)+1 < melds.size() ) {
			return melds.get(melds.indexOf(m)+1); 
		}
		return null; 
	}
	
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

	public ArrayList<Meld> getMeldList() {
		return melds;
	}

}
