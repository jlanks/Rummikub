package core;

public class StrategyThree implements Play {

	public String Name() {
		// TODO Auto-generated method stub
		return "S3";
	}

	public int play(Game game) {
		// TODO Auto-generated method stub
		
		
		Hand hand = game.getPlayer().getHand();
		Player player = game.getPlayer();
		Hand temp = new Hand(hand);
		
		
		if(temp.IdRuns() + temp.IdSets() > 29 && !game.checkFirst()) {
			hand.makeSet(game, player.getTile(0));
			hand.makeRun(game, player.getTile(0));
			game.playFirst();	
		}
		else if(temp.IdRuns() + temp.IdSets() == game.getHandsum()) {
			hand.makeSet(game, player.getTile(0));
			hand.makeRun(game, player.getTile(0));
			
		}
		else {
			
			
			
			
			
		}
		
		
		
		
		return 0;
	}
	
	

}
