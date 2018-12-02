package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HandTest {
	@Test
	public void TestAddToExistingMeldFunc() {
		

		
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
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

		Game game = new Game();
		game.nextTurn();
		Hand hand = game.getCurrHand();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		
		// adding tiles to make a run of size 3
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		
		// testing constructor worked
		assertEquals(hand.getSize(), 3);

		// making a run
		hand.makeSet(game, t11);

		// testing the run was played
		assertEquals(hand.getSize(), 0);
		assertEquals(game.getTable().numMelds(), 1);
		
		
		
		assertEquals(0,game.getCurrHand().getSize());
		hand.add(t14);
		//hand.add(t8);
		assertEquals(1,game.getCurrHand().getSize());
		hand.addToExistingSet(game.getMelds().get(0)); 
		assertEquals(0,game.getCurrHand().getSize());
		assertEquals(4,game.getMelds().get(0).getSize());
	}
	@Test
	public void TestGetAddSum() {
		
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
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

		Game game = new Game();
		game.nextTurn();
		Hand hand = game.getCurrHand();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		
		// adding tiles to make a run of size 3
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		
		// testing constructor worked
		assertEquals(hand.getSize(), 3);

		// making a run
		hand.makeRun(game, t6);

		// testing the run was played
		assertEquals(hand.getSize(), 0);
		assertEquals(game.getTable().numMelds(), 1);
		
		
		
		assertEquals(0,game.getCurrHand().getSize());
		hand.add(t5);
		hand.add(t9);
		
		assertEquals(2,game.getCurrHand().getSize());
		assertEquals(18,game.getCurrHand().getTotalAddSum(game.getFakeMelds(),game.fakeHand()));
		assertEquals(2,game.getCurrHand().getSize());
		
		
		
		
		
	}
	@Test
	public void TestAddToExistingRun() {
		

		
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
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

		Game game = new Game();
		game.nextTurn();
		Hand hand = game.getCurrHand();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		
		// adding tiles to make a run of size 3
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		
		// testing constructor worked
		assertEquals(hand.getSize(), 3);

		// making a run
		hand.makeRun(game, t6);

		// testing the run was played
		assertEquals(hand.getSize(), 0);
		assertEquals(game.getTable().numMelds(), 1);
		
		
		
		assertEquals(0,game.getCurrHand().getSize());
		hand.add(t5);
		hand.add(t9);
		
		assertEquals(2,game.getCurrHand().getSize());
		hand.addToExistingRun(game.getMelds().get(0)); 
		assertEquals(0,game.getCurrHand().getSize());
		assertEquals(5,game.getMelds().get(0).getSize());
	}
	@Test
	public void TestAddToExistingMeld() {
		// make a hand
		Hand hand = new Hand();

		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(hand.getSize(), 0);
		
		// adding tiles to make a run of size 3
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		
		// testing constructor worked
		assertEquals(hand.getSize(), 3);

		// making a run
		hand.makeRun(game, t6);

		// testing the run was played
		assertEquals(hand.getSize(), 0);
		assertEquals(game.getTable().numMelds(), 1);
		
		
		
		//--PART 1
		// test adding a tile to the front of a meld already on the table
		game.getTable().getMeld(0).addFirst(t5);
		game.getTable().getMeld(0).addLast(t9);
		// verify that it still is a meld
		assertEquals(true,game.getTable().getMeld(0).validMeld());
		
		// remove the tile just added
		//game.getTable().getMeld(0).removeTile(t5);
		
		/*
		//--PART 2
		// test adding a tile to the back of a meld already on the table
		game.getTable().getMeld(0).addTile(t9);
		// I don't have to verify it's still a meld, because that's done in the addTile function
		
		// To TEST this, I will remove tile 6, so remaining will be t7, t8, t9 which should be valid
		game.getTable().getMeld(0).removeTile(t6);
		
		// verify that it still is a meld
		assertTrue(game.getTable().getMeld(0).validMeld());
		*/
		
	}



	// @Test
	public void testConstructor() {
		// making a deck
		Deck deck = new Deck();
		// using reg c
		Hand hand = new Hand(deck);
		// testing c worked properly
		assertEquals(hand.getSize(), 14);
	}

	// @Test
	public void testCConstructor() {

		// making a deck
		Deck deck = new Deck();
		// using reg c
		Hand hand = new Hand(deck);
		// using cc
		Hand hand2 = new Hand(hand);
		// testing copy constructor worked
		assertEquals(hand2.getSize(), 14);
	}

	// @Test
	public void testSort() {

		// making a deck
		Deck deck = new Deck();
		// shuffling deck
		deck.Shuffle();
		// make a hand
		Hand hand = new Hand(deck);

		// testing c constructor worked
		assertEquals(hand.getSize(), 14);

		// sorting hand
		hand.sortHand();

		// printing hand to console to check
		for (int i = 0; i < hand.getSize(); i++) {
			System.out.print("\n");
			System.out.print(hand.getTile(i));
		}

	}

	// @Test
	public void testRuns() {
		// make a hand
		Hand hand = new Hand();

		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(hand.getSize(), 0);
		// adding tiles to make a run of size 3
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		// testing constructor worked
		assertEquals(hand.getSize(), 3);

		// making a run

		hand.makeRun(game, t5);

		// testing the run was played
		assertEquals(hand.getSize(), 0);
		assertEquals(game.getTable().numMelds(), 1);
		// adding tiles to make more than one run
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		// hand.add(t13);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);

		// testing constructor worked
		// assertEquals(hand.getSize(),6);

		// making multiple runs
		Game game2 = new Game();
		hand.makeRun(game2, t5);

		System.out.print(game2.getTable().getMeldsString());
		assertEquals(game2.getTable().numMelds(), 3);

		// testing the runs were played
		assertEquals(hand.getSize(), 0);
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

		hand.makeRun(game3, t5);
		hand.makeSet(game3, t11);
		System.out.print(game3.getTable().getMeldsString());
		// testing runs and sets can both be played from same hand
		assertEquals(game3.getTable().numMelds(), 3);

	}

	// @Test
	public void testSets() {

		// make a hand
		Hand hand = new Hand();

		Game game = new Game();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));

		// adding tiles to make a run of size 3

		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		hand.add(t8);
		// hand.add(t12);
		// hand.add(t12);
		// testing constructor worked
		assertEquals(hand.getSize(), 4);

		// making a run

		hand.makeSet(game, t5);

		// testing the run was played
		assertEquals(hand.getSize(), 1);

		// testing the run was added to the table

		assertEquals(game.getTable().numMelds(), 1);

	}

	@Test
	public void testMeldInHandSum() {
		// make a hand
		Hand hand = new Hand();

		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		game.nextTurn();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// adding tiles to make a run of size 3
		hand.add(t13);
		hand.add(t12);
		hand.add(t11);
		assertEquals(hand.getSize(), 3);
		// testing the sum of get runsum is 24
		// int x =0;
		// make a duplicate hand so the original doesnt get altered
		// when calculating the sum
		// Hand h = new Hand(game.fakeHand());
		Hand h = new Hand(hand);
		assertEquals(3, h.getSize());
		assertEquals(39, h.IdSets());
		// testing the players hand isnt touched
		assertEquals(hand.getSize(), 3);

		hand.clearHand();
		assertEquals(hand.getSize(), 0);
		hand.add(t5); // 7
		hand.add(t6); // 8
		hand.add(t7); // 9
		//hand.add(t8); // 10
		//hand.add(t5);
		// x = 0;
		hand.sortHand(); //SORT THE PLAYER'S HAND. WE CAN ASSUME TILES ARE IN ASCENDING ORDER BY COLOUR!
		h = new Hand(hand);
		System.out.println(hand);
		assertEquals(24, h.IdRuns());
		System.out.println(hand);
		// testing the players hand isnt touched
		// assertEquals(hand.getSize(),3);

	}

	public void testMeldInHandSum2() {
		// make a hand
		Hand hand = new Hand();

		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(hand.getSize(), 0);
		// adding tiles to make a run of size 3
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t11);
		// testing the sum of get runsum is 24
		int x = 0;
		assertEquals(hand.getRunSum(hand, hand.get(0), x), 24);
		// testing the players hand isnt touched
		assertEquals(hand.getSize(), 3);

		hand.clearHand();
		assertEquals(hand.getSize(), 0);
		hand.add(t13);
		hand.add(t12);
		hand.add(t5);
		hand.add(t11);
		hand.add(t5);
		x = 0;
		assertEquals(hand.getSetSum(hand, hand.get(0), x), 39);
		// testing the players hand isnt touched
		assertEquals(hand.getSize(), 3);

	}

	public void testMeldInHandSum3() {
		// make a game
		Game game = new Game();
		game.nextTurn();
		Hand hand = new Hand();

		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// making tiles
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		// Game game = new Game();
		// testing constructor worked
		assertEquals(hand.getSize(), 0);
		// adding tiles to make a run of size 3
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t11);
		// testing the sum of get runsum is 24
		int x = 0;
		assertEquals(hand.getRunSum(hand, hand.get(0), x), 24);
		// testing the players hand isnt touched
		assertEquals(hand.getSize(), 3);

		hand.clearHand();
		assertEquals(hand.getSize(), 0);
		hand.add(t13);
		hand.add(t12);
		hand.add(t5);
		hand.add(t11);
		hand.add(t5);
		x = 0;
		assertEquals(hand.getSetSum(hand, hand.get(0), x), 39);
		// testing the players hand isnt touched
		assertEquals(hand.getSize(), 3);

	}

	// @Test
	public void TestIdRun() {

		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		h.add(t5);
		h.add(t6);
		h.add(t7);
		h.add(t13);
		int[] run;
		assertEquals(8, h.getSize());
		run = h.IdRun();

		// range so should be of size 2
		assertEquals(2, run.length);
		// makes sure t5 is the first index
		assertEquals(t5, h.get(run[0]));

	}

	// @Test
	public void TestIdRuns() {
		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));

		//
		h.add(t5);
		h.add(t6);
		h.add(t7);
		h.add(t8);

		h.add(t5);
		h.add(t6);
		h.add(t7);
		h.add(t8);
		h.add(t13);

		h.sortHand();

		/*
		*/
		int run;
		assertEquals(9, h.getSize());
		run = h.IdRuns();
		// assertEquals(1,h.getSize());
		// sum should be 48
		assertEquals(68, run);

	}

	// @Test
	public void TestPlayRun() {
		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
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
		assertEquals(4, h.getSize());
		run = h.IdRun();
		List<Tile> list;
		list = h.playRun(run);

		// range so should be of size 2
		assertEquals(2, run.length);
		// makes sure the run is size 3
		assertEquals(3, list.size());
		assertEquals(1, h.getSize());

	}

	// @Test
	public void TestIdSet() {

		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));

		h.add(t11);
		h.add(t12);
		h.add(t13);
		h.add(t13);
		List<Integer> set;
		assertEquals(4, h.getSize());
		set = h.IdSet();

		// size of the set should be 3.
		assertEquals(3, set.size());

	}

	// @Test
	public void TestIdSets() {
		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));

		//

		h.add(t11);
		h.add(t12);
		h.add(t13);

		h.sortHand();

		int set;
		assertEquals(3, h.getSize());
		set = h.IdSets();
		// assertEquals(1,h.getSize());
		// sum should be 48
		assertEquals(39, set);

	}

	/**/
	// @Test
	public void TestPlaySet() {
		Hand h = new Hand();
		Tile t5, t6, t7, t8, t9, t10, t11, t12, t13;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Orange, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));

		h.add(t11);
		h.add(t12);
		h.add(t13);

		List<Integer> ind;
		List<Tile> set;
		ind = h.IdSet();
		set = h.playSet(ind);
		assertEquals(3, set.size());
	}
	}
	
	