import java.util.Arrays;
import java.util.Observable;

public class TTTModel extends Observable {
	private String Board[][];		//2D array to represent the board
	private int size;				//size of the board 

	private boolean turn = false;	//player turn is now set to false
	private String player = "";
	private boolean canPlay;
	private String winningPlayer = "";

	
	//Constructor where the size of the board is passed in as a parameter and board is set to that that size
	public TTTModel(int size){
		this.size = size;
		this.Board = new String[size][size];
		turn = true;		//player turn is set to true;
		canPlay = true;

	}
	
	//This inverts the plater turn to false
	public void playerTurn(){
		turn = !turn;
	}
	
	//this methods returns the size 
	public int getSize(){
		return this.size;
	}
	
	//a user can play if the value at that block is null 
	public void play(int x, int y){
		if(canPlay){
			if(Board[x][y] == null){
				if(turn){
					player = "Player1";
					Board[x][y] = "X";
					checker(x,y);
				}
				else{
					player = "Player2";
					Board[x][y] = "O";
					checker(x,y);
				}
			}
		}
		System.out.println(Arrays.deepToString(Board));
		System.out.println(canPlay);

		if(canPlay) { this.playerTurn(); }
		this.setChanged();
		this.notifyObservers();

	}

	private void checker(int x, int y) {
		if(this.playerWon(x,y)){
			canPlay = false;
			this.setChanged();
			this.notifyObservers();

			System.out.println("" + player + " has won the game");
			winningPlayer = player;
		}
	}
	
	//returns the winning player
	public String winningPlayer(){
		return this.winningPlayer;
	}
	
	//returns the text for each block
	public String getText(int x, int y){
		if(Board[x][y] != null){
			return Board[x][y];
		}
		return "";
	}
	
	
	//reset the board
	public void boardReset(){
		this.Board = new String[size][size];
		this.canPlay = true;
		turn = true;		//player turn is set to true;
		this.setChanged();
		this.notifyObservers();
		
	}
	
	//checks the horizontal blocks if a user has won
	/*
	public boolean wonHor(){
		for(int i = 0; i< size; i++){
			for(int j =0; j<size-1; j++){
				if((Board[i][j]!=(Board[i][j+1])) && Board[i][j] != null) return false;
				}
			}
		return true;
	}
	*/
	public boolean wonHor(int x){
		for(int i = 0; i<this.size-1; i++){
			if((Board[x][i]!=(Board[x][i+1])) && Board[x][i] != null) return false;

		}
		return true;
	}
	//checks the vertical blocks if a user has won
	public boolean wonVet(int y){
		for(int i = 0; i<this.size-1; i++){
			if((Board[i][y]!=(Board[i+1][y])) && Board[i][y] != null) return false;

		}
		return true;
	}
	
	//check diagonal
	public boolean wonDiag(){
		for(int i = 0; i< size-1; i++){
			if((Board[i][i]!=(Board[i+1][i+1]))) return false;	//Diagonal 
		}	
		for(int i = 0, j = size-1; i < size -1 && j >= 0; i++, j--){
			if((Board[i][j]!=(Board[i+1][j-1]))) return false;
		}
		return true;
	} 
	
	//check if a player has won based on a move
	public boolean playerWon(int x, int y){
		if(wonVet(y) || wonDiag() || wonHor(x)){ 
			return true;} 
		return false;
	}
	
	public static void main(String [] args){
		TTTModel m = new TTTModel(3);
		m.play(0, 0);
		m.play(0,1);
		m.play(1,0);
		m.play(1,1);
		m.play(2, 0);
		m.play(2, 1);

		System.out.println("Hey");
		
	}
	
}
