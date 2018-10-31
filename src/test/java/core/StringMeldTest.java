package core;

import junit.framework.TestCase;

public class StringMeldTest extends TestCase {

	// Makes 2 string Melds and 2 regular Melds and makes sure they are equal
	public void testStringMeld() {
		Meld strMeld1 = new StringMeld("R1", "R2", "R3");
		Meld strMeld2 = new StringMeld("R4", "R5", "R6");
		Meld meld1 = new Meld(new Tile("R1"), new Tile("R2"), new Tile("R3"), false);
		Meld meld2 = new Meld(new Tile("R4"), new Tile("R5"), new Tile("R6"), false);

		assertEquals(true, strMeld1.equals(meld1));

		meld1.combineMeld(meld2);
		strMeld1.combineMeld(strMeld2);

		assertEquals(true, strMeld2.equals(meld2));
	}
}
