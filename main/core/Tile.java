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

	// basic getters
	public Colour getColour() {

		return this.TColour;
	}

	public int getValue() {

		return this.number;
	}
}
