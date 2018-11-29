package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyOneTest {
	/*
	public void testConst() {

		// making a game
		Game game = new Game();

		// initializing the game table
		game.getTable().init();

		// making an instance of StrategyOne
		StrategyOne strat = new StrategyOne();

		// testing that play returns zero
		assertEquals(0, strat.play(game));
		

		
	}
	@Test
	public void testPlayInvFirst() {
		
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		game.getPlayer().addTile(t5); 
		game.getPlayer().addTile(t6); 
		game.getPlayer().addTile(t7); 
		assertEquals(3,game.getPlayer().getHandSize());
		
		int sum =0; 
		
		sum = game.getAvailMeldSum(); 
		
		assertEquals(24,sum); 
		assertEquals(game.getNumMelds(),0);
		game.getPlayer().Play(game); 
		
		// testing the meld is not played since it is the first turn and not above 30
		assertEquals(false,game.getPlayer().checkFirst());
		assertEquals(game.getNumMelds(),0);
		assertEquals(game.currHandSize(),3); 
		
		
		
		
	}
	
	@Test
	public void testPlayValidFirst() {
		
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12); 
		game.getPlayer().addTile(t13); 
		assertEquals(3,game.getPlayer().getHandSize());
		
		int sum =0; 
		
		sum = game.getAvailMeldSum(); 
		
		assertEquals(39,sum); 
		assertEquals(game.getNumMelds(),0);
		assertEquals(1,game.getPlayer().Play(game)); 
		
		// testing the meld is not played since it is the first turn and not above 30
		assertEquals(false,game.getPlayer().checkFirst());
		assertEquals(game.getNumMelds(),1);
		assertEquals(game.currHandSize(),0); 
		
		
			
		
		
	}
	*/
	@Test
	public void test2() {
		
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
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
		
		game.getPlayer().addTile(t5);
		game.getPlayer().addTile(t5);
		game.getPlayer().addTile(t11);
		game.getPlayer().addTile(t6); 
		game.getPlayer().addTile(t7); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t13); 
		game.getPlayer().addTile(t12); 
		
		
		/*
		game.getPlayer().addTile(t7); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t9);
		*/
		// take this tile out and there are errors. this bug is from the IdSets/IdSet
		//game.getPlayer().addTile(t13); 
		assertEquals(9,game.getPlayer().getHandSize());
		int x =0; 
		assertEquals(39,game.getPlayer().getHand().getSetSum(game.fakeHand(), game.fakeHand().get(0),x )); 
		game.getPlayer().Play(game); 
		assertEquals(2,game.getPlayer().getHandSize());
		assertEquals(2,game.getNumMelds());
		System.out.print(game.getMeldsStrings());
	}
	//@Test
	public void test() {
		
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12); 
		game.getPlayer().addTile(t13); 
		
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12); 
		game.getPlayer().addTile(t13); 
		game.getPlayer().addTile(t13); 
		/*
		game.getPlayer().addTile(t7); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t9);
		*/
		// take this tile out and there are errors. this bug is from the IdSets/IdSet
		game.getPlayer().addTile(t13); 
		assertEquals(8,game.getPlayer().getHandSize());
		game.getPlayer().Play(game); 
		assertEquals(2,game.getPlayer().getHandSize());
		assertEquals(2,game.getNumMelds());
		
	}
	//@Test
	public void S1FINALTEST() {
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12); 
		game.getPlayer().addTile(t13); 
		
		
		game.getPlayer().addTile(t7); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t9);
		// take this tile out and there are errors. this bug is from the IdSets/IdSet
		game.getPlayer().addTile(t13); 
		assertEquals(7,game.getPlayer().getHandSize());
		
		int sum =0; 
		
		//sum = game.getAvailMeldSum(); 
		
		//assertEquals(69,sum); 
		
		assertEquals(0,game.getPlayer().Play(game)); 
		assertEquals(2,game.getNumMelds());
		
		
		
	}
	/*
	@Test
	public void testPlayAdd() {
		
		Game game = new Game();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		t14 = (new Tile(Colour.Red, 13));
		//game.getPlayer().addTile(t5); 
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12);
		game.getPlayer().addTile(t14); 
		//game.getPlayer().addTile(t13); 
		
		
		assertEquals(4,game.currHandSize());
		
		int sum = 0;  
		game.getCurrHand().sortHand();
		
		//assertEquals(game.getCurrHand().);
		assertEquals(39,game.getCurrHand().getSetSum(game.getCurrHand(),game.getCurrHand().get(0), sum)); 
		assertEquals(game.getNumMelds(),0);
		game.getPlayer().Play(game); 
		
		// testing the meld is not played since it is the first turn and not above 30
		assertEquals(false,game.getPlayer().checkFirst());
		assertEquals(game.getNumMelds(),1);
		assertEquals(game.currHandSize(),1); 
		
		
		
		
	}
	
	@Test
	public void testPlayAdd2() {
		
		Game game = new Game();
		game.nextTurn();
		Hand hand = new Hand(); 
		hand = game.getCurrHand(); 
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		t14 = (new Tile(Colour.Red, 13));
		//game.getPlayer().addTile(t5); 
		hand.add(t6); 
		hand.add(t7);
		hand.add(t8);
		hand.add(t14);
		//game.getPlayer().addTile(t9); 
		
		
		assertEquals(4,hand.getSize());
		
		int sum = 0;  
		hand.sortHand();
		
		//assertEquals(game.getCurrHand().);
		
		assertEquals(27,hand.getRunSum(hand,hand.get(0), sum)); 
		assertEquals(game.getNumMelds(),0);
		game.getPlayer().Play(game); 
		
		// testing the meld is not played since it is the first turn and not above 30
		assertEquals(false,game.getPlayer().checkFirst());
		assertEquals(game.getNumMelds(),1);
		assertEquals(game.currHandSize(),1); 
		
		
		
		
	}
	
	@Test
	public void testMakeRun() {

		Game game = new Game();
		Player P1 = game.getTable().player2();

		// giving p1 the cards to make a set
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 11));
		P1.addTile(new Tile(Colour.Red, 12));
		P1.addTile(new Tile(Colour.Red, 13));
		P1.addTile(new Tile(Colour.Red, 10));
		P1.addTile(new Tile(Colour.Red, 11));
		P1.addTile(new Tile(Colour.Red, 12));
		P1.addTile(new Tile(Colour.Red, 13));
		//sgame.getTable().init();
		game.nextTurn();
		
		// player should make a set and add it to the table
		// player makes their move
		
		assertEquals(8, P1.getHandSize());
		
		P1.Play(game);
		
		// this means hand size will be zero
		assertEquals(0, P1.getHandSize());
		
		// this means the table will have a meld on it
		assertEquals(2, game.getTable().numMelds());
		
		// this means the table will have a meld on it of correct size
		assertEquals(4, game.getTable().getMeld(0).getSize());
		}
	
	/*
	@Test
	public void testMakeAdditions() {
		
				// making a game
				Game game = new Game();
				
				// player with s1
				Player P1 = game.getTable().player2();
				
				// making a meld which can be added
				
				// set of size 3
				Meld m = new Meld(new Tile(Colour.Red, 10),new Tile(Colour.Blue, 10),new Tile(Colour.Green, 10),false); 
				
				// giving p1 the cards to make a set
				P1.addTile(new Tile(Colour.Orange,10));
				
				// adding the meld to the table
				game.getTable().addMeld(m);
				
				// making sure the meld is on the table 
				assertEquals(1,game.getTable().numMelds()); 
				
				// testing adding to an existing set
				P1.Play(game); 
				
				// checks the player no longer has a card in their hand
				assertEquals(0,P1.getHandSize()); 
				
				// checks the card has been added to the meld
				assertEquals(4,game.getTable().getMeld(0).getSize()); 
				
				
				// next test adding to an existing run. 
				// this needs to be tested in the front, middle, and back of the meld
				
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				
				// adding the meld to the table
				game.getTable().addMeld(m);
				
				// making sure the meld is on the table 
				assertEquals(1,game.getTable().numMelds()); 
				
				// back
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Red,9));
				
				// testing the tile was added to players hand
				assertEquals(1,P1.getHandSize());
				
				// testing the tile was removed from players hand
				assertEquals(0,P1.getHandSize());
				
				// testing the meld on the table has an increased size of one 
				assertEquals(4,game.getTable().getMeld(0).getSize()); 
				
				
				// middle
				
				// front 
				
				// adding a valid tile which can be added
				P1.addTile(new Tile(Colour.Red,5));
				
				// testing the tile was added to players hand
				assertEquals(1,P1.getHandSize());
				
				// Playing , payer should add tile
				P1.Play(game); 
				
				// testing the tile was removed from players hand
				assertEquals(0,P1.getHandSize()); 
				
				// testing the meld on the table has an increased size of one 
				assertEquals(5,game.getTable().getMeld(0).getSize()); 
				
				//****************
				
				// now we test if a player can add more than one tile to a meld
				// RESET
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				
				// adding the meld to the table
				game.getTable().addMeld(m);
				
				// making sure the meld is on the table 
				assertEquals(1,game.getTable().numMelds()); 
				
				// adding a valid tile which can be added to the front
				P1.addTile(new Tile(Colour.Red,5));
				
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Red,9));
		
				// testing the tiles were added from players hand
				assertEquals(2,P1.getHandSize()); 
				
				// player plays
				P1.Play(game); 
				
				// testing the size of the meld increased
				assertEquals(5,game.getTable().getMeld(0).getSize());
				// testing the players hand is empty
				assertEquals(0,P1.getHandSize());
				
				//****************
				
				// now we test if a player can add one tile to a meld and a different tile to a different meld
				// RESET
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				Meld m2 = new Meld(new Tile(Colour.Blue, 6),new Tile(Colour.Blue, 7),new Tile(Colour.Blue, 8),false);
				
				// adding the melds to the table
				game.getTable().addMeld(m);
				game.getTable().addMeld(m2);
				
				// making sure the melds are on the table 
				assertEquals(2,game.getTable().numMelds());
				
				// adding a valid tile which can be added to the front
				P1.addTile(new Tile(Colour.Red,5));
				
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Blue,9));
				
				// testing the tiles were added from players hand
				assertEquals(2,P1.getHandSize()); 
				
				// player plays
				P1.Play(game); 
				
				// testing the size of the meld increased
				assertEquals(4,game.getTable().getMeld(0).getSize());
				assertEquals(4,game.getTable().getMeld(1).getSize());
				
				// testing the players hand is empty
				assertEquals(0,P1.getHandSize());
				
				
				//****************
				
				// now we test if a player can add one tile to a meld and a different two tiles to a different meld
				// RESET
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				m2 = new Meld(new Tile(Colour.Blue, 6),new Tile(Colour.Blue, 7),new Tile(Colour.Blue, 8),false);
				
				// adding the melds to the table
				game.getTable().addMeld(m);
				game.getTable().addMeld(m2);
				
				// making sure the melds are on the table 
				assertEquals(2,game.getTable().numMelds());
				
				// adding a valid tile which can be added to the front
				P1.addTile(new Tile(Colour.Red,5));
				P1.addTile(new Tile(Colour.Red,9));
				
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Blue,9));
				
				// testing the tiles were added from players hand
				assertEquals(3,P1.getHandSize()); 
				
				// player plays
				P1.Play(game); 
				
				// testing the size of the meld increased
				assertEquals(5,game.getTable().getMeld(0).getSize());
				assertEquals(4,game.getTable().getMeld(1).getSize());
				
				// testing the players hand is empty
				assertEquals(0,P1.getHandSize());
				

				// now we test if a player can add two tiles to a meld and a different two tiles to a different meld
				// RESET
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				m2 = new Meld(new Tile(Colour.Blue, 6),new Tile(Colour.Blue, 7),new Tile(Colour.Blue, 8),false);
				
				// adding the melds to the table
				game.getTable().addMeld(m);
				game.getTable().addMeld(m2);
				
				// making sure the melds are on the table 
				assertEquals(2,game.getTable().numMelds());
				
				// adding a valid tile which can be added to the front
				P1.addTile(new Tile(Colour.Red,5));
				P1.addTile(new Tile(Colour.Red,9));
				
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Blue,9));
				P1.addTile(new Tile(Colour.Blue,5));
				// testing the tiles were added from players hand
				assertEquals(4,P1.getHandSize()); 
				
				// player plays
				P1.Play(game); 
				
				// testing the size of the meld increased
				assertEquals(5,game.getTable().getMeld(0).getSize());
				assertEquals(5,game.getTable().getMeld(1).getSize());
				
				// testing the players hand is empty
				assertEquals(0,P1.getHandSize());
				
				
				// now we test if a player can add two tiles to a meld 
				// and a different two tiles to a different meld 
				// and one tile to a third meld (set)
				// RESET
				// clearing table
				game.getTable().clearMT();
				
				// making a set of size three
				m = new Meld(new Tile(Colour.Red, 6),new Tile(Colour.Red, 7),new Tile(Colour.Red, 8),false);
				m2 = new Meld(new Tile(Colour.Blue, 6),new Tile(Colour.Blue, 7),new Tile(Colour.Blue, 8),false);
				Meld m3 = new Meld(new Tile(Colour.Blue, 6),new Tile(Colour.Green, 6),new Tile(Colour.Red, 6),false); 
				
				// adding the melds to the table
				game.getTable().addMeld(m);
				game.getTable().addMeld(m2);
				game.getTable().addMeld(m3);
				
				// making sure the melds are on the table 
				assertEquals(3,game.getTable().numMelds());
				
				// adding a valid tile which can be added to the front
				P1.addTile(new Tile(Colour.Red,5));
				P1.addTile(new Tile(Colour.Red,9));
				
				// adding a tile which can be added to the set 
				P1.addTile(new Tile(Colour.Orange,6));
				
				// adding a valid tile which can be added to the back
				P1.addTile(new Tile(Colour.Blue,9));
				P1.addTile(new Tile(Colour.Blue,5));
				// testing the tiles were added from players hand
				assertEquals(5,P1.getHandSize()); 
				
				// player plays
				P1.Play(game); 
				
				// testing the size of the meld increased
				assertEquals(5,game.getTable().getMeld(0).getSize());
				assertEquals(5,game.getTable().getMeld(1).getSize());
				assertEquals(4,game.getTable().getMeld(2).getSize());
				
				// testing the players hand is empty
				assertEquals(0,P1.getHandSize());
				
				
					
	}
/**/
	
}
