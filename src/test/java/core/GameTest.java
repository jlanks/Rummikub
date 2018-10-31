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
			
			// testing a player can use strat one
			Table t = new Table(); 
			StrategyOne s1 = new StrategyOne(); 
			Player p = new Player("Julian",s1);
			assertEquals(0,p.Play(t));
			
			// testing a player can use strat two
			
			Table x = new Table(); 
			StrategyTwo s2 = new StrategyTwo(); 
			Player y = new Player("Julian",s2);
			assertEquals(0,y.Play(x));
			
			
		
	}
	@Test
	public void testCheckWinner() {
		
		Game gameone = new Game(); 
		
		// hand has not yet been delt. since the winning condition is 
		// to have zero tiles checkwinner should return true
		
		assertEquals(true,gameone.getTable().player1().checkWinner());
		gameone.getTable().init();
		assertEquals(false,gameone.getTable().player1().checkWinner());
	
		
		
	}
}
