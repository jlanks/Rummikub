package core;

import java.util.ArrayList;

public class StrategyOne implements Play {

	public String Name() {

		return "S1";
	}
<<<<<<< HEAD

	// function which tries and make a set in with the players tiles.
	public void makeSet() {

	}

	// function which tries and make a run in with the players tiles.
	public void makeRun() {

	}

=======
	
	// function which tries and make a set in with the players tiles. 
	public void makeRun() {
		
		
		
		
	}
	
	// function which tries and make a run in with the players tiles. 
	public void makeSet(Game game) {
		
		ArrayList<Colour> col = new ArrayList<Colour>(); 
		ArrayList<Tile> tempmeld = new ArrayList<Tile>(); 
		ArrayList<Tile> hand = game.getPlayer().getHand(); 
		Player player = game.getPlayer(); 
		Tile compare; 
		Table table = game.getTable();
		compare = hand.get(0); 
		
		
		int cond = 0; 
		while(cond != hand.size()) {
		
			// adding tiles with all the same value
			for(int i = 0; i<hand.size(); i++) {
				
				if(hand.get(i).getValue() == compare.getValue()) {
					
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
				
			}
			
			// if the meld is valid, it will be added to the table
			table.addMeld(addmeld);
			
		}
		
		
		
	}
	
>>>>>>> bfdc04fb70341fb6eb00db0afbebd025ba0d63a3
	// function which tries to add to an existing meld
	public void addToExisting() {

	}

	public int play(Game game) {

		// needs to try and make a set

		// loop through the hand and checking the meld
		// combinations that could be made.
		// if any.

		// game.getPlayer().getHand();

		// needs to try and and make a run

		// needs to try and add to and existing meld
		return 0;
	}
}