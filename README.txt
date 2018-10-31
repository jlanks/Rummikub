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
Colour.java
- enum of the colour options for a tile
- Red, Green, Blue, Orange
--------------------------------------------------------------------------------
Tile.java
- Tiles have a number and a value
Methods:
- Constructor which assigns a tiles colour and value
- getColour returns the tile colour (Colour)
- getValue returns the tile value (int)
- equals compares a tile based on their colour and value (boolean)
- toString formats the printing of a tile. Prints out value and colour (String)
--------------------------------------------------------------------------------
Deck.java
- LL of tiles 
Methods:
- Constructor which initializes a deck (2(tiles 1-14))
  - Takes a boolean argument which if true, the deck gets shuffled
- Shuffle shuffles the deck (void)
- getCard returns the tile at the specified index (Tile)
- getDeckSize returns the size of the deck (int)
- getTopTile pops the first card in the deck (Tile)
- printDeck prints all the cards in the deck (void)
--------------------------------------------------------------------------------
Meld.java
- ArrayList of tiles
Methods:
- Constructors
  - Constructor which has an ArrayList of tiles as an argument
  - Constructor which has one - five tiles and a boolean as an argument
    - boolean represents if the meld is the first one of the turn
- getSum returns the sum of the meld (int)
- getTile returns the tile at the index specified (Tile)
- addTile adds a tile to the meld (void)
- removeTile removes a tile by referencing a tile (boolean)
- removeIndex removes a tile at the index specified (void)
- getSize returns the size of the meld (int)
- validMeld returns true if the meld is valid, false if not (boolean)
- combineMeld combines two existing melds (void)
- equals compares melds based on tiles which make the meld (boolean)
  - same colour and value in each index would be considered equal
- contains checks to see if a meld contains the tile argument (int)
  - returns the index if the meld contains the tile
  - returns -1 if the meld does not contain the tile 
--------------------------------------------------------------------------------
Player.java
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
Game.java
--------------------------------------------------------------------------------
Play.java
--------------------------------------------------------------------------------
StrategyOne.java
--------------------------------------------------------------------------------
StrategyTwo.java
