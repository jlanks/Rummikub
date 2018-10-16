package core;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class MeldTest extends TestCase{

	
	public void testAddingToMeld() {
				
				// initializing 
				Deck MainDeck = new Deck(); 
				Player Julian = new Player("Julian"); 
				Meld NewMeld; 
				Tile t1, t2, t3; 
				
				// adding tiles
				t1 = (new Tile(Colour.Red,10)); 
				t2 = (new Tile(Colour.Blue,10)); 
				t3 = (new Tile(Colour.Green,10)); 
				
				// Making meld
				NewMeld = new Meld(t1,t2,t3,false); 
				
				// making sure invalid tiles are not able to be added
			assertEquals(30,NewMeld.getSum());
				// making sure valid tiles are added
			//	assertEquals(true,NewMeld.addTile(new Tile(O,10)));
	}
	/*
	public void testRemoveFromMeld() {
		
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		Meld NewMeld; 
		
		// adding tiles
		Julian.addTile(new Tile(R,10)); 
		Julian.addTile(new Tile(B,10)); 
		Julian.addTile(new Tile(G,10)); 
		
		// Making meld
		NewMeld = Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
		NewMeld.RemoveTile(R,10); 
		// ensuring that tiles have been removed
		assertEquals(2,NewMeld.getSize());
		
}
	
	
	public void testAppendMeld() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		Meld NewMeld; 
		Meld meld; 
		
		// adding tiles
		Julian.addTile(new Tile(R,2)); 
		Julian.addTile(new Tile(R,3)); 
		Julian.addTile(new Tile(R,4)); 
		
		
		// Making meld
		NewMeld = Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
		NewMeld.AppendTile(new Tile(R,5)); 
		
	
		assertEquals(4,NewMeld.getSize());
		
	}
	
	public void testSplitMeld() {
		// initializing 
		Deck MainDeck = new Deck(); 
		Player Julian = new Player(); 
		Meld NewMeld; 
		Meld meld; 
		
		// adding tiles
		Julian.addTile(new Tile(R,2)); 
		Julian.addTile(new Tile(R,3)); 
		Julian.addTile(new Tile(R,4)); 
		Julian.addTile(new Tile(R,5)); 
		Julian.addTile(new Tile(R,6)); 
		Julian.addTile(new Tile(R,7)); 
		
		// Making meld
		NewMeld = Julian.makeMeld(Julian.getCard(),Julian.getCard(),Julian.getCard());
		NewMeld.addTile(Julian.getCard()); 
		NewMeld.addTile(Julian.getCard()); 
		NewMeld.addTile(Julian.getCard()); 
		
		meld = NewMeld.split();
		// ensuring that meld was split
		assertEquals(3,NewMeld.getSize());
		assertEquals(3,meld.getSize());
		
		
}
	*/

}
