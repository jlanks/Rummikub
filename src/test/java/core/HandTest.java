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
		Tile t5,t6,t7,t8,t9;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		
		//adding tiles to make a run of size 3 
		hand.add(t5); 
		hand.add(t6); 
		hand.add(t7); 
		// testing constructor worked
		assertEquals(hand.getSize(),3); 
		
		// making a run
		
		hand.makeRun(); 
		
		// testing the run was played
		assertEquals(hand.getSize(),0); 
		
		
		
	}
	@Test
	public void testSets() {
		
		// make a hand 
				Hand hand = new Hand(); 
				
				Game game = new Game(); 
				// testing constructor worked
				assertEquals(hand.getSize(),0); 
				// making tiles 
				Tile t5,t6,t7,t8,t9;
				t5 = (new Tile(Colour.Orange, 10));
				t6 = (new Tile(Colour.Green, 10));
				t7 = (new Tile(Colour.Blue, 10));
				t8 = (new Tile(Colour.Red, 10));
				
				
				//adding tiles to make a run of size 3 
				hand.add(t5); 
				hand.add(t6); 
				hand.add(t7); 
				hand.add(t8);
				// testing constructor worked
				assertEquals(hand.getSize(),4); 
				
				// making a run
				
				hand.makeSet(game,t5); 
				
				// testing the run was played
				assertEquals(hand.getSize(),0); 
				
				// testing the run was added to the table
				
				assertEquals(game.getTable().numMelds(),1);
		
		
		
		
	}

}
