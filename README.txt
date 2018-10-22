Tile Rummy Game
Authors: Noah Beeney, Julian Lankstead, Dare Adebanjo
--------------------------------------------------------------------------------
For every class, keep a record of:
- the class name
- data members
- methods (names, what they do)
- any output (give example)
- special behaviour
- bugs
- any notes (important things to note when using the class)
--------------------------------------------------------------------------------
Table.java:
- Has 4 players, a deck, and an ArrayList of Melds.
- Default initializer creates four new Players with names and a new Deck.
Methods:
- init shuffles the Deck and deals each Player 14 Tiles.
- numMelds returns the number of melds on the table.
- addMeld adds the specified Meld to the Table.
- drawTile deals the top tile on the Deck to the specified Player.
- playerx where 1<x<4 returns Player number x.
- remMeld removes a Meld from the table. Melds can be removed by reference (compares the Tiles in each Meld) or by index (removes Meld at index i)
--------------------------------------------------------------------------------
