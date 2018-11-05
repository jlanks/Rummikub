package core;

public class StrategyTwo implements Play {

	public String Name() {

		return "S2";

	}

	public int play(Game game) {
		game.getTable().drawTile(game.getPlayer());
		return 0;
	}

}
