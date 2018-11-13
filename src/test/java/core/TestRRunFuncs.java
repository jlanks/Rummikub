package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRRunFuncs {

	@Test
	public void test() {
		// making a game

				Game game = new Game();
				Player P1 = game.getTable().player2();

				// giving p1 the cards to make a set
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 10));
				//sgame.getTable().init();
				game.nextTurn();
				
				// player should make a set and add it to the table
				// player makes their move
				
				assertEquals(4, P1.getHandSize());
				
				P1.Play(game);

				// this means hand size will be zero
				assertEquals(0, P1.getHandSize());
				
				// this means the table will have a meld on it
				assertEquals(1, game.getTable().numMelds());
				
				// this means the table will have a meld on it of correct size
				assertEquals(4, game.getTable().getMeld(0).getSize());
				
				P1.getHand().clear();
				
				// making sure the players hand is empty
				assertEquals(0,P1.getHandSize()); 
				
				// giving p1 the cards to make a set (3) but with other tiles in the "hand"
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 13));
				P1.addTile(new Tile(Colour.Blue, 1));
				P1.addTile(new Tile(Colour.Green, 4));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 8));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 10));
				
				//System.out.print(P1.getHand().toString());
				// making sure the players hand has 8 tiles
				assertEquals(8,P1.getHandSize()); 
				// player makes their move
				
				P1.Play(game);
				//System.out.print(P1.getHand().toString());
				// this means hand size will be five
				assertEquals(5, P1.getHandSize());
				
				// this means the table will have 2 meld on it
				assertEquals(2, game.getTable().numMelds());
				// testing that the hand size has been updated
				assertEquals(5, P1.getHandSize());
				// resetting hand 
				P1.getHand().clear();
				// making sure the players hand is empty
				assertEquals(0,P1.getHandSize()); 
				
				// giving p1 the cards to make a set (4) but with other tiles in the "hand"
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 13));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 4));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 8));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 10));
				
				// player makes their move

				P1.Play(game);
				
				// this means the table will have 3 meld on it
				assertEquals(3, game.getTable().numMelds());
				assertEquals(4,game.getTable().player2().getHandSize());
				
				
				// now need to test running this process when the player has more than
				// one set available to make
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 2 sets in the players hand 
				// this hand has a set of 9s and 10s. 
				// both of size 3 
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 4));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 9));
				P1.addTile(new Tile(Colour.Orange, 10));
			
				// testing if hand size is correct
				assertEquals(8,P1.getHandSize()); 
				
				// making and adding more than one set 
				
				P1.Play(game); 
				
				// making all cards were taken out of players hand 
				assertEquals(2,P1.getHandSize());
				
				// making sure 2 melds were added to the table 
				assertEquals(5,game.getTable().numMelds());
				
				//****
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 2 sets in the players hand 
				// this hand has a set of 9s and 10s. 
				// one of size 3, one of size 4
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 9));
				P1.addTile(new Tile(Colour.Orange, 10));
			
				// testing if hand size is correct
				assertEquals(8,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(1,P1.getHandSize());
				
				
				// making sure 2 melds were added to the table 
				assertEquals(2,game.getTable().numMelds());
				
				//********
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 2 sets in the players hand 
				// this hand has a set of 9s and 10s. 
				// one of size 4, one of size 4
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 9));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 9));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 3));
			
				// testing if hand size is correct
				assertEquals(11,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(3,P1.getHandSize());
				
				
				// making sure 2 melds were added to the table 
				assertEquals(2,game.getTable().numMelds());
				//*********
				
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 3 sets in the players hand 
				// this hand has a set of 8s, 9s and 10s. 
				// one of size 3, one of size 3, one of size 3
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 2));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 2));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 9));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Green, 8));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Blue, 8));
			
				// testing if hand size is correct
				assertEquals(13,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(4,P1.getHandSize());
				
				
				// making sure 3 melds were added to the table 
				assertEquals(3,game.getTable().numMelds());
				
				
				//*****
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 3 sets in the players hand 
				// this hand has a set of 8s, 9s and 10s. 
				// one of size 4, one of size 3, one of size 3
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 2));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 9));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Green, 8));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Blue, 8));
			
				// testing if hand size is correct
				assertEquals(13,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(3,P1.getHandSize());
				
				
				// making sure 3 melds were added to the table 
				assertEquals(3,game.getTable().numMelds());
				//*****
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 3 sets in the players hand 
				// this hand has a set of 8s, 9s and 10s. 
				// one of size 4, one of size 4, one of size 4
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 9));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 9));
				P1.addTile(new Tile(Colour.Red, 8));
				P1.addTile(new Tile(Colour.Green, 8));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Blue, 8));
				P1.addTile(new Tile(Colour.Blue, 5));
			
				// testing if hand size is correct
				assertEquals(14,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(2,P1.getHandSize());
				
				
				// making sure 3 melds were added to the table 
				assertEquals(3,game.getTable().numMelds());
				
				//*****
				
				// clearing hand 
				P1.getHand().clear();
				
				// testing if call was successful
				assertEquals(0,P1.getHandSize()); 
				
				// making 3 sets in the players hand 
				// this hand has a set of 8s, 9s and 10s. 
				// one of size 4, one of size 4, one of size 3
				P1.addTile(new Tile(Colour.Red, 10));
				P1.addTile(new Tile(Colour.Red, 9));
				P1.addTile(new Tile(Colour.Blue, 10));
				P1.addTile(new Tile(Colour.Green, 10));
				P1.addTile(new Tile(Colour.Orange, 6));
				P1.addTile(new Tile(Colour.Blue, 9));
				P1.addTile(new Tile(Colour.Green, 2));
				P1.addTile(new Tile(Colour.Orange, 10));
				P1.addTile(new Tile(Colour.Orange, 9));
				P1.addTile(new Tile(Colour.Red, 8));
				P1.addTile(new Tile(Colour.Green, 8));
				P1.addTile(new Tile(Colour.Orange, 8));
				P1.addTile(new Tile(Colour.Blue, 8));
			
				// testing if hand size is correct
				assertEquals(13,P1.getHandSize()); 
				
				// clearing table melds
				game.getTable().clearMT();
				
				// making sure the table has no melds on it
				assertEquals(0,game.getTable().numMelds()); 
				
				// playing
				
				P1.Play(game); 
				
				// making sure all cards were taken out of players hand 
				assertEquals(2,P1.getHandSize());
				
				
				// making sure 3 melds were added to the table 
				assertEquals(3,game.getTable().numMelds());
				/**/
				
			}
}
