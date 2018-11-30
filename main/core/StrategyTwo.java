package core;

public class StrategyTwo implements Play {

	public String Name() {

		return "S2";

	}

	public int play(Game game) {
		Hand temp = game.fakeHand();
		if(game.getNumMelds() < 1) {
			
			return -1; 
		}
		
		else if(temp.IdRuns()+temp.IdSets() > 29 && !game.getPlayer().checkFirst()) {
			
			if(game.currHandSize()>2) {
				
				game.getCurrHand().makeSet(game, game.getCurrHand().getTile(0));
			}
			
		
			if(game.currHandSize()>2) {
			
				game.getCurrHand().makeRun(game, game.getCurrHand().getTile(0));
			}
			
		return 0;
		}
		
		return -1;
	}
	
}
