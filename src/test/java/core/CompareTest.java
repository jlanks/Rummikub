package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest {

	@Test
	public void testMeldInHandSum() {
		// make a hand 
		Hand hand = new Hand(); 
		
		
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// making tiles 
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		// *******************************************8
		Game game = new Game(); 
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		//adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7); 
		//hand.add(t13); 
		
		//testing the sum of get runsum is 24
		int x =0; 
		assertEquals(hand.getRunSum(hand,hand.get(0),x),24); 
		// testing the players hand isnt touched
		assertEquals(hand.getSize(),3); 
		
		hand.clearHand();
		assertEquals(hand.getSize(),0); 
		hand.add(t13); 
		hand.add(t12); 
		hand.add(t11); 
	//	hand.add(t5);
		x = 0; 
		assertEquals(hand.getSetSum(hand,hand.get(0),x),39); 
		// testing the players hand isnt touched
				assertEquals(hand.getSize(),3); 
		
		
	}
	@Test
	public void testPlayAdd2() {
		
		Game game = new Game();
		game.nextTurn();
		Hand hand = new Hand(); 
		hand = game.getCurrHand(); 
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		t14 = (new Tile(Colour.Red, 13));
		//game.getPlayer().addTile(t5); 
		hand.add(t6); 
		hand.add(t7);
		hand.add(t8);
		hand.add(t14);
		//game.getPlayer().addTile(t9); 
		
		
		assertEquals(4,hand.getSize());
		
		int sum = 0;  
		hand.sortHand();
		
		//assertEquals(game.getCurrHand().);
		
		assertEquals(27,hand.getRunSum(hand,hand.get(0), sum)); 
		assertEquals(game.getNumMelds(),0);
		game.getPlayer().Play(game); 
		
		// testing the meld is not played since it is the first turn and not above 30
		assertEquals(false,game.getPlayer().checkFirst());
		assertEquals(game.getNumMelds(),0);
		assertEquals(game.currHandSize(),3); 
		
		
		
		
	}
	
}
