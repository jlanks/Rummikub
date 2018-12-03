package core;

import java.util.ArrayList;

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
}
