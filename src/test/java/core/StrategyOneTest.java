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
		assertEquals(0, strat.play(game));

	}

	@Test
	public void testMakeSet() {

		// making a game

		Game game = new Game();
		Player P1 = game.getTable().player2();

		// giving p1 the cards to make a set
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Blue, 10));
		P1.addTile(new Tile(Colour.Green, 10));
		P1.addTile(new Tile(Colour.Orange, 10));
		//sgame.getTable().init();
		game.nextTurn();
		
		// player should make a set and add it to the table
		// player makes their move
		
		assertEquals(4, P1.getHandSize());
		P1.Play(game);

		// this means hand size will be zero
		assertEquals(0, P1.getHandSize());
		
		// this means the table will have a meld on it
		assertEquals(1, game.getTable().numMelds());
		/*
		// giving p1 the cards to make a set (3) but with other tiles in the "hand"
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 13));
		P1.addTile(new Tile(Colour.Blue, 1));
		P1.addTile(new Tile(Colour.Green, 4));
		P1.addTile(new Tile(Colour.Orange, 6));
		P1.addTile(new Tile(Colour.Blue, 8));
		P1.addTile(new Tile(Colour.Green, 10));
		P1.addTile(new Tile(Colour.Orange, 10));

		// player makes their move

		P1.Play(game);

		// this means hand size will be five
		assertEquals(5, P1.getHandSize());

		// this means the table will have 2 meld on it
		assertEquals(2, game.getTable().numMelds());

		// giving p1 the cards to make a set (4) but with other tiles in the "hand"
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 13));
		P1.addTile(new Tile(Colour.Blue, 10));
		P1.addTile(new Tile(Colour.Green, 4));
		P1.addTile(new Tile(Colour.Orange, 6));
		P1.addTile(new Tile(Colour.Blue, 8));
		P1.addTile(new Tile(Colour.Green, 10));
		P1.addTile(new Tile(Colour.Orange, 10));

		// player makes their move

		P1.Play(game);

		// this means the table will have 3 meld on it
		assertEquals(3, game.getTable().numMelds());
		*/
	}

}
