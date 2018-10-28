package core;

import junit.framework.TestCase;

public class TileTest extends TestCase {
	/**
	 * This tests: the tile constructor
	 */
	public void testTile() {
		// this confirms the tile was made
		Tile tester = new Tile(Colour.values()[1], 8);
		assertNotNull(tester); // should be a success
	}

	
	 //This tests the tile constructor for string. ALSO TESTS EQUALS().
	public void testTileString() {
		Tile tester = new Tile("R5");
		Tile confirmation = new Tile(Colour.Red, 5);
		
		assertNotNull(tester);
		assertEquals(true, tester.equals(confirmation));
	}


	/**
	 * This tests/confirms: that the tile's color and value are set
	 */
	public void testCheckColorAndValue() {
		Colour compare = Colour.values()[1];
		Tile tester = new Tile(Colour.values()[1], 6);
		assertNotNull(tester); // should be a success

		// this confirms the tile's color
		assertEquals(compare, tester.getColour());

		// this confirms the tile's number
		assertEquals(6, tester.getValue());
	}
	
	public void testEquals() {
		
	}

}
