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
		
		ArrayList<Colour> col = new ArrayList<Colour>(); 
		
		ArrayList<Tile> tempmeld = new ArrayList<Tile>(); 
		// for testing 
		ArrayList<Tile> hand = game.getTable().player2().getHand(); 
		// for game use
		//ArrayList<Tile> hand = game.getPlayer().getHand(); 
		
		Player player = game.getPlayer(); 
		
		Tile compare = t; 
		
		Table table = game.getTable();
		
		
		
		
		
		
		// adding tiles with all the same value
		
		for(int i = 0; i<hand.size(); i++) {
			
			if(hand.get(i).getValue() == compare.getValue() && hand.get(i).getColour() != compare.getColour() ) {
				
				tempmeld.add(hand.get(i));
			
			}
		}
		
		// removing duplicate colours if any
		for(int i =0;i<tempmeld.size();i++) {
			
			if(col.contains(tempmeld.get(i).getColour())) 
				
				tempmeld.remove(i); 
				
		}	
		
		// making the meld to be added to the table
		Meld addmeld = new Meld(tempmeld);
		
		// making sure the meld is valid
		if(addmeld.validMeld()) {
		
			// if the meld is valid then the cards from the players hand need to be removed
			for(int i=0;i<tempmeld.size();i++) {
				
					hand.remove(tempmeld.get(i)); 
				}
			
			// if the meld is valid, it will be added to the table
			table.addMeld(addmeld);
			return; 
			
		}
		
			
			
		
		
		
	}
	

	// function which tries to add to an existing meld
	public void makeAdditions(Game game) {
		
		
		
		 
		

	}

	public int play(Game game) {

		// needs to try and make a set for each index of the hand
		for(int i=0;i<game.getPlayer().getHand().size();i++) {
			
			makeSet(game,game.getPlayer().getTile(i)); 
		}
		
		makeAdditions(game); 
		// loop through the hand and checking the meld
		// combinations that could be made.
		// if any.
		 
		// game.getPlayer().getHand();
		System.out.println("got to line 38 in s1");
		// needs to try and and make a run

		// needs to try and add to and existing meld
		return 0;
	}
}