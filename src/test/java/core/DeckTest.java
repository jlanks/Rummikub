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
		Deck tester = new Deck();
		assertNotNull(tester); //should be a success

		//test to confirm it has 106 tiles
		assertEquals(104,tester.getDeckSize());


		//tests twice, to confirm it has 1 less tile after removal
		tester.getTopTile(); //removes a top tile
		assertEquals(103,tester.getDeckSize());

		tester.getTopTile(); //removes the next top tile
		assertEquals(102,tester.getDeckSize());
		/**/
	}
	
	
	// This tests: the deck's shuffler AND next card dealer methods
	
	public void testShuffleTiles() {
		
		// Deck creation
		Deck Deck = new Deck(false);
		
		// Tile creation (to compare the top card).
		// Red 1 should be the top card of an unshuffled deck
		Tile test = new Tile(Colour.Red,1);
		
		
		
		// making sure the top card is red, 1
		assertEquals(1,Deck.getTopTile().getValue());
		assertEquals(Colour.Red,Deck.getTopTile().getColour());
		
		// shuffling deck 
		 Deck.Shuffle(); 
		
		 //makes sure the top card is not (red,1). This means cards have been shuffled.
		 assertNotEquals(1,Deck.getTopTile().getValue());
		 assertNotEquals(Colour.Red,Deck.getTopTile().getColour());
		
	}

}
