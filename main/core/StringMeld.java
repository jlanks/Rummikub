package core;

//StringMeld class for creating Melds with Strings for testing purposes

public class StringMeld extends Meld {

	public StringMeld(String t1, String t2, String t3) {
		super(new Tile(t1), new Tile(t2), new Tile(t3), false);
	}

	public StringMeld(String t1, String t2, String t3, String t4) {
		super(new Tile(t1), new Tile(t2), new Tile(t3), new Tile(t4), false);
	}

	public StringMeld(String t1, String t2, String t3, String t4, String t5) {
		super(new Tile(t1), new Tile(t2), new Tile(t3), new Tile(t4), new Tile(t5), false);
	}
//	public StringMeld(String t1, String t2, String t3, String t4, String t5, String t6) {
//		super(new Tile(t1), new Tile(t2), new Tile(t3), new Tile(t4), new Tile(t5), new Tile(t6), false);
//	}
}
