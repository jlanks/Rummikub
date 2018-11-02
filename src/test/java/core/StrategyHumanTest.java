package core;

import junit.framework.TestCase;

public class StrategyHumanTest extends TestCase {
	public void testDrawTile() {
		Game game = new Game();
		game.getTable().init();
		Player me = game.getPlayer(); // Human should play first

		assertEquals(14, me.getHandSize());

		game.show();
		me.Play(game); // Human must draw a tile here
		game.show();

		assertEquals(15, me.getHandSize());
		game.end();
	}

	public void testPlayMeld() {
		Game game = new Game();
		game.getTable().init();
		Player me = game.getPlayer(); // Human should play first

		me.addTile(new Tile("R1"));
		me.addTile(new Tile("R2"));
		me.addTile(new Tile("R3"));

		assertEquals(17, me.getHandSize());
		assertEquals(0, game.getTable().numMelds());

		game.show();
		me.Play(game); // Human must play Meld [R1 R2 R3]
		game.show();

		assertEquals(14, me.getHandSize());
		assertEquals(1, game.getTable().numMelds());

		Meld m = new StringMeld("R1", "R2", "R3");
		assertEquals(true, game.getTable().getMeld(0).equals(m));

		game.end();
	}

	public void testPlayMultipleMelds() {
		Game game = new Game();
		game.getTable().init();
		Player me = game.getPlayer(); // Human should play first

		me.addTile(new Tile("R1"));
		me.addTile(new Tile("R2"));
		me.addTile(new Tile("R3"));
		me.addTile(new Tile("G1"));
		me.addTile(new Tile("G2"));
		me.addTile(new Tile("G3"));

		assertEquals(20, me.getHandSize());
		assertEquals(0, game.getTable().numMelds());

		game.show();
		me.Play(game); // Human must play meld [R1 R2 R3] and [G1 G2 G3]
		game.show();

		assertEquals(14, me.getHandSize());
		assertEquals(2, game.getTable().numMelds());

		Meld m = new StringMeld("R1", "R2", "R3");
		Meld m2 = new StringMeld("G1", "G2", "G3");
		assertEquals(true, game.getTable().getMeld(0).equals(m));
		assertEquals(true, game.getTable().getMeld(1).equals(m));

		game.end();
	}
}
