package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyTwoTest {



//@Test
public void testPlayGameRunSet() {

	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t7); 
	game.getPlayer().addTile(t11); 
	game.getPlayer().addTile(t13); 
	game.getPlayer().addTile(t12); 
	
	// random tiles for more game like testing
	
	
	game.getPlayer().addTile(t10); 
	game.getPlayer().addTile(t13); 
	/**/
	game.getPlayer().addTile(t5); 
	game.getPlayer().addTile(t6); 
	game.getPlayer().addTile(t7); 
	game.getPlayer().addTile(t7); 
	//game.getCurrHand().sortHand();
	assertEquals(10,game.currHandSize());
	assertEquals("Player 3",game.getPlayer().getName());
	
	game.getPlayer().Play(game);
	assertEquals(3,game.currHandSize());
	assertEquals("Player 3",game.getPlayer().getName());
	assertEquals(2,game.getNumMelds());
	
	
	
	
	
	}	

@Test
public void testCantPlay() {
	
	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t11);
	game.getPlayer().addTile(t12);
	game.getPlayer().addTile(t13);
	assertEquals(3,game.currHandSize());
	game.Play(); 
	 
	assertEquals(3,game.currHandSize());
	// adding a meld to the table
	Meld m = new Meld(t5,t6,t7,false);
	game.getTable().addMeld(m);
	assertEquals(1,game.getNumMelds());
	assertEquals(3,game.currHandSize());
	game.Play(); 
	assertEquals(0,game.currHandSize());
	assertEquals(2,game.getNumMelds());
	
	
	
	
}

@Test
public void testPlaystowin() {
	
	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t11);
	game.getPlayer().addTile(t12);
	game.getPlayer().addTile(t13);
	game.getPlayer().addTile(t13);
	assertEquals(4,game.currHandSize());
	game.Play(); 
	 
	assertEquals(4,game.currHandSize());
	// adding a meld to the table
	Meld m = new Meld(t5,t6,t7,false);
	game.getTable().addMeld(m);
	assertEquals(1,game.getNumMelds());
	assertEquals(4,game.currHandSize());
	game.playFirst();
	game.Play(); 
	assertEquals(5,game.currHandSize());
	assertEquals(1,game.getNumMelds());
	
	
	
	
	
}
}
