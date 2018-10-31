package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyOneTest {

	public void testConst() {
		
		// making a game
		Game game = new Game();
		
		// initializing the game table
		game.getTable().init();
		
		// making an instance of StrategyOne
		StrategyOne strat = new StrategyOne();
		
		// testing that play returns zero
		assertEquals(0,strat.play(game));
		
		
	}
	@Test
	public void testPlay() {
			
		// making a game
		Game game = new Game();
			
		// testing a player can use strat one
			
		// making an instance of StrategyOne
		StrategyOne s1 = new StrategyOne();
		
		
		Player p = new Player("Julian", s1);
		
		assertEquals(0, p.Play(game));
		
		
		
	}

}
