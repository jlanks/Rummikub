package core;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	// making a player and adding to players hand from the game deck
	
	public void testAdd() {
		
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player("Julian"); 
		
		
		// adding tile from deck
		Julian.addTile(MainDeck.getTopTile()); 
		
		// testing
		assertEquals(1,Julian.getHandSize());
		}
	
	public void testRemove() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player("JUlian"); 
		Tile testtile = new Tile(Colour.Red,10); 
		
		// calling add function
		Julian.addTile(testtile); 
		// testing add was successful
		assertEquals(1,Julian.getHandSize());
		//  removing tile
		Julian.RemoveTile(0); 
		// testing remove was successful
		assertEquals(0,Julian.getHandSize());
		}
	/*
	public void testCreateMeld() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		
		
		// adding tiles
		Julian.addTile(new Tile(R,10)); 
		Julian.addTile(new Tile(B,10)); 
		Julian.addTile(new Tile(G,10)); 
		
		
		// testing return value is of type meld
		assertEquals(** MELD RETURN **,Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard()));
		
		}
	
	/*
	public void testEditMeld() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		Meld meld; 
		
		// adding tiles
		Julian.addTile(new Tile(R,5)); 
		Julian.addTile(new Tile(R,6)); 
		Julian.addTile(new Tile(R,7)); 
		
		meld = Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
		
		Julian.editMeld(meld,new Tile(R,8)); 
		
		// testing return value is of type meld
		assertEquals();
		
		}
	
	public void test_toSting() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		
		
		// adding tiles
		Julian.addTile(new Tile(R,10)); 
		Julian.addTile(new Tile(B,10)); 
		
		
		
		// testing return value is of type meld
		assertEquals("Player:/nJulian/nCards:/n10 Red/10 Blue",Julian.toString());
		
		}
*/
}
