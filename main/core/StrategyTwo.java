package core;

public class StrategyTwo implements Play {

	public String Name() {

		return "S2";

	}

	public int play(Game game) {
		
		game.getCurrHand().makeSet(game, game.getCurrHand().getTile(0));
		return 0;
	}

}
