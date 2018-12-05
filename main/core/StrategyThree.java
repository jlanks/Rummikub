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
			//System.out.print("n");
			if(hand.getSize()>0)
			hand.makeSet(game, player.getTile(0));
			if(hand.getSize()>0)
			hand.makeRun(game, player.getTile(0));
			game.playFirst();	
		}
		
		else if(temp.IdRuns() + temp.IdSets() == game.getHandsum() && game.checkFirst()) {
			//System.out.print("l");
			if(hand.getSize()>0) {
				
				hand.makeRun(game, player.getTile(0));
				if(hand.getSize()>0) {
				hand.makeSet(game, player.getTile(0));
				}
			}
		
		}
		
		else {
			
			int sum = 1; 
			
			if(player.checkFirst()) {
			
				for(int i =0; i< game.getTable().getPlayers().size();i++) {
				
					if(player.getHandSize() - game.getTable().getPlayers().get(i).getHandSize() >= 3) {
					
						sum ++; 
				
				
					}
			
				}
				if(sum == game.getTable().getPlayers().size()) {
						if(hand.getSize()>0)
						hand.makeSet(game, player.getTile(0));
						if(hand.getSize()>0)
						hand.makeRun(game, player.getTile(0));
					
					
				}
					
		
			}	
			else {
				game.getTable().drawTile(player);
			}
		}
		
		
		
		
		return 0;
	}
	
	

}
