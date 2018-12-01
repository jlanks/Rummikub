package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Hand {

	// class which represents a players hand

	// function requirements
	/*
	 * 
	 * - linkedlist represents the hand - constructor which has a deck argument -
	 * copy constructor which takes a hand argument - sort method ->
	 * collections.sort - detectruns function -
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// hand

	LinkedList<Tile> Hand;

	// deck

	Deck deck;

	// Constructor
	public Hand(Deck d) {
		this.deck = d;
		Hand = new LinkedList<Tile>();
		for (int i = 0; i < 14; i++) {
			Hand.add(deck.getTopTile());
		}

	}

	public Hand() {

		Hand = new LinkedList<Tile>();

	}

	// Copy Constructor
	public Hand(Hand h) {

		Hand = new LinkedList<Tile>();
		for (int i = 0; i < h.getSize(); i++) {
			Hand.add(h.getTile(i));
		}

	}

	// sorting method

	public void sortHand() {
		Collections.sort(this.Hand);

	}

	public int getSize() {
		return Hand.size();
	}

	public Tile getTile(int i) {
		return Hand.get(i);

	}

	public List<Integer> IdSet() {
		List<Integer> ind = new ArrayList<Integer>();
		int[] occ = new int[13];
		for (int i = 0; i < this.getSize(); i++) {
			Tile t = this.getTile(i);
			int val = t.getValue();
			occ[val - 1]++;

		}
		// System.out.print("HI");
		int max = max(occ);
		if (max < 3) {
			// System.out.print("HI");
			return null;
		} else {
			int n = 0;
			for (int i = 0; i < occ.length; i++)
				if (occ[i] == max)
					n = i + 1;
			for (int i = 0; i < this.getSize(); i++) {
				Tile t = this.getTile(i);

				if (t.getValue() == n) {
					// System.out.print("HI");
					ind.add(i);
				}

			}
			HashSet<String> unq = new HashSet<String>();
			for (int i : ind)
				unq.add(this.getTile(i).toString());
			if (unq.size() >= 3) {

				List<Integer> out = new ArrayList();
				for (String s : unq) {
					out.add(this.indexOf(new Tile(s)));
				}
				return out;
			} else
				return null;

		}

	}

	public int indexOf(Tile t) {
		for (int i = 0; i < this.getSize(); i++) {
			if (this.getTile(i).equals(t))
				return i;
		}
		return -1;

	}

	public List<Tile> playSet(List<Integer> ind) {
		HashSet<Integer> unique = new HashSet<Integer>();
		List<Tile> set = new ArrayList<Tile>();
		for (Integer i : ind)
			unique.add(i);
		for (int i = this.getSize() - 1; i > -1; i--)
			if (unique.contains(i))
				set.add(this.remove(i));
		return set;
	}

	public int IdSets() {
		List<Integer> set;
		int sum = 0;
		while ((set = IdSet()) != null) {
			List<Tile> l = playSet(set);
			System.out.println(l);
			sum += sum(l);
		}
		return sum;
	}

	/**/
	public int max(int[] arr) {

		int max = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;

	}

	public int[] IdRun() {

		if (this.getSize() < 3) {
			return null;
		}

		int startIndex = 0;
		int lastIndex = -1;

		for (int i = 1; i < this.getSize(); i++) {

			int result = consecutive(i);

			if (result == 1 && i - startIndex > 1) {

				lastIndex = i;
			} else if (result == -1) {

				if (lastIndex != -1) {

					HashSet<String> unq = new HashSet();

					for (int w = startIndex; w <= lastIndex; w++) {

						String string = this.get(w).toString();
						unq.add(string);

					}
					if (unq.size() >= 3) {

						return new int[] { startIndex, lastIndex };
					} else
						startIndex = i;
				} else
					startIndex = i;
			} else {
				continue;
			}
		}
		return null;
	}

	public int consecutive(int i) {

//		Tile before = this.get(i - 1);
//		Tile current = this.get(i);
//		if (before.equals(current))
//			return 0;
//		else if (before.getColour() == current.getColour() && current.getValue() - before.getValue() == 1)
//			return 1;
//		else
//			return -1;

		Tile current = this.get(i);
		Tile after = this.get(i + 1);

		if (current.equals(after)) {
			return 0;
		} else if (current.getColour() == after.getColour() && after.getValue() - current.getValue() == 1) {
			return 1;
		} else {
			return -1;
		}

	}

	public List<Tile> playRun(int[] range) {

		int removals = range[1] - range[0] + 1;
		List<Tile> run = new ArrayList<Tile>();
		Tile last = null;
		for (int i = 0; i < removals; i++) {
			if (i != 0) {
				Tile t = this.get(range[0]);
				if (!t.equals(last)) {
					last = this.remove(range[0]);
					run.add(last);
				} else
					range[0]++;
			} else {
				last = this.remove(range[0]);
				run.add(last);
			}
		}
		return run;
	}

	public int IdRuns() {
		int[] run;
		int sum = 0;

//		if(this.getSize() == 3) {
//			for(int i = 0; i < this.getSize()-1; i++) {
//				if(this.get(i).getValue() == this.get(i+1).getValue()-1) {
//					// Tile i & Tile i+1 are consecutive
//					sum += this.get(i).getValue();
//				} else {
//					return 0;
//				}
//			}
//			sum += this.get(this.getSize()-1).getValue();
//			return sum;
//		}
		int currRunSize = 0;
		int currRunValue = 0;
		for (int i = 0; i < this.getSize() - 1; i++) {
			System.out.println("Value of hand[" + i + "] = " + this.get(i).getValue() + " Value of hand[" + (i+1) + "] = " + this.get(i+1).getValue() );
			if (this.get(i).getValue() == this.get(i + 1).getValue() - 1 && this.get(i).getColour() == this.get(i + 1).getColour()) {
				// Tile i & Tile i+1 are consecutive
				System.out.println("CONSECUTIVE");
				if (currRunSize == 0) {
					currRunSize++;
					currRunValue += this.get(i).getValue();
				}
				
				currRunSize++;
				currRunValue += this.get(i+1).getValue();
				
				if(i == this.getSize()-2) {
					sum += currRunValue;
				}
			} else {
				System.out.println("NOT CONSECUTIVE");
				
				if(currRunSize >= 3) {
					sum += currRunValue;
					System.out.println("Sum = " + sum);
				}
				currRunValue = 0;
				currRunSize = 0;
			}
		}
		return sum;

//		while ((run = detectRun()) != null) {
//			List<Tile> l = playRun(run);
//			System.out.println(l);
//			sum += sum(l);
//		}
//		return sum;
	}

	public int[] detectRun() {
		if (this.getSize() < 3) {
			return null;
		}

		int beginIndex = 0;
		int endIndex = -1;
		for (int i = 0; i < this.getSize() - 1; i++) {
			int result = consecutive(i);
			if (result == 1 && i - beginIndex > 1) {
				endIndex = i + 1;
			} else if (result == -1) {
				if (endIndex != -1) {
					HashSet<String> unique = new HashSet<String>();
					for (int j = beginIndex; j <= endIndex; j++) {
						String s = this.get(j).toString();
						unique.add(s);
					}
					if (unique.size() >= 3) {
						return new int[] { beginIndex, endIndex };
					} else
						beginIndex = i;
				} else
					beginIndex = i;
			} else {
				continue;
			}
		}
		return null;
	}

	public void makeRun(Game game, Tile t) {

		// the temporary meld going to be used
		ArrayList<Tile> tempmeld = new ArrayList<Tile>();
		// the current tile
		Tile curr = t;
		// indexes of used tiles
		ArrayList index = new ArrayList();
		// sorting hand in ascending order
		this.sortHand();
		// adding the current tile to the temporary meld
		tempmeld.add(curr);
		// adding valid tiles
		for (int i = 0; i < this.getSize(); i++) {
			// adding all the valid tiles to the temporary meld
			if (this.getTile(i).getColour() == curr.getColour() && this.getTile(i).getValue() == curr.getValue() + 1) {
				// adding the index
				index.add(i);
				// updating the tile which needs to be compared
				curr = this.getTile(i);
				// adding the tile, since its valid
				tempmeld.add(curr);

			}

		}
		// index of current tile
		int indexof = 0;

		// looping through the hand to find the index

		for (int i = 0; i < Hand.size(); i++) {

			if (i == Hand.size() && Hand.get(i) != t) {

				indexof = -1;
			}
			if (Hand.get(i).equals(t)) {
				indexof = i;
			}
		}
		// meld to be added to the table
		Meld addmeld = new Meld(tempmeld);
		// checking to see if the meld is valid
		if (addmeld.validMeld()) {
			// if valid, then it will be played. remove the cards from the hand
			for (int i = 0; i < tempmeld.size(); i++) {
				// removing cards from hand
				this.remove(tempmeld.get(i));
			}
			game.getTable().addMeld(addmeld);
			if (Hand.size() > 0)
				makeRun(game, Hand.get(0));

			if (Hand.size() <= 0)
				return;

		}
		// when the meld is not valid and index is less than hand size
		if (!addmeld.validMeld() && indexof < Hand.size() - 1) {

			// ****** this was make set
			makeRun(game, Hand.get(indexof + 1));
		}

		// when the index is at the last and meld is invalid
		if (indexof + 1 >= Hand.size() && !addmeld.validMeld()) {

			return;
		}

	}

	public void remove(Tile tile) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getSize(); i++) {
			if (this.getTile(i).equals(tile))
				Hand.remove(i);
		}

	}

	public Tile remove(int tile) {
		// TODO Auto-generated method stub
		Tile t = Hand.get(tile);

		Hand.remove(tile);
		return t;

	}

	public void add(Tile t) {
		Hand.add(t);

	}
	public int getSum() {
		int x = 0; 
		for(int i=0;i<Hand.size();i++) {
			x += Hand.get(i).getValue();
			
		}
		return x; 
	}
	// function which tries and make a run in with the players tiles.
	// when calling initially, tile should be the first tile of the players hand
	// game is the current game

	public void makeSet(Game game, Tile t) {

		// the list of colours already used
		ArrayList<Colour> col = new ArrayList<Colour>();

		// the temporary meld going to be used
		ArrayList<Tile> tempmeld = new ArrayList<Tile>();

		// the tile which will be the comparison basis
		Tile compare = t;

		// the current games table
		Table table = game.getTable();

		// adding the tile argument to the meld array
		tempmeld.add(t);
		this.sortHand();
		// adding tiles with all the same value

		// loops through all the tiles in the players hand
		for (int i = 0; i < this.getSize(); i++) {

			// if the value is the same, but the colour is not,
			// and the colour has not already been added
			// then add to the temp meld

			if (Hand.get(i).getValue() == compare.getValue() && Hand.get(i).getColour() != compare.getColour()
					&& !Hand.get(i).equals(t) && !(col.contains(Hand.get(i).getColour()))) {

				// adding to tile to the temp meld
				tempmeld.add(Hand.get(i));
				// adding the colour to the colour meld
				col.add(Hand.get(i).getColour());

			}
		}

		// making the meld to be added to the table
		Meld addmeld = new Meld(tempmeld);

		// index of current tile
		int index = 0;

		// looping through the hand to find the index

		for (int i = 0; i < Hand.size(); i++) {

			if (i == Hand.size() && Hand.get(i) != t) {

				index = -1;
			}
			if (Hand.get(i).equals(t)) {
				index = i;
			}
		}

		// making sure the meld is valid
		if (addmeld.validMeld()) {

			// if the meld is valid then the cards from the players hand need to be removed
			for (int i = 0; i < tempmeld.size(); i++) {
				// removing cards from hand
				Hand.remove(tempmeld.get(i));
			}

			// if the meld is valid, it will be added to the table
			table.addMeld(addmeld);

			if (Hand.size() > 0)
				makeSet(game, Hand.get(0));

			if (Hand.size() <= 0)
				return;

		}

		// when the meld is not valid and index is less than hand size
		if (!addmeld.validMeld() && index < Hand.size() - 1) {

			makeSet(game, Hand.get(index + 1));
		}

		// when the index is at the last and meld is invalid
		if (index + 1 >= Hand.size() && !addmeld.validMeld()) {

			return;
		}

	}

	public Tile get(int i) {
		// TODO Auto-generated method stub
		return Hand.get(i);
	}

	public void clearHand() {
		Hand.clear();

	}

	public int sum(List<Tile> tiles) {
		int total = 0;
		for (Tile tile : tiles)
			total += tile.getValue();
		return total;
	}

	// call this with the current players hand the current tile of search and the
	// total
	public int getRunSum(Hand hand, Tile t, int total) {

		int sum = 0;
		// the temporary meld going to be used
		ArrayList<Tile> tempmeld = new ArrayList<Tile>();
		// the current tile
		Tile curr = t;
		// making a new hand separate to the players so the players hand is not messed
		// up

		Hand temphand = hand;

		// indexes of used tiles
		ArrayList index = new ArrayList();
		// sorting hand in ascending order
		temphand.sortHand();
		// adding the current tile to the temporary meld
		tempmeld.add(curr);
		// adding valid tiles
		for (int i = 0; i < temphand.getSize(); i++) {
			// adding all the valid tiles to the temporary meld
			if (temphand.getTile(i).getColour() == curr.getColour()
					&& temphand.getTile(i).getValue() == curr.getValue() + 1) {
				// adding the index
				index.add(i);
				// updating the tile which needs to be compared
				curr = temphand.getTile(i);
				// adding the tile, since its valid
				tempmeld.add(curr);

			}

		}
		// index of current tile
		int indexof = 0;

		// looping through the hand to find the index

		for (int i = 0; i < temphand.getSize(); i++) {

			if (i == temphand.getSize() && temphand.get(i) != t) {

				indexof = -1;
			}
			if (temphand.get(i).equals(t)) {
				indexof = i;
			}
		}
		// meld to be added to the table
		Meld addmeld = new Meld(tempmeld);
		// checking to see if the meld is valid
		if (addmeld.validMeld()) {
			// if valid then you need to add the sum of the meld to the new total
			sum += addmeld.getSum();
			// if valid, then it will be played. remove the cards from the hand
			for (int i = 0; i < tempmeld.size(); i++) {
				// removing cards from hand
				temphand.remove(tempmeld.get(i));
			}
			// game.getTable().addMeld(addmeld);
			if (temphand.getSize() > 0)
				// makeRun(newgame,temphand);
				temphand.getRunSum(temphand, temphand.get(0), total + sum);

			if (temphand.getSize() <= 0) {
				int x = 0;
				x = total + sum;
				total = 0;
				return x;
			}

		}
		// when the meld is not valid and index is less than hand size
		if (!addmeld.validMeld() && indexof < temphand.getSize() - 1) {

			temphand.getRunSum(temphand, temphand.get(indexof + 1), total);
		}

		// when the index is at the last and meld is invalid
		if (indexof + 1 >= temphand.getSize() && !addmeld.validMeld()) {

			int x = 0;
			x = total + sum;
			total = 0;
			return x;
		}

		return 0;

	}


	// call this with the current players hand the current tile of search and the
	// total
	public int getSetSum(Hand hand, Tile t, int total) {
		// total sum
		int sum = 0;
		// the current tile
		Tile curr = t;
		// the list of colours already used, adding the current tiles colour
		ArrayList<Colour> col = new ArrayList<Colour>();
		col.add(curr.getColour());

		// the temporary meld going to be used
		ArrayList<Tile> tempmeld = new ArrayList<Tile>();

		// making a new hand which is separate to the players
		// so the players hand is not messed up
		Hand temphand = new Hand(this);

		// indexes of used tiles
		ArrayList index = new ArrayList();

		// sorting hand in ascending order
		temphand.sortHand();
		// adding the current tile to the temporary meld
		tempmeld.add(curr);

		// adding valid tiles
		for (int i = 0; i < temphand.getSize(); i++)

			if (temphand.get(i).getValue() == curr.getValue() && temphand.get(i).getColour() != curr.getColour()
					&& !(col.contains(temphand.get(i).getColour()))) {

				// adding to tile to the temp meld
				tempmeld.add(temphand.get(i));

				// adding the colour to the colour meld
				col.add(temphand.get(i).getColour());

			}

		// index of current tile
		int indexof = 0;

		// looping through the hand to find the index

		for (int i = 0; i < temphand.getSize(); i++) {

			if (i == temphand.getSize() && temphand.get(i) != t) {

				indexof = -1;
			}
			if (temphand.get(i).equals(t)) {

				indexof = i;
			}
		}
		
		// add a tile to an existing meld
		Meld addmeld = new Meld(tempmeld);
		// checking to see if the meld is valid
		if (addmeld.validMeld()) {
			// if valid then you need to add the sum of the meld to the new total
			sum += addmeld.getSum();
			// if valid, then it will be played. remove the cards from the hand
			for (int i = 0; i < tempmeld.size(); i++) {
				// removing cards from hand
				temphand.remove(tempmeld.get(i));
			}
			// game.getTable().addMeld(addmeld);
			if (temphand.getSize() > 0)
				// makeRun(newgame,temphand);
				temphand.getRunSum(temphand, temphand.get(0), total + sum);

			if (temphand.getSize() <= 0) {
				int x = 0;
				x = total + sum;
				total = 0;
				return x;

			}

		}


		// when the meld is not valid and index is less than hand size
		if (!addmeld.validMeld() && indexof < temphand.getSize() - 1) {

			temphand.getRunSum(temphand, temphand.get(indexof + 1), total);
		}

		// when the index is at the last and meld is invalid
		if (indexof + 1 >= temphand.getSize() && !addmeld.validMeld()) {

			int x = 0;
			x = total + sum;
			total = 0;
			return x;
		}

		return 0;

	}
	public void AddAllPossible(ArrayList<Meld> melds) {
		for(Meld m:melds) {
			addToExisting(m); 
		}
		
		
	}
	public void addToExisting(Meld m){
		Meld currMeld = m; 
		
		
		// setting the indexes to default
		int[] indexes = {-1,-1};
		// going through each tile in each meld
		for(Tile t:Hand) {
			// checking to see if a set can be added to
			if(currMeld.getSize() == 3) {
				// checking if meld is a set
				if(currMeld.getTile(0).getValue() == t.getValue()&& 
				   currMeld.getTile(1).getValue() == t.getValue() && 
				   currMeld.getTile(0).getColour() != t.getColour() &&
				   currMeld.getTile(1).getColour() != t.getColour() &&
				   currMeld.getTile(2).getColour() != t.getColour()) {
					
					// this means it is a valid set to add to, add to the meld
					m.addTile(t);
					Hand.remove(t); 
					return; 
				}
				else if(!currMeld.NotRun()) {
					
					if(currMeld.CheckFront(t)) {
						indexes[0] = Hand.indexOf(t);
						
					}
					if(currMeld.CheckBack(t)) {
						indexes[1] = Hand.indexOf(t);
						
					}
					
					
					
				}
			
				// here remove the indexes and add to the meld
				if(indexes[0] != -1) {
					m.addFirst(Hand.get(indexes[0]));
					Hand.remove(indexes[0]);
					
				}
				if(indexes[1] != -1) {
					m.addFirst(Hand.get(indexes[1]));
					Hand.remove(indexes[1]);
					
				}
		
			
		
		}
		
	}	

}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < Hand.size(); i++) {
			result += Hand.get(i).toString() + " ";
		}
		return result;
	}
}
