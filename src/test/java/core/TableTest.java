package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest extends TestCase{

	public void testAddMeld() {	//Also tests numMelds()
		Table table = new Table();
		Meld m1 = new Meld();
		Meld m2 = new Meld();
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
		assertEquals(0, table.player1().getNumTiles());
		assertEquals(0, table.player2().getNumTiles());
		assertEquals(0, table.player3().getNumTiles());
		assertEquals(0, table.player4().getNumTiles());
		assertEquals(0, table.numMelds());
		
		table.init();
		assertEquals(14, table.player1().getNumTiles());
		assertEquals(14, table.player2().getNumTiles());
		assertEquals(14, table.player3().getNumTiles());
		assertEquals(14, table.player4().getNumTiles());
		assertEquals(0, table.numMelds());
	}
	
	public void testRemMeld() {
		Table table = new Table();
		Meld m1 = new Meld();
		Meld m2 = new Meld(new Tile("O2"), new Tile("O3"), new Tile("O4"));
		
		Table.addMeld(m2);
		Table.addMeld(m1);
		assertEquals(2, table.numMelds());
		
		table.remMeld(new Meld(new Tile("O2"), new Tile("O3"), new Tile("O4")));	//removes meld [0]
		assertEquals(1, table.numMelds());
		
		table.remMeld(0);	//removes meld [0] (hopefully they have been shifted)
		assertEquals(0, table.numMelds());
	}
	
	public void testDrawTile() {
		Table table = new Table();
		table.init();
		assertEquals(14, table.player1().getNumTiles());
		
		table.drawTile(table.player1());
		assertEquals(15, table.player1().getNumTiles());
		
		table.drawTile(table.player1());
		assertEquals(16, table.player1().getNumTiles());
		
		table.drawTile(table.player2());
		assertEquals(15, table.player2().getNumTiles());
		
		table.drawTile(table.player3());
		assertEquals(15, table.player3().getNumTiles());
		
		table.drawTile(table.player4());
		assertEquals(15, table.player4().getNumTiles());
	}
}
