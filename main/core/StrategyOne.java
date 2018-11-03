package core;

import java.util.ArrayList;

public class StrategyOne implements Play {

	public String Name() {

		return "S1";
	}


	

	// function which tries and make a run in with the players tiles.
	public void makeRun() {

	}


	
	
	
	// function which tries and make a run in with the players tiles. 
	public void makeSet(Game game,Tile t) {
		
		// the list of colours already used
		ArrayList<Colour> col = new ArrayList<Colour>(); 
		
		// the temporary meld going to be used 
		ArrayList<Tile> tempmeld = new ArrayList<Tile>(); 
		
		// for testing (player 2 has the strategy one)
		ArrayList<Tile> hand = game.getTable().player2().getHand(); 
		
		// for game use (when the game is being played, 
		// this will only be called by a plyer assigned s1 
		//ArrayList<Tile> hand = game.getPlayer().getHand(); 
		
		// current player, again for when the game is set up properly
		Player player = game.getPlayer(); 
		
		// the tile which will be the comparison basis 
		Tile compare = t; 
		
		// the current games table
		Table table = game.getTable();
		
		
		
		
		//adding the tile argument to the meld array
		tempmeld.add(t); 
		
		// adding tiles with all the same value
		
		// loops through all the tiles in the players hand
		for(int i = 0; i<hand.size(); i++) {
			
			// if the value is the same, but the colour is not,
			// and the colour has not already been added
			// then add to the temp meld
			
			if(hand.get(i).getValue() == compare.getValue() && 
			   hand.get(i).getColour() != compare.getColour() &&
			   !hand.get(i).equals(t) &&
			   !(col.contains(hand.get(i).getColour()))) {
				
				// adding to tile to the temp meld
				tempmeld.add(hand.get(i));
				// adding the colour to the colour meld
				col.add(hand.get(i).getColour()); 
			
			}
		}
		
		
		// making the meld to be added to the table
		Meld addmeld = new Meld(tempmeld);
		
		// making sure the meld is valid
		if(addmeld.validMeld()) {
		
			// if the meld is valid then the cards from the players hand need to be removed
			for(int i=0;i<tempmeld.size();i++) {
					 // removing cards from hand
					hand.remove(tempmeld.get(i)); 
				}
			
			// if the meld is valid, it will be added to the table
			table.addMeld(addmeld);
			// return so the other
			return; 
			
		}
		
			
			
		
		
		
	}
	

	// function which tries to add to an existing meld
	public void makeAdditions(Game game) {
		
		
		
		 
		

	}

	public int play(Game game) {

		// needs to try and make a set for each index of the hand
		//for(int i=0;i<game.getPlayer().getHand().size();i++) {
			
			makeSet(game,game.getTable().player2().getTile(0)); 
		//}
		
		//makeAdditions(game); 
		// loop through the hand and checking the meld
		// combinations that could be made.
		// if any.
		 
		// game.getPlayer().getHand();
	//x	System.out.println("got to line 38 in s1");
		// needs to try and and make a run

		// needs to try and add to and existing meld
		return 0;
	}
}