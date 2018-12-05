package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyThreeTest {

	//@Test
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
		assertEquals("S3", p.getName());
		
		Meld m = new Meld(t5, t6, t7, false);
		t.addMeld(m);
		
		assertEquals(1, game.getNumMelds());

		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12);
		game.getPlayer().addTile(t13);	
		game.getPlayer().addTile(t5);
		//p.addTile(td);	//dummy tile so doesn't win
		//R1 R13 G13 B13 
		
		
		game.getPlayer().Play(game);
		
		System.out.print(game.getCurrHand() + "\n");
		
		assertEquals(2, game.getNumMelds());
		assertEquals(1, game.getPlayer().getHand().getSize());

		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		
		assertEquals("S3", game.getPlayer().getName());
		
		game.getPlayer().addTile(t6); 
		game.getPlayer().addTile(t7);
		game.getPlayer().addTile(t8);	
		
		assertEquals(4, game.getPlayer().getHand().getSize());
		assertEquals(34, game.getPlayer().getSum());
		System.out.print(game.getCurrHand() + "\n");
		System.out.print("About to play"+ "\n");
		System.out.print(game.getCurrSHand() + "\n");
		
		assertEquals("S3", game.getPlayer().getName());
		game.getPlayer().Play(game);
		System.out.print(game.getCurrSHand() + "\n");
		System.out.print(game.getMeldsStrings() + "\n");
		
		assertEquals(3, game.getNumMelds());
		assertEquals(0, p.getHand().getSize());
	
		
	}
	//@Test
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
		
		//System.out.print(game.getTable().getPlayers());
		
		
		
	}
	//@Test
	public void test3() {
		
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
		
		
		

		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12);
		game.getPlayer().addTile(t13);	
		game.getPlayer().addTile(td);	//dummy tile so doesn't win
		//R1 R13 G13 B13 
		assertEquals("S3", game.getPlayer().getName());
		assertEquals(4, game.getPlayer().getHand().getSize());
		System.out.print(game.getPlayer().getHand());
		game.getPlayer().Play(game);
		
		System.out.print(game.getMeldsStrings() + "\n");
		
		assertEquals(1, game.getNumMelds());
		assertEquals(1, game.getPlayer().getHand().getSize());
		
		//System.out.print(game.getTable().getPlayers());
		p.addTile(t11); 
		p.addTile(t12);
		p.addTile(t13);	
		
		assertEquals(4, game.getPlayer().getHand().getSize());
		
		System.out.print(game.getPlayer().getName()+ "\n");
		
		p.Play(game);
		assertEquals(1, game.getPlayer().getHand().getSize());
		
		game.nextTurn();
		game.nextTurn();
		
		game.getPlayer().addTile(td); 
		game.getPlayer().addTile(td); 
		assertEquals(2, game.getPlayer().getHand().getSize());
		
		
		game.nextTurn();
		game.nextTurn();
		
		System.out.print(game.getPlayer().getName()+ "\n");
		assertEquals(1, game.getPlayer().getHand().getSize());
		game.getPlayer().Play(game);
		
		assertEquals(2, game.getPlayer().getHand().getSize());
		
	}
	@Test
public void test4() {
		
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
		
		
		

		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12);
		game.getPlayer().addTile(t13);	
		game.getPlayer().addTile(td);	//dummy tile so doesn't win
		//R1 R13 G13 B13 
		assertEquals("S3", game.getPlayer().getName());
		assertEquals(4, game.getPlayer().getHand().getSize());
		System.out.print(game.getPlayer().getHand());
		game.getPlayer().Play(game);
		
		System.out.print(game.getMeldsStrings() + "\n");
		
		assertEquals(1, game.getNumMelds());
		assertEquals(1, game.getPlayer().getHand().getSize());
		
		//System.out.print(game.getTable().getPlayers());
		p.addTile(t11); 
		p.addTile(t12);
		p.addTile(t13);	
		
		assertEquals(4, game.getPlayer().getHand().getSize());
		
		System.out.print(game.getPlayer().getName()+ "\n");
		
		p.Play(game);
		assertEquals(1, game.getPlayer().getHand().getSize());
		
		game.nextTurn();
		game.nextTurn();
		assertEquals("S1", game.getPlayer().getName());
		game.getPlayer().addTile(td); 
		//game.getPlayer().addTile(td); 
		assertEquals(1, game.getPlayer().getHand().getSize());
		
		
		game.nextTurn();
		game.nextTurn();
		
		System.out.print(game.getPlayer().getName()+ "\n");
		assertEquals(1, game.getPlayer().getHand().getSize());
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12);
		game.getPlayer().addTile(t13);	
		assertEquals(4, game.getPlayer().getHand().getSize());
		game.getPlayer().Play(game);
		
		assertEquals(1, game.getPlayer().getHand().getSize());
		
	}
}
