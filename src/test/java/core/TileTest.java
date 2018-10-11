package core;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

public class TileTest extends TestCase{
	/**
	* This tests: the tile constructor 
	*/
	public void testTile(){

		//this confirms the tile was made
		Card tester = new Card(Color.values()[1], 8);
		assertNotNull(tester); //should be a success
	}
	

	/**
	* This tests/confirms: that the tile's color and value are set 
	*/
	public void testCheckColorAndValue(){
		Color compare = Color.values()[1];
		Card tester = new Card(Color.values()[1], 6);
		assertNotNull(tester); //should be a success
		
		//this confirms the tile's color
		assertEquals(compare,tester.color());

		
		//this confirms the tile's color
		assertEquals(6,tester.rank());
	}
	
}
