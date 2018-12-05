package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyThreeTest {

	@Test
	public void test() {
		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();//p3 turn
		
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

		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		
		p.addTile(t11); 
		p.addTile(t12);
		p.addTile(t13);	
		
		p.Play(game);
		System.out.print(game.getMeldsStrings() + "\n");
		assertEquals(2, game.getNumMelds());
		assertEquals(1, p.getHand().getSize());
	
		
	}
	@Test
	public void test2() {
		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();//p3 turn
		
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
		//td = new Tile("R1"); //dummy tile; don't use reds pls

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
		//p.addTile(td);	//dummy tile so doesn't win
		//R1 R13 G13 B13 
		
		
		p.Play(game);
		System.out.print(game.getMeldsStrings() + "\n");
		assertEquals(2, game.getNumMelds());
		assertEquals(0, p.getHand().getSize());

		
		
		
	}
}
