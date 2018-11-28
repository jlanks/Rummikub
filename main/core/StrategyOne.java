package core;

import java.util.ArrayList;

public class StrategyOne implements Play {

	public String Name() {

		return "S1";
	}


	
	public int play(Game game) {

		Hand hand = game.getPlayer().getHand();
		Player player = game.getPlayer();
		//&& game.playedFirst()
		int x = 0; 
		System.out.println(hand.getSize());
		//x = hand.IdRuns() + hand.IdSets(); 
		//return x;
		
		if(hand.getSize() > 0 && hand.IdSets() + hand.IdRuns()  > 29)
		    {
			System.out.print((int)hand.getSize());
			//System.out.println(hand.IdSets() + hand.IdRuns());
			
			
			
			hand.sortHand();
			game.getPlayer().getHand().makeRun(game,game.getPlayer().getHand().get(0));
			
			 if(hand.getSize() > 2) {
				 System.out.println("!!!");
				 hand.sortHand();
				game.getPlayer().getHand().makeSet(game,game.getPlayer().getHand().get(0)); 
			 }
		}	
		
		
		if(hand.getSize() == 0) {
			System.out.println(player.getName() + " WINS THE GAME!");
			game.end(); 
			return 1;
		}
		return 0;
		/**/
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
	

	
}