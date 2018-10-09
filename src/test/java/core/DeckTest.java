package core;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest extends TestCase{
	/**
	* This tests: the deck constructor, removing a tile, and numTiles
	*/
	public void testDeck(){
		//Make a deck of tiles
		assertNotNull(tester); //should be a fail
		Deck tester = new Deck();
		assertNotNull(tester); //should be a success

		//test to confirm it has 106 tiles
		assertEquals(106,tester.numTiles());


		//tests twice, to confirm it has 1 less tile after removal
		tester.remove(0); //removes a tile
		assertEquals(105,tester.numTiles());

		tester.remove(0); //removes another tile
		assertEquals(104,tester.numTiles());
	}
	
	/**
	* This tests: the deck's shuffler AND next card dealer methods
	*/
	public void testShuffleTiles() {
		//Make 4 decks of tiles, then shuffle 2 of them
		Deck normalDeckOne = new Deck();
		Deck normalDeckTwo = new Deck();
		Deck shuffledOne = new Deck();
		Deck shuffledTwo = new Deck();
		shuffledOne.shuffle();
		shuffledTwo.shuffle();
		
		//Each line pulls the top card from two different un-shuffleded decks, and checks if they are equal
		assertEquals(true, normalDeckOne.nextTile().rank() == normalDeckTwo.nextTile().rank());
		assertEquals(true, normalDeckOne.nextTile().rank() == normalDeckTwo.nextTile().rank());
		
		//Each line pulls the top card from two different shuffleded decks, and checks if they are equal
		assertEquals(false, shuffledOne.nextTile().rank() == shuffledTwo.nextTile().rank());
		assertEquals(false, shuffledOne.nextTile().rank() == shuffledTwo.nextTile().rank());
	}

}
