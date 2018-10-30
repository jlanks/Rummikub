package core;

public class Tile {

	// Important Tile variables
	private Colour TColour;
	private int number;

	// Tile constructor
	public Tile(Colour colour, int TNumb) {

		// bounds checking
		if (TNumb > 13 || TNumb < 1) {
			System.err.println("Enter a valid card number");
			System.exit(1);
		}

		// number assignment
		number = TNumb;
		// Suit assignment
		TColour = colour;
	}

	// Tile constructor
	public Tile(String input) {

		// tile color
		String strCol = Character.toString(input.charAt(0)).toUpperCase();

		if (strCol.equals("R")) {
			TColour = Colour.Red;
		} else if (strCol.equals("G")) {
			TColour = Colour.Green;
		} else if (strCol.equals("B")) {
			TColour = Colour.Blue;
		} else if (strCol.equals("O")) {
			TColour = Colour.Orange;
		}

		// tile value
		number = Integer.parseInt(input.substring(1));
	}

	// basic getters
	public Colour getColour() {
		return this.TColour;
	}

	public int getValue() {
		return this.number;
	}

	public String toString() {
		String output = "";

		if (this.TColour == Colour.Red) {
			output += "R";
		} else if (this.TColour == Colour.Green) {
			output += "G";
		} else if (this.TColour == Colour.Blue) {
			output += "B";
		} else if (this.TColour == Colour.Orange) {
			output += "O";
		}

		output += Integer.toString(this.number);

		return output;
	}

	public boolean equals(Tile t) {
		if (this.TColour == t.TColour && this.number == t.number) {
			return true;
		} else {
			return false;
		}
	}
}
