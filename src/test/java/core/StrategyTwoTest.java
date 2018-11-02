package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyTwoTest {

	@Test
	public void testConst() {

	}

	@Test
	public void testPlay() {

		// testing a player can use strategy two through a player

		// making a game
		Game game = new Game();

		// making a StrategyTwo instance
		StrategyTwo s2 = new StrategyTwo();

		// making a player with StrategyTwo
		Player y = new Player("Julian", s2);

		// trying to play StategyTwo through player y
		assertEquals(0, y.Play(game));

	}

}