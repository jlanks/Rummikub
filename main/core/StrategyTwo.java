package core;

public class StrategyTwo implements Play {

	public String Name() {

		return "S2";

	}

	public int play(Game game) {
		
		Hand temp = game.fakeHand();
		
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
		else if(temp.getTotalAddSum(game.getFakeMelds(), game.fakeHand())>0 ) {
			//System.out.print("jsc");
			Hand handy = game.getCurrHand(); 
			handy.AddAllPossible(game.getMelds());
			return 4; 
			
		}
		// if the player cant win, draw a card
		else if(temp.IdRuns() + temp.IdSets() != game.getHandsum()) {
			
			game.getTable().drawTile(game.getPlayer());
			return 0; 
		}
		
		
		return -1;
	}
	
}
