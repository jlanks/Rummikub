package core;

import junit.framework.TestCase;

public class MeldTest extends TestCase {

	public void testAddingToMeld() {

		// initializing
		Deck MainDeck = new Deck();
		Player Julian = new Player("Julian");
		Meld NewMeld, NewMeld2, NewMeld3, NewMeld4, NewMeld5, NewMeld6, NewMeld7, NewMeld8, NewMeld9, NewMeld10;
		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;

		// creating tiles to be used in melds
		t1 = (new Tile(Colour.Red, 10));
		t2 = (new Tile(Colour.Blue, 10));
		t3 = (new Tile(Colour.Green, 10));
		t4 = (new Tile(Colour.Orange, 10));
		
		
		
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 11));

		t9 = (new Tile(Colour.Red, 2));
		t10 = (new Tile(Colour.Blue, 2));
		t11= (new Tile(Colour.Green, 2));
		t12= (new Tile(Colour.Orange, 2));
		
		t13 = (new Tile(Colour.Orange, 3));
		t14 = (new Tile(Colour.Orange, 4));
		t15 = (new Tile(Colour.Orange, 5));
		t16 = (new Tile(Colour.Orange, 6));
		
		// Making meld with only three tiles as first play: set
		NewMeld = new Meld(t1, t2, t3, true);
		
		// Making meld with only three tiles as normal play: set
		NewMeld2 = new Meld(t9, t10, t11, false);
		
		// Making meld with only three tiles as first play: run 
		NewMeld3 = new Meld(t7, t4, t8, true);
		
		// Making meld with only three tiles as normal play: run 
		NewMeld4 = new Meld(t5, t6, t7, false);
		
		// Making meld with four tiles as first play: set 
		NewMeld5 = new Meld(t1, t2, t3, t4, true);
		
		// Making meld with four tiles as normal play: set 
		NewMeld6 = new Meld(t9, t10, t11, t12, false);
		
		// Making meld with four tiles as first play: run 
		NewMeld7 = new Meld(t6, t7, t4, t8, true);
		
		// Making meld with four tiles as normal play: run
		NewMeld8 = new Meld(t12, t13, t14, t15, false);
		
		// Making meld with four tiles as first play: run 
		NewMeld9 = new Meld(t5, t6, t7, t4, t8, true);
				
		// Making meld with four tiles as normal play: run
		NewMeld10 = new Meld(t12, t13, t14, t15, t16, false);
		
		

		// checking set melds of 3 tiles 
	
		assertEquals(30, NewMeld.getSum());
		assertEquals(6, NewMeld2.getSum());
	
		// checking run melds of 3 tiles
		
		assertEquals(30, NewMeld3.getSum());
		assertEquals(24, NewMeld4.getSum());
		
		// checking set melds of 4 tiles 
		
		assertEquals(40, NewMeld5.getSum());
		assertEquals(8, NewMeld6.getSum());
		
		// checking run melds of 4 tiles 
		
		assertEquals(38, NewMeld7.getSum());
		assertEquals(14, NewMeld8.getSum());
		
		// checking run melds of 5 tiles
		
		assertEquals(45, NewMeld9.getSum());
		assertEquals(20, NewMeld10.getSum());
		
	}
	/*
	 * public void testRemoveFromMeld() {
	 * 
	 * // initializing Deck MainDeck = new Deck(); Player Julian = new Player();
	 * Meld NewMeld;
	 * 
	 * // adding tiles Julian.addTile(new Tile(R,10)); Julian.addTile(new
	 * Tile(B,10)); Julian.addTile(new Tile(G,10));
	 * 
	 * // Making meld NewMeld =
	 * Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
	 * NewMeld.RemoveTile(R,10); // ensuring that tiles have been removed
	 * assertEquals(2,NewMeld.getSize());
	 * 
	 * }
	 * 
	 * 
	 * public void testAppendMeld() { // initializing Deck MainDeck = new Deck();
	 * Player Julian = new Player(); Meld NewMeld; Meld meld;
	 * 
	 * // adding tiles Julian.addTile(new Tile(R,2)); Julian.addTile(new Tile(R,3));
	 * Julian.addTile(new Tile(R,4));
	 * 
	 * 
	 * // Making meld NewMeld =
	 * Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
	 * NewMeld.AppendTile(new Tile(R,5));
	 * 
	 * 
	 * assertEquals(4,NewMeld.getSize());
	 * 
	 * }
	 * 
	 * public void testSplitMeld() { // initializing Deck MainDeck = new Deck();
	 * Player Julian = new Player(); Meld NewMeld; Meld meld;
	 * 
	 * // adding tiles Julian.addTile(new Tile(R,2)); Julian.addTile(new Tile(R,3));
	 * Julian.addTile(new Tile(R,4)); Julian.addTile(new Tile(R,5));
	 * Julian.addTile(new Tile(R,6)); Julian.addTile(new Tile(R,7));
	 * 
	 * // Making meld NewMeld =
	 * Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
	 * NewMeld.addTile(Julian.getCard()); NewMeld.addTile(Julian.getCard());
	 * NewMeld.addTile(Julian.getCard());
	 * 
	 * meld = NewMeld.split(); // ensuring that meld was split
	 * assertEquals(3,NewMeld.getSize()); assertEquals(3,meld.getSize());
	 * 
	 * 
	 * }
	 */

}
