package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StrategyHuman implements Play {
	Scanner scanner = new Scanner(System.in);

	public String Name() {
		return "SHuman";
	}

	public int play(Game game) {
		
		return 0;
	}

	// NOTE can only play meld of size up to 5
	public Meld buildMeld(Player me) {
		Meld meld;
		System.out.print("Enter # of tiles in meld: ");
		int size = scanner.nextInt();
		System.out.println("Enter tiles in order, in format \"R1\" for a red-one tile.");

		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for (int i = 0; i < size; i++) {
			System.out.print("Enter tile " + (i + 1) + ": ");
			Tile myTile = new Tile(scanner.next());
			if (!me.RemoveTile(myTile)) { // Player doesn't have that tile or entered an invalid tile
				System.out.println("Invalid tile! Make sure you have that tile in your hand!");
				i--;
				continue;
			}
			tiles.add(myTile);
		}

		meld = new Meld(tiles);
		return meld;
	}

}
