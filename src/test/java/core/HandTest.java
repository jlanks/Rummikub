package core;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

public class HandTest {
	

	@Test
	public void testConstructor() {
		// making a deck
		Deck deck = new Deck();
		// using reg c
		Hand hand = new Hand(deck); 
		// testing c worked properly
		assertEquals(hand.getSize(),14); 
	}
	@Test
	public void testCConstructor() {
		
	
			// making a deck
			Deck deck = new Deck();
			// using reg c
			Hand hand = new Hand(deck); 
			// using cc
			Hand hand2 = new Hand(hand); 
			// testing copy constructor worked
			assertEquals(hand2.getSize(),14); 
	}
	@Test
	public void testSort() {
		
		// making a deck
		Deck deck = new Deck();
		// shuffling deck
		deck.Shuffle();
		// make a hand 
		Hand hand = new Hand(deck); 
		
		// testing c constructor worked
		assertEquals(hand.getSize(),14); 
		
		//sorting hand
		hand.sortHand();
		
		//printing hand to console to check
		for(int i=0;i<hand.getSize();i++) {
			System.out.print("\n");
			System.out.print(hand.getTile(i));
		}
		
		
		 
		
		
	}
	@Test
	public void testRuns() {
		// make a hand 
		Hand hand = new Hand(); 
		
		
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// making tiles 
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
		
		Game game = new Game(); 
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		//adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7); 
		// testing constructor worked
		assertEquals(hand.getSize(),3); 
		
		// making a run
		
		hand.makeRun(game,t5); 
		
		// testing the run was played
		assertEquals(hand.getSize(),0); 
		assertEquals(game.getTable().numMelds(),1); 
		// adding tiles to make more than one run
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7);
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7);
		//hand.add(t13); 
		hand.add(t9); 
		hand.add(t10); 
		hand.add(t11); 
		
		
		// testing constructor worked
		//assertEquals(hand.getSize(),6); 
		
		// making multiple runs
		Game game2 = new Game(); 
		hand.makeRun(game2,t5);
		
		System.out.print(game2.getTable().getMeldsString());
		assertEquals(game2.getTable().numMelds(),3); 
		
		// testing the runs were played
		assertEquals(hand.getSize(),0); 
		/**/
		// making multiple runs and a set
				Game game3 = new Game();
				hand.add(t5); 
				hand.add(t6); 
				hand.add(t7);
				hand.add(t5); 
				hand.add(t6); 
				hand.add(t7);
				hand.add(t11); 
				hand.add(t12); 
				hand.add(t13); 
				
				hand.makeRun(game3,t5);
				hand.makeSet(game3, t11);
				System.out.print(game3.getTable().getMeldsString());
				// testing runs and sets can both be played from same hand
				assertEquals(game3.getTable().numMelds(),3); 
		
	}
	@Test
	public void testSets() {
		
		// make a hand 
				Hand hand = new Hand(); 
				
				Game game = new Game(); 
				// testing constructor worked
				assertEquals(hand.getSize(),0); 
				// making tiles 
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
				
				
				//adding tiles to make a run of size 3 
				
				hand.add(t11); 
				hand.add(t12); 
				hand.add(t13); 
				hand.add(t8);
				//hand.add(t12);
				//hand.add(t12);
				// testing constructor worked
				assertEquals(hand.getSize(),4); 
				
				// making a run
				
				hand.makeSet(game,t5); 
				
				// testing the run was played
				assertEquals(hand.getSize(),1); 
				
				// testing the run was added to the table
				
				assertEquals(game.getTable().numMelds(),1);
		
		
		
		
	}
	@Test
	public void testMeldInHandSum() {
		// make a hand 
		Hand hand = new Hand(); 
		
		
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// making tiles 
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
		// *******************************************8
		Game game = new Game(); 
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		//adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7); 
		
		//testing the sum of get runsum is 24
		int x =0; 
		assertEquals(hand.getRunSum(hand,hand.get(0),x),24); 
		// testing the players hand isnt touched
		assertEquals(hand.getSize(),3); 
		
		hand.clearHand();
		assertEquals(hand.getSize(),0); 
		hand.add(t13); 
		hand.add(t12); 
		hand.add(t11); 
	//	hand.add(t5);
		x = 0; 
		assertEquals(hand.getSetSum(hand,hand.get(0),x),39); 
		// testing the players hand isnt touched
				assertEquals(hand.getSize(),3); 
		
		
	}
	public void testMeldInHandSum2() {
		// make a hand 
		Hand hand = new Hand(); 
		
		
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// making tiles 
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
		// *******************************************8
		Game game = new Game(); 
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		//adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7);
		hand.add(t11);
		//testing the sum of get runsum is 24
		int x =0; 
		assertEquals(hand.getRunSum(hand,hand.get(0),x),24); 
		// testing the players hand isnt touched
		assertEquals(hand.getSize(),3); 
		
		hand.clearHand();
		assertEquals(hand.getSize(),0); 
		hand.add(t13); 
		hand.add(t12);
		hand.add(t5);
		hand.add(t11); 
		hand.add(t5);
		x = 0; 
		assertEquals(hand.getSetSum(hand,hand.get(0),x),39); 
		// testing the players hand isnt touched
				assertEquals(hand.getSize(),3); 
		
		
	}
	
	public void testMeldInHandSum3() {
		// make a game 
		Game game = new Game(); 
		game.nextTurn();
		Hand hand = new Hand(); 
	
		
		
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// making tiles 
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
		// *******************************************8
		//Game game = new Game(); 
		// testing constructor worked
		assertEquals(hand.getSize(),0); 
		// adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7);
		hand.add(t11);
		//testing the sum of get runsum is 24
		int x =0; 
		assertEquals(hand.getRunSum(hand,hand.get(0),x),24); 
		// testing the players hand isnt touched
		assertEquals(hand.getSize(),3); 
		
		hand.clearHand();
		assertEquals(hand.getSize(),0); 
		hand.add(t13); 
		hand.add(t12);
		hand.add(t5);
		hand.add(t11); 
		hand.add(t5);
		x = 0; 
		assertEquals(hand.getSetSum(hand,hand.get(0),x),39); 
		// testing the players hand isnt touched
				assertEquals(hand.getSize(),3); 
		
		
	}
	
	@Test
	public void TestIdRun() {
		
		Hand h = new Hand();
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
		
		h.add(t5);
		h.add(t6);
		h.add(t7);
		h.add(t13);
		int[] run; 
		assertEquals(4,h.getSize());
		run = h.IdRun();
				
		// range so should be of size 2
		assertEquals(2,run.length);
		// makes sure t5 is the first index
		assertEquals(t5,h.get(run[0]));
		
		
		
	}

}
