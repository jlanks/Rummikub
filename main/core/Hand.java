package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Hand {
	
	// class which represents a players hand 
	
	// function requirements 
	/*
	  
	 - linkedlist represents the hand
	 - constructor which has a deck argument
	 - copy constructor which takes a hand argument
	 - sort method -> collections.sort
	 - detectruns function 
	 	- 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 */
	
	// hand
	
	LinkedList<Tile> Hand;  
	
	// deck
	
	Deck deck; 
	
	// Constructor
	public Hand(Deck d){
		this.deck = d; 
		Hand = new LinkedList<Tile>();
		for (int i=0; i<14;i++){
			Hand.add(deck.getTopTile());
		}
		
		
	}
	public Hand(){
		
		Hand = new LinkedList<Tile>();
		
		}
	
		
		
	
	
	// Copy Constructor
	public Hand(Hand h){
		this.deck = h.deck;
		Hand = new LinkedList<Tile>();
		for(int i =0;i<h.getSize();i++) {
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
	
	public void makeRun(Game game,Tile t) {
		
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
		for(int i =0;i<this.getSize();i++) {
			// adding all the valid tiles to the temporary meld
			if(this.getTile(i).getColour() == curr.getColour() &&
					this.getTile(i).getValue() == curr.getValue() + 1) {
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
		
		for(int i =0; i<Hand.size();i++) {
			
			if(i == Hand.size() && Hand.get(i) != t) {
				
				indexof = -1; 
			}
			if(Hand.get(i).equals(t)) {
				indexof = i; 
			}
		}
		// meld to be added to the table
		Meld addmeld = new Meld(tempmeld);
		// checking to see if the meld is valid
		if(addmeld.validMeld()) {
			// if valid, then it will be played. remove the cards from the hand 
			for(int i=0;i<tempmeld.size();i++) {
				 // removing cards from hand
				this.remove(tempmeld.get(i)); 
			}
			game.getTable().addMeld(addmeld);
			if(Hand.size() > 0) 
				makeRun(game,Hand.get(0)); 
			
			if(Hand.size() <= 0)
				return;
			
			
		}
		// when the meld is not valid and index is less than hand size
		if(!addmeld.validMeld() && indexof < Hand.size()-1) {
			
			
			makeSet(game,Hand.get(indexof+1));
		}
		
		// when the index is at the last and meld is invalid
		if(indexof+1 >= Hand.size() && !addmeld.validMeld()) {
			
			return; 
		}
		
		
		
		
		
	}
	public void remove(Tile tile) {
		// TODO Auto-generated method stub
		for(int i =0; i<this.getSize();i++) {
			if(this.getTile(i).equals(tile))
				Hand.remove(i); 
		}
		
	}
	public void remove(int tile) {
		// TODO Auto-generated method stub
		
				Hand.remove(tile); 
		
		
	}
	
	public void add(Tile t) {
		Hand.add(t); 
		
	}
	// function which tries and make a run in with the players tiles.
	// when calling initially, tile should be the first tile of the players hand
	// game is the current game
	
		public void makeSet(Game game,Tile t) {
			
			// the list of colours already used
			ArrayList<Colour> col = new ArrayList<Colour>(); 
			
			// the temporary meld going to be used 
			ArrayList<Tile> tempmeld = new ArrayList<Tile>(); 
			
			
			
			
			
			// the tile which will be the comparison basis 
			Tile compare = t; 
			
			// the current games table
			Table table = game.getTable();
			
			//adding the tile argument to the meld array
			tempmeld.add(t); 
			
			// adding tiles with all the same value
			
			// loops through all the tiles in the players hand
			for(int i = 0; i<this.getSize(); i++) {
				
				// if the value is the same, but the colour is not,
				// and the colour has not already been added
				// then add to the temp meld
				
				if(Hand.get(i).getValue() == compare.getValue() && 
				   Hand.get(i).getColour() != compare.getColour() &&
				   !Hand.get(i).equals(t) &&
				   !(col.contains(Hand.get(i).getColour()))) {
					
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
			
			for(int i =0; i<Hand.size();i++) {
				
				if(i == Hand.size() && Hand.get(i) != t) {
					
					index = -1; 
				}
				if(Hand.get(i).equals(t)) {
					index = i; 
				}
			}
			
			// making sure the meld is valid
			if(addmeld.validMeld()) {
			
				// if the meld is valid then the cards from the players hand need to be removed
				for(int i=0;i<tempmeld.size();i++) {
						 // removing cards from hand
						Hand.remove(tempmeld.get(i)); 
					}
				
				// if the meld is valid, it will be added to the table
				table.addMeld(addmeld);
				
				if(Hand.size() > 0) 
					makeSet(game,Hand.get(0)); 
				
				if(Hand.size() <= 0)
					return;
			
				
			}
			
			// when the meld is not valid and index is less than hand size
			if(!addmeld.validMeld() && index < Hand.size()-1) {
				
				
				makeSet(game,Hand.get(index+1));
			}
			
			// when the index is at the last and meld is invalid
			if(index+1 >= Hand.size() && !addmeld.validMeld()) {
				
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
		// call this with the current players hand the current tile of search and the total
		public int getRunSum(Hand hand, Tile t, int total) {
			
			int sum = 0; 
			// the temporary meld going to be used 
			ArrayList<Tile> tempmeld = new ArrayList<Tile>(); 
			// the current tile
			Tile curr = t;
			 // making a new hand separate to the players so the players hand is not messed up
			Hand temphand = new Hand(this); 
			
			// indexes of used tiles
			ArrayList index = new ArrayList(); 
			// sorting hand in ascending order 
			this.sortHand(); 
			// adding the current tile to the temporary meld
			tempmeld.add(curr); 
			// adding valid tiles 
			for(int i =0;i<this.getSize();i++) {
				// adding all the valid tiles to the temporary meld
				if(this.getTile(i).getColour() == curr.getColour() &&
						this.getTile(i).getValue() == curr.getValue() + 1) {
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
			
			for(int i =0; i<Hand.size();i++) {
				
				if(i == Hand.size() && Hand.get(i) != t) {
					
					indexof = -1; 
				}
				if(Hand.get(i).equals(t)) {
					indexof = i; 
				}
			}
			// meld to be added to the table
			Meld addmeld = new Meld(tempmeld);
			// checking to see if the meld is valid
			if(addmeld.validMeld()) {
				// if valid then you need to add the sum of the meld to the new total
				sum += addmeld.getSum(); 
				// if valid, then it will be played. remove the cards from the hand 
				for(int i=0;i<tempmeld.size();i++) {
					 // removing cards from hand
					temphand.remove(tempmeld.get(i)); 
				}
				//game.getTable().addMeld(addmeld);
				if(temphand.getSize() > 0) 
				//	makeRun(newgame,temphand); 
					temphand.getRunSum(temphand , temphand.get(0), total+sum); 
				
				if(temphand.getSize() <= 0)
					return total+sum;
				
				
			}
			// when the meld is not valid and index is less than hand size
			if(!addmeld.validMeld() && indexof < temphand.getSize()-1) {
				
				
				temphand.getRunSum(temphand,temphand.get(indexof+1),total);
			}
			
			// when the index is at the last and meld is invalid
			if(indexof+1 >= Hand.size() && !addmeld.validMeld()) {
				
				return total; 
			}
			
			return 0;
			
		
		}
}
