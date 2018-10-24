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
	
	  
}
