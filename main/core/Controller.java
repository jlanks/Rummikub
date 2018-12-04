package core;

import java.util.ArrayList;
import java.util.Arrays;

//TODO updating the player's hand and melds on table in game

public class Controller {
	Game game;

	Controller(Game g) {
		game = g;
	}

	public Game getGame() {
		return game;
	}
	
	public Table getTable() {
		return game.getTable();
	}

	public Player getCurrPlayer() {
		return game.getPlayer();
	}

	public ArrayList<String> getCurrHand() {
		game.getCurrHand().sortHand();
		return game.getCurrSHand();
	}
	
	public int indexOfMeld(String meldStr) {
		meldStr.trim();	//get rid of trailing whitespace
		ArrayList<String> meldAR = new ArrayList<String>(Arrays.asList(meldStr.split(" ")));
		ArrayList<Tile> tileAR = new ArrayList<Tile>();
		for(int i = 0; i < meldAR.size(); i++) {
			tileAR.add(new Tile(meldAR.get(i)));
		}
		Meld meld = new Meld(tileAR);
		Table t = game.getTable();
		for(int i = 0; i < t.numMelds(); i++) {
			if(t.getMeld(i).equals(meld)) {
				return i;
			}
		}
		return -1;
	}

	public String gameString() {
		String s = game.getPlayer().getName() + "'s turn.\n\n\n";
		
		game.getTable().player1().getHand().sortHand();
		game.getTable().player1().getHand().sortHand();
		game.getTable().player1().getHand().sortHand();

		//TODO show points
		s += game.getTable().player1().getName() + "\'s hand:\n" + game.getTable().player1().getHand() + "\n\n";
		s += game.getTable().player2().getName() + "\'s hand:\n" + game.getTable().player2().getHand() + "\n\n";
		s += game.getTable().player3().getName() + "\'s hand:\n" + game.getTable().player3().getHand() + "\n\n\n";
		
		s += "Hand:\n" + game.getCurrHand() + "\n\n";
		
		s += "Updated melds on table:\n";
		ArrayList<Meld> ar = game.getTable().getMeldList();
		for(int i = 0; i < ar.size(); i++) {
			s += " [" + ar.get(i) + "] ";
		}

		return s;
	}
	
	public void addPlayer(String name, String strat) {
		if(strat.equals("Strategy1")) {
			Player p = new Player(name, new StrategyOne());
			game.getTable().initPlayerN(p);
		} else if(strat.equals("Strategy2")) {
			Player p = new Player(name, new StrategyTwo());
			game.getTable().initPlayerN(p);
		} else if (strat.equals("StrategyHuman")){
			Player p = new Player(name, new StrategyHuman());
			game.getTable().initPlayerN(p);
		}
	}

	public void addMeld(ArrayList<String> meldStr) {
		//System.out.println("meldStr: " + meldStr);
		
		ArrayList<Tile> meldAR = new ArrayList<Tile>();
		for(int i = 0; i < meldStr.size(); i++) {
			meldAR.add(new Tile(meldStr.get(i)));
		}
		//System.out.println("MeldAR: " + meldAR);
		Meld meld = new Meld(meldAR);
		game.getTable().addMeld(meld);
	}

	public void updateMeld(int index, ArrayList<String> meldStr) {
		System.out.println("RemMeld index " + index + ": " + game.getTable().getMeld(index) + "\n");
		game.getTable().remMeld(index);	//could also do a swapMeld method in Table
		addMeld(meldStr);
	}

	public void updateHand(ArrayList<String> handStr) {
		Hand newHand = new Hand();
		for(int i = 0; i < handStr.size(); i++) {
			newHand.add(new Tile(handStr.get(i)));
		}
		game.getPlayer().updateHand(newHand);
	}
	
	public void nextTurn() {
		game.getPlayer().Play(game);
		game.nextTurn();
	}
}
