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

/*
	// Tile constructor
	public Tile(String input) {


		// bounds checking
		if (input.charAt(1) > 13 || input.charAt(1) < 1) {

			System.err.println("Enter a valid card number");
			System.exit(1);

		}

		// number assignment
		number = input.charAt(1);
		// Suit assignment
		TColour = input.charAt(0);
	}

*/
	// basic getters
	public Colour getColour() {

		return this.TColour;
	}

	public int getValue() {

		return this.number;
	}
}
