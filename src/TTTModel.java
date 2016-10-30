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
		this.initBoard();

	}
	
	
	//Initialize the board
	public void initBoard(){
		for(int i=0;i<size;i++){
			for (int j=0;j<size;j++ ){
				Board[i][j]="*";
				//this.setChanged();
				//this.notifyObservers();
				
			}
		}
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
			if(Board[x][y].equals("*")){
				if(turn){
					player = "Player1";
					Board[x][y] = "X";
					checker();
				}
				else{
					player = "Player2";
					Board[x][y] = "O";
					checker();
				}
				this.playerTurn();

				this.setChanged();
				this.notifyObservers();
			}

		}
		
		System.out.println(Arrays.deepToString(Board));
		System.out.println(canPlay);


	}

	private void checker() {
		if(this.playerWon()){
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
		if(!Board[x][y].equals("*")){
			return Board[x][y];
		}
		return "";
	}
	
	
	//reset the board
	public void boardReset(){
		this.Board = new String[size][size];
		this.canPlay = true;
		turn = true;		//player turn is set to true;
		this.initBoard();
		
		this.setChanged();
		this.notifyObservers();
		
	}
	
	//Checks the board horizontally if someone has won
	public boolean wonHor(){
		int count1 =0; 
		int count2 =0;
		for(int i=0;i<size;i++){
			for (int j=0;j<size-1;j++ ){
				if((Board[i][j].equals(Board[i][j+1])) && !Board[i][j].equals("*")){
					if(Board[i][j].equals("X")){
						count1++;
					}else if(Board[i][j].equals("O")){
						count2++;
					}
					
				}
			}
			
		}

		if(count1 ==size-1||count2==size-1){
			
			return true;
		}
		
		
		return false;
	}
	//checks the vertical blocks if a user has won
	public boolean wonVet(){
		int count1=0;
		int count2=0;
		for(int i=0;i<size-1;i++){
			for (int j=0;j<size;j++ ){
				if((Board[i][j].equals(Board[i+1][j])) && !Board[i][j].equals("*")){
					if(Board[i][j].equals("X")){
						count1++;
					}else if(Board[i][j].equals("O")){
						count2++;
					}
				}
					
			}
			
		}
		
		if(count1 ==size-1 || count2==size-1){
			return true;
		}
			return false;
	
	}
	
	
	//check diagonal
	public boolean wonDiag(){
		int count1 =0; 
		int count2 =0;
		for(int i=0; i<size-1;i++){
			if ( Board[i][i].equals(Board[i+1][i+1]) &&  !Board[i].equals("*"))
				if(Board[i][i].equals("X")){
					count1++;
				}else if(Board[i][i].equals("O")){
					count2++;
				}
			
		}
	
		for(int i= 0, j=size-1; i< size-1 && j>=1 ; i++, j--){
			if( Board[i][j].equals(Board[i+1][j-1]) && !Board[i][j].equals("*"))
				if(Board[i][j].equals("X")){
					count1++;
				}else if(Board[i][j].equals("O")){
					count2++;
				}
		}

		if(count1 ==size-1 || count2==size-1)
			return true;
			
			return false;
	} 
	
	//check if a player has won based on a move
	public boolean playerWon(){
		if(wonVet() || wonDiag() || wonHor()){ 
			return true;
		} 
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
