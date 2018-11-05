package core;

import java.util.ArrayList;

public class StrategyOne implements Play {

	public String Name() {

		return "S1";
	}


	

	// function which tries and make a run in with the players tiles.
	public void makeRun(Game game, Tile t) {
		
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
					
					// if the card is higher, add it in the back
					
					if(hand.get(i).getValue() == compare.getValue() + 1 && 
							hand.get(i).getColour() == compare.getColour() &&
							!tempmeld.contains(hand.get(i))) {
						
						// adding to tile to the temp meld
						tempmeld.add(hand.get(i));
						// incrementing the compare tile
						compare = hand.get(i); 
					
					}
					
				
				}
				// making the meld to be added to the table
				Meld addmeld = new Meld(tempmeld);
					
					
				if(addmeld.validMeld()) {
					game.getTable().addMeld(addmeld);
					/*
					// remove tiles from hand
					for(int i = 0;i<addmeld.getSize();i++) {
						
						if(game.getPlayer().getHand().contains(addmeld.getTile(i))){
							game.getPlayer().RemoveTile(i);
						}
					}
					*/
				}
				
				
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
		
		// index of current tile
		int index = 0; 
		
		// looping through the hand to find the index 
		
		for(int i =0; i<hand.size();i++) {
			
			if(i == hand.size() && hand.get(i) != t) {
				
				index = -1; 
			}
			if(hand.get(i).equals(t)) {
				index = i; 
			}
		}
		
		// making sure the meld is valid
		if(addmeld.validMeld()) {
		
			// if the meld is valid then the cards from the players hand need to be removed
			for(int i=0;i<tempmeld.size();i++) {
					 // removing cards from hand
					hand.remove(tempmeld.get(i)); 
				}
			
			// if the meld is valid, it will be added to the table
			table.addMeld(addmeld);
			
			if(hand.size() > 0) 
				makeSet(game,hand.get(0)); 
			
			if(hand.size() <= 0)
				return;
		
			
		}
		
		// when the meld is not valid and index is less than hand size
		if(!addmeld.validMeld() && index < hand.size()-1) {
			
			
			makeSet(game,hand.get(index+1));
		}
		
		// when the index is at the last and meld is invalid
		if(index+1 >= hand.size() && !addmeld.validMeld()) {
			
			return; 
		}
		
			
			
		
		
		
	}
	

	// function which tries to add to an existing meld on the table 
	public void makeAdditions(Game game, Meld m, Tile t, int STOPT, int STOPM, int MELD, int TILE) {
		 
		// if there are no melds on the table, nothing to add to
		
		if(STOPM == 0) {
			
			// return if this is the case
			
			return; 
		}
		
		// if the search has ended
		
		if(STOPT == TILE && STOPM == MELD) {
			
			// return if this is the case 
			
			return; 
		}
		
		// this is if all tiles have been tried for adding to a meld
		// but there are still melds to check
		
		if(STOPT == TILE && STOPM != MELD) {
			
			// resetting the search for the next meld
			
			makeAdditions(game, game.getTable().getMeld(MELD +1), game.getPlayer().getTile(0) , STOPM, STOPT, 0,MELD+1);
			
		}
		
		
		Tile currT = game.getTable().player2().getTile(0); 
		
		Meld currM = m;  
		
		
		
		// check if the tile can be added to the front of the meld (run)
		if(currM.getTile(0).getValue() == currT.getValue()+1) {
			
			// add the tile to the front 
			currM.addFirst(currT); 
			// remove the tile from the players hand 
			game.getPlayer().RemoveTile(TILE); 
			// call the function
			makeAdditions(game, game.getTable().getMeld(MELD), game.getPlayer().getTile(TILE+1) , STOPM, STOPT, TILE+1,MELD);
			
			
		}
		
		// check if the tile can be added to the back of the meld (run)
		if(currM.getTile(currM.getSize()-1).getValue() == currT.getValue()-1) {
			
			// add the tile to the back
			currM.addTile(currT); 
			// remove the tile from the players hand 
			game.getPlayer().RemoveTile(TILE); 
			// call the function
			makeAdditions(game, game.getTable().getMeld(MELD), game.getPlayer().getTile(TILE+1) , STOPM, STOPT, TILE+1,MELD);
						
			
			
		}
		
		// check if the tile can be added to the the meld when the meld is a set 
		if(currM.getTile(currM.getSize()-1).getValue() == currT.getValue() &&
		   currM.getTile(0).getValue() == currT.getValue() &&
		   currM.getTile(currM.getSize()-1).getColour() != currT.getColour() &&
		   currM.getTile(0).getColour() != currT.getColour() &&
		   currM.getTile(0).getColour() != currT.getColour()) {
			
			// add the tile to the meld, index does not 
			// matter since this meld would be a set
			
			currM.addTile(currT);
			
			// remove the tile from the players hand 
			game.getPlayer().RemoveTile(TILE); 
			// call the function
			makeAdditions(game, game.getTable().getMeld(MELD), game.getPlayer().getTile(TILE+1) , STOPM, STOPT, TILE+1,MELD);
						
			
			
		}
		
		// if the function got this far, no tiles were valid. 
		// call the function with updated values 
		
		// call the function
		makeAdditions(game, game.getTable().getMeld(MELD), game.getPlayer().getTile(TILE+1) , STOPM, STOPT, TILE+1,MELD);
					
		
		
		
		 
		

	}

	public int play(Game game) {

		
		// making as many sets as possible
		makeSet(game,game.getTable().player2().getTile(0)); 
		makeRun(game,game.getTable().player2().getTile(0));
		// making as many runs as possible
		
		
		/*
		// making as many additions as possible
		int TNUM, MNUM, TI,MI;
		TNUM = game.getPlayer().getHandSize();
		MNUM = game.getTable().numMelds(); 
		TI = MI = 0 ; 
		//System.out.print(game.getTable().getMeld(0).toString()); 
		//makeAdditions(game,game.getTable().getMeld(0),game.getTable().player2().getTile(0),TNUM,MNUM,MI,TI); 
		/**/
		return 0;
		
	}
}