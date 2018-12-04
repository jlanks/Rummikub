package core;

import java.util.ArrayList;

//TODO updating the player's hand and melds on table in game

public class Controller {
	Game game;
	
	Controller(Game g){
		game = g;
	}
	
	public Player getCurrPlayer(){
		return game.getPlayer();
	}
	public ArrayList<String> getCurrHand(){
		return game.getCurrSHand();
	}
	
	public String gameString() {
		String gameStr = "";
		
		/*
		 * TODO:
		 * Return a nice string representation of the game (table). This includes:
		 * 	- who's turn is is
		 * 	- all players' hands
		 * 	- all players' points
		 * 	- # of tiles of each player (optional but easy and probably a good idea)
		 *  - explicitly show the current player's hand: "Current player's hand: [ their hand here ]"
		 *  
		 *  Don't worry about the melds on the table, this is already in our GUI implementation. 
		 *  Make the output BEAUTIFUL! This is how our users will see the game.
		 *  Proper line spacing and indentation is key.
		 *  
		 */
		
		
		return gameStr;
	}
}
