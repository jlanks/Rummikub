package core;

import java.util.ArrayList;

public class StrategyTwo implements Play {

	public String Name() {

		return "S2";

	}

	public int play(Game game) {
		//Hand h = game.getCurrHand(); //TODO CREATING A NEW INSTANCE HERE!!!
		Hand temp = game.fakeHand();
		ArrayList<Meld> ORIG = new ArrayList<Meld>(); 
		for(int i=0;i<game.getNumMelds();i++) {
			ORIG.add(game.getMelds().get(i));
		}
		
			
		// do nothing if no melds have been played
		if(game.getNumMelds() < 1) {
			
			return -1; 
		}
		
		// if a player hasn't played first and melds on the table
		else if(temp.IdRuns()+temp.IdSets() > 29 && !game.getPlayer().checkFirst()) {
			
			if(game.currHandSize()>2) {
				
				game.getCurrHand().makeSet(game, game.getCurrHand().getTile(0));
			}
			
		
			if(game.currHandSize()>2) {
			
				game.getCurrHand().makeRun(game, game.getCurrHand().getTile(0));
			}
			game.playFirst();
			
		return 1;
		}
		
		
		// if a player can win with the current hand, they win
		else if(temp.IdRuns() + temp.IdSets() == game.getHandsum()) {
			
			if(game.currHandSize()>2) {
				
				game.getCurrHand().makeSet(game, game.getCurrHand().getTile(0));
			}
			
		
			if(game.currHandSize()>2) {
			
				game.getCurrHand().makeRun(game, game.getCurrHand().getTile(0));
			}
			return 2; 
		}
		
		// if the player can add a card to the table and he has played his first meld 
		// then add the cards to the melds on the table
		// && game.getPlayer().checkFirst() && game.getCurrHand().getSize() >0 && game.getNumMelds()>0
		else if(temp.getTotalAddSum(game.getFakeMelds(), game.fakeHand())>0 && game.getPlayer().checkFirst()) {
			
			//System.out.print(ORIG + "1\n");
			//Try adding tiles for every meld on the table
			Meld currMeld;
			//ArrayList<Tile>  til = new ArrayList<Tile>();
			
				currMeld = game.getTable().getMeld(0);
				//System.out.println("Checking meld " + i + ": " + currMeld);
				game.getCurrHand().AddAllTiles(game, currMeld);
			/*
			//System.out.print(game.getMeldsStrings() + "hh\n");
			
			// now compare the updates melds with the original and 
			// remove from hand the tiles which were added to the table
			
			// start by looping through the updated list and compare to the orig
			for(int i =0;i<game.getFakeMelds().size();i++) {
				//System.out.print("jj\n");
				// check to see if the same size (if not then a tile has been added)
				if(game.getMelds().get(i).getSize() != ORIG.get(i).getSize()) {
					
					System.out.print(ORIG + "2\n");
					
				}
				
				
			}
			//System.out.print(til);
			for(int i=0;i<til.size();i++)
				game.getCurrHand().remove(til.get(i));
			*/	
			return 4; 
		}
		// if the player can't win, draw a card
		else  {
			
			game.getTable().drawTile(game.getPlayer());
			return 0; 
		}
		
		
		
	}
	
}
