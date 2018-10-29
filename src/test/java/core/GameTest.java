package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testinit() {
		
			// creating a game
			Game gameone = new Game(); 
			
			// making sure a player on a table is accessible 
			assertEquals("Player 1",gameone.getTable().player1().getName()); 
			
			// making sure a player has a full hand after init
			gameone.getTable().init();
			assertEquals(14,gameone.getTable().player1().getHandSize());
		
	}
	public void testCheckWinner() {
		
		Game gameone = new Game(); 
		
		// hand has not yet been delt. since the winning condition is 
		// to have zero tiles checkwinner should return true
		
		assertEquals(true,gameone.getTable().player1().CheckWinner()); 		
	
		
		
	}
}
