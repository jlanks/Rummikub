package core;

import java.util.ArrayList;

public class Meld {
	ArrayList<Tile> meld = new ArrayList<Tile>();

	// *********** TILES NEED TO BE ADDED IN ORDER ************
	
	// Constructor for 3 tiles
	Meld(Tile a, Tile b, Tile c, boolean first) {

		// checking to see if the total for the first meld is 30 or higher
		
		if (first && a.getValue() + b.getValue() + c.getValue() < 30) {

			// printing error to console if error
			System.out.println("TRING TO MAKE MELD TOTALED LESS THAN 30");
			// returning due to invalid input
			return;
		}

		else {

			// checking to see if the colours are the same and numbers are valid
			// run identifier
			if (	a.getColour() == b.getColour() && a.getColour() == c.getColour() 
					&& b.getColour() == c.getColour()
					&& a.getValue() == b.getValue() - 1 && 
					b.getValue() == c.getValue() - 1) {
				
				// adding tiles to meld
				meld.add(a);
				meld.add(b);
				meld.add(c);

				}

			// checking for a group of same number different colour
			// set identifier
			else if (a.getColour() != b.getColour() && a.getColour() != c.getColour() && b.getColour() != c.getColour()
					&& a.getValue() == b.getValue() && b.getValue() == c.getValue() && a.getValue() == c.getValue()) {
				// adding tiles to meld
				meld.add(a);
				meld.add(b);
				meld.add(c);

			}

		}
	}
	
	// *********** TILES NEED TO BE ADDED IN ORDER ************ 
		  // meld constructor for 4 tiles 
		
		Meld(Tile a, Tile b, Tile c, Tile d, boolean first) {
			
			// checking to see if the total for the first meld is 30 or higher
			if(first && a.getValue() + b.getValue() + c.getValue() + d.getValue() < 30) {
		  
				// printing error to console
				System.out.println("FAILED: TRYING TO MAKE MELD TOTALED LESS THAN 30");
		  
				return;
		   
			
			}else {
		  
				// checking to see if the colours are the same and numbers are valid 
				// checking if player is trying to make a run 
				if( 	a.getColour() == b.getColour() && a.getColour() == c.getColour() &&
						b.getColour() == c.getColour() && d.getColour() == a.getColour() &&
						d.getColour() == b.getColour() && d.getColour() == c.getColour() &&
						a.getValue() == b.getValue() - 1 && b.getValue() == c.getValue() - 1 &&
						c.getValue() == d.getValue() -1 ) { 
					
					// adding tiles to meld. meld should be a run
					
					meld.add(a);
					meld.add(b);
					meld.add(c);
					meld.add(d);
		  
				}
		  
				// checking for a group of same number different colour 
				// checking if player is trying to make a set
				else if(a.getColour()!= b.getColour() && a.getColour() != c.getColour() && b.getColour() !=
						c.getColour() && d.getColour() != a.getColour() && d.getColour() !=
						c.getColour() && a.getValue() == b.getValue() && b.getValue() == c.getValue()
						&& a.getValue() == c.getValue() && d.getValue() == a.getValue()&&
						d.getValue() == b.getValue() && d.getValue() == c.getValue()) { 
						
						// adding tiles to meld
						// should be a set of 4 cards different colour same number
				  		meld.add(a);
				  		meld.add(b); 
				  		meld.add(c); 
				  		meld.add(d);
		  
				}
		  
			} 
		}

		// *********** TILES NEED TO BE ADDED IN ORDER ************ 
		  // meld constructor for 4 tiles 
		  // player can only make a run here
		Meld(Tile a, Tile b, Tile c, Tile d, Tile e, boolean first) {
			
			// checking to see if the total for the first meld is 30 or higher
			if( first && a.getValue() + b.getValue() 
				+ c.getValue() + d.getValue() + e.getValue() < 30) {
		  
				// printing error to console
				System.out.println("FAILED: TRYING TO MAKE MELD TOTALED LESS THAN 30");
		  
				return;
		   
			
			}else {
		  
				// checking to see if the colours are the same and numbers are valid 
				// checking if player is trying to make a run 
				if( 	a.getColour() == b.getColour() && a.getColour() == c.getColour() &&
						b.getColour() == c.getColour() && d.getColour() == a.getColour() &&
						d.getColour() == b.getColour() && d.getColour() == c.getColour() &&
						e.getColour() == a.getColour() && e.getColour() == b.getColour() &&
						e.getColour() == c.getColour() && e.getColour() == d.getColour() &&
						a.getValue() == b.getValue() - 1 && b.getValue() == c.getValue() - 1 &&
						c.getValue() == d.getValue() -1 && d.getValue() == e.getValue() - 1) { 
					
					// adding tiles to meld. meld should be a run
					
					meld.add(a);
					meld.add(b);
					meld.add(c);
					meld.add(d);
					meld.add(e);
		  
				}
		  
			} 
		}
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < meld.size(); i++) {
			sum += meld.get(i).getValue();
		}
		return sum;
	}
	public Tile getTile(int i) {
		
		return meld.get(i);  
	}
	public void addTile(Tile tile) {
		
		// checking to see if the add will be valid: checking for a run 
		if(tile.getValue()-1 == this.getTile(meld.size()-1).getValue() 
		   &&
		   tile.getColour() == this.getTile(0).getColour()) 
			{
				meld.add(tile);
			}
		// checking to see if the add will be valid: checking for a set
		if(meld.size() == 3) {
			if(tile.getValue() == this.getTile(0).getValue() 
			   &&
			   tile.getColour() != this.getTile(0).getColour()
			   &&
			   tile.getColour() != this.getTile(1).getColour()
			   &&
			   tile.getColour() != this.getTile(2).getColour()) 
					
				{
					meld.add(tile);
				}
		}
	}
	public boolean removeTile(Tile tile) {
		
		for(int i = 0;i<meld.size();i++) {
			if(tile.getColour() == meld.get(i).getColour() 
			   &&
			   tile.getValue() == meld.get(i).getValue()) 
			{
			meld.remove(i); 
			return true; 
			}
		}
		return false; 
	}
	public void removeIndex(int index) {
			
			meld.remove(index); 
		
	}
	public int getSize() {
		
		return meld.size(); 
	}
	
	public boolean validMeld() {
		
		// melds need to be 3 or more tiles
		if(this.getSize() < 3) {
			return false;
		}
		
		int total = 0; 
		
		// testing runs
		for(int i=0;i<this.getSize()-1;i++) {
			
			if(meld.get(i).getColour() == meld.get(i+1).getColour()
				&&
			   meld.get(i).getValue() == meld.get(i+1).getValue()-1
				) 
			{
				total++; 
			}
		}
		if(total == meld.size()-1) {
			return true; 
		}
		
		// colour tallys 
		int Red = 0;
		int Green = 0;
		int Blue = 0;
		int Orange =0; 
		
		
		
		for(int i=0;i<this.getSize();i++) {
			
			if(this.getTile(i).getColour() == Colour.Red)
				Red ++;
			if(this.getTile(i).getColour()== Colour.Green)
				Green ++;
			if(this.getTile(i).getColour() == Colour.Blue)
				Blue ++;
			if(this.getTile(i).getColour() == Colour.Orange)
				Orange ++;
		}
		if(this.getSum()/this.getSize() == this.getTile(0).getValue()
		   &&
		   Red < 2 && Green <2 && Blue <2 && Orange < 2) 
		{
			return true;
			
		}
		
		
		return false; 
		
	}
	/*
	public ArrayList<Tile> SortTiles(ArrayList<Tile> meld) {
		
		
		
		return meld; 
		
	}
	
	  */
}
