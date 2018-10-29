package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	
	public void testConstructor() {
		// creating a game
		Game gameone = new Game(); 
		
		// making sure a player on a table is accessible 
		assertEquals("Player1",gameone.getTable().PlayerOne().getName()); 
		
		// making sure a player has a full hand
		assertEquals(14,gameone.getTable().PlayerOne().getHandSize());
		
		
		
	}
	
	
	

	

}
