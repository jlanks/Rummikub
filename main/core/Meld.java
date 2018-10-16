package core;
import java.util.ArrayList;

public class Meld {
	ArrayList<Tile> meld = new ArrayList<Tile>(); 
	
	// 	*********** TILES NEED TO BE ADDED IN ORDER ************
	Meld(Tile a, Tile b, Tile c, boolean first) {
		
		// checking to see if the total for the first meld is 30 or higher
		if(first && a.getValue() +b.getValue()+c.getValue() < 30) {
			
			// printing error to console
			System.out.println("TRING TO MAKE MELD TOTALED LESS THAN 30");
			
			return; 
		}
		
		else {
			
			// checking to see if the colours are the same and numbers are valid
			if(a.getColour() == b.getColour() && 
					a.getColour() == c.getColour() && 
					b.getColour() == c.getColour() &&
					a.getValue() == b.getValue() +1 && 
					b.getValue() == c.getValue() + 1) 
			{
				// adding tiles to meld
				meld.add(a);
				meld.add(b);
				meld.add(c);
				
			
			
			}
			
			// checking for a group of same number different colour
			else if(a.getColour() != b.getColour() && 
					a.getColour() != c.getColour() && 
					b.getColour() != c.getColour() &&
					a.getValue() == b.getValue() && 
					b.getValue() == c.getValue() &&
					a.getValue() == c.getValue())
			{
				// adding tiles to meld
				meld.add(a);
				meld.add(b);
				meld.add(c);
				
			}
			
			
			
		}
	}
	
	public int getSum() {
		int sum = 0;  
		for(int i = 0; i<meld.size();i++) {
			sum += meld.get(i).getValue(); 
			}
		return sum; 
	}
	/*
	// 	*********** TILES NEED TO BE ADDED IN ORDER ************
	// meld constructor for 4 tiles 
	private Meld(Tile a, Tile b, Tile c, Tile d, boolean first) {
		// checking to see if the total for the first meld is 30 or higher
				if(first && a.getValue() +b.getValue()+c.getValue() < 30) {
					
					// printing error to console
					System.out.println("TRING TO MAKE MELD TOTALED LESS THAN 30");
					
					return; 
				}
				
				else {
					
					// checking to see if the colours are the same and numbers are valid
					if(		a.getColour() == b.getColour() && 
							a.getColour() == c.getColour() && 
							b.getColour() == c.getColour() &&
							d.getColour() == a.getColour() &&
							d.getColour() == b.getColour() &&
							d.getColour() == c.getColour() &&
							a.getValue() == b.getValue() +1 && 
							b.getValue() == c.getValue() + 1 &&
							c.getValue() == d.getValue() +1 ) 
					{
						// adding tiles to meld
						meld.add(a);
						meld.add(b);
						meld.add(c);
						meld.add(d); 
						
					}
					
					// checking for a group of same number different colour
					else if(a.getColour() != b.getColour() && 
							a.getColour() != c.getColour() && 
							b.getColour() != c.getColour() &&
							d.getColour() != a.getColour() &&
							d.getColour() != c.getColour() &&
							a.getValue() == b.getValue() && 
							b.getValue() == c.getValue() &&
							a.getValue() == c.getValue() &&
							d.getValue() == a.getValue()&&
							d.getValue() == b.getValue() &&
							d.getValue() == c.getValue())
					{
						// adding tiles to meld
						meld.add(a);
						meld.add(b);
						meld.add(c);
						meld.add(d);
						
					}
					
					
					
				}
			}
			*/
}
