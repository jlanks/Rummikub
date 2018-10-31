package core;

public class Game {
	private Table table;
	private boolean isOver;
	private Player currPlayer; 
	private Player nextPlayer; 
	

	public Game() {

		table = new Table();
		currPlayer = table.player1(); 

	}

	public Table getTable() {

		return table;
	}
	
	public Player getNextPlayer() {
		
		if(currPlayer.getName() == "player1") {
			return table.player2(); 
		
		}
		if(currPlayer.getName() == "player2"){
			return table.player3(); 
		}
		return table.player1(); 
	}

}
