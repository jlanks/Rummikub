package core;

import static org.junit.Assert.*;

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
		
		
		
		
	}
	@Test
	public void testRuns() {
		
		
	}
	@Test
	public void testSets() {
		
		
		
	}

}
