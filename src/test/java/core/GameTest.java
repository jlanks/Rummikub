package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testinit() {

		// creating a game
		Game gameone = new Game();

		// making sure a player on a table is accessible
		assertEquals("Player 1", gameone.getTable().player1().getName());

		// initializing the table for the game
		gameone.getTable().init();
		
		// making sure a player has a full hand after init
		assertEquals(14, gameone.getTable().player1().getHandSize());

	}
	
	@Test
	public void testCheckWinner() {
		
		// creating a game
		Game gameone = new Game();

		// hand has not yet been delt. since the winning condition is
		// to have zero tiles checkwinner should return true

		// testing a table with a player with zero tiles
		assertEquals(true, gameone.getTable().player1().checkWinner());
		
		// adding cards into the picture
		gameone.getTable().init();
		
		// testing an game with no current winner returns false
		assertEquals(false, gameone.getTable().player1().checkWinner());

	}
	
	@Test
	public void testNextPlayer() {
		
		// creating a game
		Game gameOne = new Game(); 
		
		// tests p1 is default starting player
		assertEquals("Player 1",gameOne.getPlayer().getName()); 
		
		// next turn, currPlayer is switched to p2
		gameOne.nextTurn();
		// making sure switch from p1 - p2 was successful 
		assertEquals("Player 2",gameOne.getPlayer().getName()); 
		
		// next turn, currPlayer is switched to p3
		gameOne.nextTurn();
		// making sure switch from p2 - p3 was successful 
		assertEquals("Player 3",gameOne.getPlayer().getName()); 
		
		// next turn, currPlayer is switched to p1
		gameOne.nextTurn();
		// making sure switch from p3 - p1 was successful 
		assertEquals("Player 1",gameOne.getPlayer().getName()); 
		
	}
	public void testPlaying() {
		// making game
		Game game = new Game();
		
		// initializing table
		game.getTable().init();
		
		// testing a player can play their turn
		//assertEquals(0,game.getPlayer().Play(game)); 
		
		game.getPlayer().Play(game); 
		
		// testing a player can add a meld to a table
		assertEquals(1,game.getTable().numMelds()); 
		
		
	}
}
