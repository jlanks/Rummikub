package core;

import junit.framework.TestCase;

public class TableTest extends TestCase {

	public void testAddMeld() { // Also tests numMelds()
		Table table = new Table();
		Meld m1 = new Meld(new Tile(Colour.Red, 1), new Tile(Colour.Red, 2), new Tile(Colour.Red, 3), false);
		Meld m2 = new Meld(new Tile(Colour.Red, 1), new Tile(Colour.Red, 2), new Tile(Colour.Red, 3), false);
		assertEquals(0, table.numMelds());

		table.addMeld(m1);
		assertEquals(1, table.numMelds());
		table.addMeld(m2);
		assertEquals(2, table.numMelds());
		table.addMeld(m1);
		assertEquals(3, table.numMelds());
	}

	public void testInit() {
		Table table = new Table();
		assertEquals(0, table.player1().getHandSize());
		assertEquals(0, table.player2().getHandSize());
		assertEquals(0, table.player3().getHandSize());
		//assertEquals(0, table.player4().getHandSize());
		assertEquals(0, table.numMelds());

		table.init();
		assertEquals(14, table.player1().getHandSize());
		assertEquals(14, table.player2().getHandSize());
		assertEquals(14, table.player3().getHandSize());
		//assertEquals(14, table.player4().getHandSize());
		assertEquals(0, table.numMelds());
	}
	public void testPlay() {
		
		Game g = new Game(); 
		Table table = new Table();
		table.init();
		
		assertEquals(0,table.player1().Play(g)); 
		
		
	}

	public void testRemMeld() {
		Table table = new Table();
		Meld m1 = new Meld(new Tile(Colour.Red, 1), new Tile(Colour.Red, 2), new Tile(Colour.Red, 3), false);
		Meld m2 = new Meld(new Tile(Colour.Red, 1), new Tile(Colour.Red, 2), new Tile(Colour.Red, 3), false);

		table.addMeld(m2);
		table.addMeld(m1);
		assertEquals(2, table.numMelds());

		table.remMeld(0); // removes
							// meld
							// [0]
		assertEquals(1, table.numMelds());

		// table.remMeld(0); // removes meld [0] (hopefully they have been shifted)
		// assertEquals(0, table.numMelds());
	}

	public void testDrawTile() {
		Table table = new Table();
		table.init();
		assertEquals(14, table.player1().getHandSize());

		table.drawTile(table.player1());
		assertEquals(15, table.player1().getHandSize());

		table.drawTile(table.player1());
		assertEquals(16, table.player1().getHandSize());

		table.drawTile(table.player2());
		assertEquals(15, table.player2().getHandSize());

		table.drawTile(table.player3());
		assertEquals(15, table.player3().getHandSize());

		//table.drawTile(table.player4());
		//assertEquals(15, table.player4().getHandSize());
	}
	/**/
}
