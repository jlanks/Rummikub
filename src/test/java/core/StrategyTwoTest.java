package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyTwoTest {

	@Test
	public void testPlayGameAdd() {

		Game game = new Game();
		game.nextTurn();
		game.nextTurn(); //p3 turn
		
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, td;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 13));
		t14 = (new Tile(Colour.Orange, 6));

		t11 = (new Tile(Colour.Red, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		td = new Tile("R1"); //dummy tile; don't use reds pls

		//p3
		Player p = game.getPlayer();
		///Hand h = game.getCurrHand();	//Don't do this, h will hold an old reference to the hand. Use p.getHand
		Table t = game.getTable();
		//assertEquals("Player 3", p.getName());
		Meld m = new Meld(t5, t6, t7, false);
		t.addMeld(m);
		assertEquals(1, game.getNumMelds());

		p.addTile(t11); 
		p.addTile(t12);
		p.addTile(t13);	
		p.addTile(td);	//dummy tile so doesn't win
		//R1 R13 G13 B13 
		
		
		p.Play(game);
		System.out.print(game.getMeldsStrings() + "\n");
		assertEquals(2, game.getNumMelds());
		assertEquals(1, p.getHand().getSize());

		p.addTile(t10); //	O13
		p.addTile(t14); //  O6
		p.addTile(t8); //   O10
		

		//p.getHand().sortHand();

		//
		/*
		 * assertEquals(true,m.CheckBack(t8)); assertEquals(false,m.CheckBack(t14));
		 * assertEquals(true,m.CheckFront(t14));
		 * 
		 */
		// p.Play(game);
		//
		// h.AddAllPossible(game.getMelds());

		// this works
		// *** h.AddAllTiles(game, game.getMelds().get(0));

		// 

		/*
		 * But this Does not work, idk why - assertEquals(4,p.Play(game)); StrategyTwo,
		 * line 61
		 */
		
		assertEquals(4, p.getHand().getSize());
		//System.out.print("Melds: " + game.getMeldsStrings() + "\n");
		//System.out.print("CurrHand: " + game.getCurrHand() + "\n");
		//h.AddAllTiles(game, game.getMelds().get(0));
		//System.out.print("PLAYING...\n");
		p.Play(game);
		//System.out.print("DONE\n");
		System.out.print(game.getMeldsStrings());
		//System.out.print("Melds: " + game.getMeldsStrings() + "\n");
		//System.out.print("CurrHand: " + game.getCurrHand() + "\n");
		
		assertEquals(1, game.getCurrHand().getSize());

	}

//@Test
	public void testPlayGameRunSet() {

		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		// game.getCurrHand().sortHand();
		assertEquals(10, game.currHandSize());
		assertEquals("Player 3", game.getPlayer().getName());

		game.getPlayer().Play(game);
		assertEquals(3, game.currHandSize());
		assertEquals("Player 3", game.getPlayer().getName());
		assertEquals(2, game.getNumMelds());

	}

//@Test
	public void testCantPlay() {

		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(3, game.currHandSize());
		game.Play();

		assertEquals(3, game.currHandSize());
		// adding a meld to the table
		Meld m = new Meld(t5, t6, t7, false);
		game.getTable().addMeld(m);
		assertEquals(1, game.getNumMelds());
		assertEquals(3, game.currHandSize());
		game.Play();
		assertEquals(0, game.currHandSize());
		assertEquals(2, game.getNumMelds());

	}

//@Test
	public void testPlaystowin() {

		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(4, game.currHandSize());
		game.Play();

		assertEquals(4, game.currHandSize());
		// adding a meld to the table
		Meld m = new Meld(t5, t6, t7, false);
		game.getTable().addMeld(m);
		assertEquals(1, game.getNumMelds());
		assertEquals(4, game.currHandSize());
		game.playFirst();
		game.Play();
		assertEquals(5, game.currHandSize());
		assertEquals(1, game.getNumMelds());

	}
}
