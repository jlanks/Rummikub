package core;

public class StrategyThree implements Play {

	public String Name() {
		// TODO Auto-generated method stub
		return "S3";
	}

	public int play(Game game) {
		// TODO Auto-generated method stub
		
		//System.out.print("n");
		Hand hand = game.getPlayer().getHand();
		Player player = game.getPlayer();
		Hand temp = new Hand(hand);
		//Hand temp2 = new Hand(hand);
		
		if(temp.IdRuns() + temp.IdSets() > 29 && !game.checkFirst()) {
			System.out.print("jvjrv");
			if(game.getPlayer().getHand().getSize()>0)
			hand.makeSet(game, game.getPlayer().getHand().getTile(0));
			if(hand.getSize()>0)
			game.getPlayer().getHand().makeRun(game, game.getPlayer().getHand().getTile(0));
			game.playFirst();	
		}
		
		else if(temp.IdRuns() + temp.IdSets() == game.getHandsum() && game.checkFirst()) {
			System.out.print("jvjrv");
			if(game.getPlayer().getHand().getSize()>0) {
				
				game.getPlayer().getHand().makeRun(game, game.getPlayer().getHand().getTile(0));
				if(game.getPlayer().getHand().getSize()>0) {
					game.getPlayer().getHand().makeSet(game, game.getPlayer().getHand().getTile(0));
				}
			}
		
		}
		
		else if (game.getPlayer().checkFirst() && this.checkDiff(game)){
			
			
				
						if(game.getPlayer().getHand().getSize()>0)
							game.getPlayer().getHand().makeSet(game, player.getTile(0));
						if(game.getPlayer().getHand().getSize()>0)
							game.getPlayer().getHand().makeRun(game, player.getTile(0));
					
		
					
			
		}
		
		else {
			//System.out.print("n");
			game.getTable().drawTile(game.getPlayer());
			
		}
		return 0;
		
		
	}

	
	
	public boolean checkDiff(Game game) {
		int sum = 1; 
		
		for(int i =0; i< game.getTable().getPlayers().size();i++) 
		
			if(game.getPlayer().getHandSize() - game.getTable().getPlayers().get(i).getHandSize() >= 3) 
			
				sum ++; 
		
		
		if(sum == game.getTable().getPlayers().size())
			
			return true; 
		
		return false; 
	
	}
}
