package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MeldTest extends TestCase {
	
	public void testConst() {
		
		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		ArrayList<Tile> list = new ArrayList<Tile>();
		list.add(t5);
		list.add(t6);
		list.add(t7);
		list.add(t8);
		Meld meld = new Meld(list);
		assertEquals(4, meld.getSize());
	}

	public void testEquals() {

		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;

		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));

		Meld tiles = new Meld(t5, t6, t7, false);
		Meld tiles2 = new Meld(t8, t9, false);

		// testing melds which are not the same returns false
		assertEquals(false, tiles.equals(tiles2));

		tiles2 = new Meld(t5, t6, t7, false);

		// testing melds which are the same returns true
		assertEquals(true, tiles.equals(tiles2));

	}

	public void testCombineMeld() {

		// init

		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
		t10 = (new Tile(Colour.Orange, 5));
		t11 = (new Tile(Colour.Orange, 6));
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));

		Meld tiles = new Meld(t5, t6, t7, false);
		assertEquals(3, tiles.getSize());

		Meld tiles2 = new Meld(t8, t9, false);
		assertEquals(2, tiles2.getSize());

		// combining melds
		tiles.combineMeld(tiles2);
		// testing meld was added
		assertEquals(5, tiles.getSize());
		// testing new meld is valid
		assertEquals(true, tiles.validMeld());
		// testing the old meld is in valid
		assertEquals(false, tiles2.validMeld());
	}

	public void testValidMeld() {

		// init

		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
		t10 = (new Tile(Colour.Orange, 5));
		t11 = (new Tile(Colour.Orange, 6));
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));

		t1 = (new Tile(Colour.Red, 10));
		t2 = (new Tile(Colour.Blue, 10));
		t3 = (new Tile(Colour.Green, 10));
		t4 = (new Tile(Colour.Orange, 10));

		Meld tiles = new Meld(t5, t6, t7, false);
		assertEquals(3, tiles.getSize());
		// melds need to be of size 3 or more.
		// first test is to make sure validMeld()
		// returns false on a meld of size 2 or less

		// removing a tile
		// tiles now has 2 tiles
		tiles.removeTile(t5);
		assertEquals(2, tiles.getSize());
		// making sure the function identifies the invalid meld
		assertFalse(tiles.validMeld());

		// removing tile, new length is 1
		tiles.removeIndex(0);

		// testing one tile melds are reported invalid
		assertEquals(false, tiles.validMeld());

		// testing a valid meld gets the valid status
		// we need to test for runs and sets of different sizes.

		// SETS

		// set of 4
		Meld set1 = new Meld(t1, t2, t3, t4, false);

		// testing correct identification of a valid meld
		// set of size 4
		assertTrue(set1.validMeld());

		// removing tile
		set1.removeTile(t1);

		// testing correct identification of a valid meld
		// set of size 3
		assertEquals(true, set1.validMeld());

		// RUNS

		// run of size 5
		Meld run1 = new Meld(t5, t6, t7, t8, t9, false);

		// testing that the valid meld returns true
		assertTrue(run1.validMeld());

		// removing tile
		run1.removeTile(t7);

		// testing that the meld is now invalid
		// there's a gap in the tiles now
		assertEquals(false, run1.validMeld());

	}

	/*
	 * public void testSplitMeld() {
	 * 
	 * // we need can only split melds which are runs // we can split the meld
	 * anywhere // we can choose to split on index or by tile
	 * 
	 * // init
	 * 
	 * Tile t1, t2,t3,t4,t5,t6,t7,t8,t9, t10, t11; t10 = (new Tile(Colour.Orange,
	 * 5)); t11 = (new Tile(Colour.Orange, 6)); t5 = (new Tile(Colour.Orange, 7));
	 * t6 = (new Tile(Colour.Orange, 8)); t7 = (new Tile(Colour.Orange, 9)); t8 =
	 * (new Tile(Colour.Orange, 10)); t9 = (new Tile(Colour.Orange, 11));
	 * 
	 * t1 = (new Tile(Colour.Red, 10)); t2 = (new Tile(Colour.Blue, 10)); t3 = (new
	 * Tile(Colour.Green, 10)); t4 = (new Tile(Colour.Orange, 10));
	 * 
	 * Meld result, result2, invalid, valid; Meld tiles = new
	 * Meld(t5,t6,t7,t8,t9,false);
	 * 
	 * assertEquals(5,tiles.getSize());
	 * 
	 * // includes index value in original meld // returns the back end of the
	 * split. // (everything after the index)
	 * 
	 * result = tiles.splitIndex(2);
	 * 
	 * //assertEquals(3,tiles.getSize()); assertEquals(1,result.getSize());
	 * 
	 * // includes tile argument in original meld // returns the back end of the
	 * split. // (everything after the tile argument) // you should not be able to
	 * split a meld of size 3, // just remove desired tile in this case
	 * 
	 * // result2 = tiles.splitMeld(t6); // assertEquals(null,result2);
	 * 
	 * // result2 = new Meld(t5,t6,t7,t8,t9,false);
	 * 
	 * // valid = result2.splitMeld(t6); // assertEquals(3,valid.getSize()); //
	 * assertEquals(2,result2.getSize());
	 * 
	 * // you should not be able to split a set
	 * 
	 * // invalid = new Meld(t1,t2,t3,t4,false);
	 * 
	 * // testing both spitMeld and splitIndex for sets //
	 * assertEquals(null,invalid.splitMeld(t2));
	 * 
	 * //assertEquals(null,invalid.splitIndex(1));
	 * 
	 * }
	 */
	public void testAddToMeld() {
		// making tiles
		Tile t1, t2, t3, t4, t5, t6, t7, t8, t9;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));

		t1 = (new Tile(Colour.Red, 10));
		t2 = (new Tile(Colour.Blue, 10));
		t3 = (new Tile(Colour.Green, 10));
		t4 = (new Tile(Colour.Orange, 10));

		Meld tiles = new Meld(t5, t6, t7, false);

		// making sure meld has correct sum (means all tiles are added)
		assertEquals(24, tiles.getSum());

		// adding a valid tile with value 10
		// testing adding a tile to a meld: run of size 3 going to size 4
		tiles.addTile(t8);

		// ensuring tile was added properly
		assertEquals(34, tiles.getSum());
		// t8 should be in index 3 for a valid tile->meld addition
		assertEquals(10, tiles.getTile(3).getValue());

		// creating meld for adding a valid tile to a set
		Meld meld = new Meld(t1, t2, t3, false);

		// making sure meld has correct sum (means all tiles are added)
		assertEquals(30, meld.getSum());

		// adding
		meld.addTile(t4);

		// ensuring tile was added properly
		// t4 should be in any index for a valid tile->meld addition
		// since we are dealing with a set
		assertEquals(40, meld.getSum());
	}

	public void testRemoveTile() {

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

		// creating a meld to remove from
		NewMeld = new Meld(t1, t2, t3, t4, false);

		// making sure meld is made correctly
		// should have a value of 40 --

		assertEquals(40, NewMeld.getSum());

		// removing from meld by tile argument

		NewMeld.removeTile(t1);

		// testing to see if the first tile is not the same
		// (since it is removed)

		assertNotSame(Colour.Red, NewMeld.getTile(0));

		// testing melds value is reduced by 10
		// (tiles value which was removed)

		assertEquals(30, NewMeld.getSum());

		// removing from meld by index

		NewMeld.removeIndex(0);

		// testing that the tile at index 0 was removed

		assertEquals(20, NewMeld.getSum());
		assertEquals(Colour.Green, NewMeld.getTile(0).getColour());

	}

	public void testMeldConstructor() {

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
		t11 = (new Tile(Colour.Green, 2));
		t12 = (new Tile(Colour.Orange, 2));

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

	public void testContains() {
		Meld meld = new Meld(new Tile("R1"), new Tile("R2"), new Tile("R3"), false);

		assertEquals(-1, meld.contains(new Tile("O4")));
		assertEquals(0, meld.contains(new Tile("R1")));
		assertEquals(2, meld.contains(new Tile("R3")));
	}

	// Can't split a Meld if one of the resulting Melds is illegal
	// (this might actually be a useful feature to have though)
	public void testSplitMeld() {
		Meld meld1 = new StringMeld("R1", "R2", "R3");
		Meld meld2 = new StringMeld("R4", "R5", "R6");

		meld1.combineMeld(meld2); // R1 R2 R3 R4 R5 R6
		Meld meld3 = meld1.split(3); // Splits meld at R4

		Meld m123 = new StringMeld("R1", "R2", "R3");
		Meld m456 = new StringMeld("R4", "R5", "R6");

		assertEquals(true, meld1.equals(m123));
		assertEquals(true, meld3.equals(m456));
	}

}
