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
		// this means the table will have a meld on it of correct size
		assertEquals(4, game.getTable().getMeld(0).getSize());
		
		P1.getHand().clear();
		
		// making sure the players hand is empty
		assertEquals(0,P1.getHandSize()); 
		
		// giving p1 the cards to make a set (3) but with other tiles in the "hand"
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 13));
		P1.addTile(new Tile(Colour.Blue, 1));
		P1.addTile(new Tile(Colour.Green, 4));
		P1.addTile(new Tile(Colour.Orange, 6));
		P1.addTile(new Tile(Colour.Blue, 8));
		P1.addTile(new Tile(Colour.Green, 10));
		P1.addTile(new Tile(Colour.Orange, 10));
		
		System.out.print(P1.getHand().toString());
		// making sure the players hand has 8 tiles
		assertEquals(8,P1.getHandSize()); 
		// player makes their move
		
		P1.Play(game);
		System.out.print(P1.getHand().toString());
		// this means hand size will be five
		assertEquals(5, P1.getHandSize());

		// this means the table will have 2 meld on it
		assertEquals(2, game.getTable().numMelds());
		// testing that the hand size has been updated
		assertEquals(5, P1.getHandSize());
		// resetting hand 
		P1.getHand().clear();
		// making sure the players hand is empty
		assertEquals(0,P1.getHandSize()); 
		
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
		assertEquals(4,game.getTable().player2().getHandSize());
		
		
		// now need to test running this process when the player has more than
		// one set available to make
		
		// clearing hand 
		P1.getHand().clear();
		
		// testing if call was successful
		assertEquals(0,P1.getHandSize()); 
		
		// making 2 sets in the players hand 
		// this hand has a set of 9s and 10s. 
		// both of size 3 
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 9));
		P1.addTile(new Tile(Colour.Blue, 10));
		P1.addTile(new Tile(Colour.Green, 4));
		P1.addTile(new Tile(Colour.Orange, 6));
		P1.addTile(new Tile(Colour.Blue, 9));
		P1.addTile(new Tile(Colour.Green, 9));
		P1.addTile(new Tile(Colour.Orange, 10));
	
		// testing if hand size is correct
		assertEquals(8,P1.getHandSize()); 
		
		
		
		
		
	}
	/*
	public void testMakeRun() {
		
		
		
		
	}
	*//*
	@Test
	public void testMakeAdditions() {
		
				// making a game

				Game game = new Game();
				Player P1 = game.getTable().player2();
				Meld m = new Meld(new Tile(Colour.Red, 10),new Tile(Colour.Blue, 10),new Tile(Colour.Green, 10),false); 
				// giving p1 the cards to make a set
				
				//P1.addTile();
				//P1.addTile();
				//P1.addTile();
				P1.addTile(new Tile(Colour.Orange, 10));
				
				
				game.nextTurn();
				
				// testing adding to an existing set
				P1.Play(game); 
				// checks the player no longer has a card in their hand
				assertEquals(0,P1.getHandSize()); 
				// checks the card has been added to the meld
				assertEquals(4,game.getTable().getMeld(0).getSize()); 
				
				
				// next test adding to an existing run. 
				// this needs to be tested in the front, middle, and back of the meld
				
				// front
				
				
				// middle
				
				// back 
		
	}
*/
}
