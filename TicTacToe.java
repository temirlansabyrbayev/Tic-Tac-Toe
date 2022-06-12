public class TicToe
{
  public static final int X = 1, O = -1;      
  public static final int EMPTY = 0;          
  private int board[][] = new int[3][3];      
  private int player;                         

  public TicToe() { clearBoard(); }

  public void clearBoard() 
  {
	    for (int i = 0; i<3; i++) {
	    	for (int x = 0; x<3; x++) {
	    		board[i][x] = EMPTY;
	    		player = X;
	    	}
	    }
  }


  public void putMark(int i, int j) throws IllegalArgumentException {
	if (board[i][j] != EMPTY) {
		throw new IllegalArgumentException("a mark an occupied postition");
	}	
	if ((i<0)||(j>2)||(j<0)||(i>2)) {
		throw new IllegalArgumentException("a mark outside the board");
	}
	board[i][j] = player;    
    player = - player;
}
    

  public boolean isWin(int mark) 
  {
    return ((board[0][0] + board[0][1] + board[0][2] == mark*3)      
            || (board[1][0] + board[1][1] + board[1][2] == mark*3)   
            || (board[2][0] + board[2][1] + board[2][2] == mark*3)   
            || (board[0][0] + board[1][0] + board[2][0] == mark*3)   
            || (board[0][1] + board[1][1] + board[2][1] == mark*3)   
            || (board[0][2] + board[1][2] + board[2][2] == mark*3)   
            || (board[0][0] + board[1][1] + board[2][2] == mark*3)   
            || (board[2][0] + board[1][1] + board[0][2] == mark*3)); 
  }


  public int winner() 
  {
    if (isWin(X))
      return(X);
    else if (isWin(O))
      return(O);
    else
      return(0);
  }


  public String toString() {
     StringBuilder sb = new StringBuilder();
     for (int i = 0; i<3; i++) {
	    	for (int x = 0; x<3; x++) {
	    		switch (board[i][x]) {
	    		case O:
	    			sb.append("O");
	    			break;
	    		case X:
	    			sb.append("X");
	    			break;
	    		case EMPTY:
	    			sb.append(" ");
	    			break;
	    	}
	    	if (x<2) {
	    		sb.append("|");		
	    	}
	    }
	    if (i<2) {
	    	sb.append("\n-----\n");
	    }    
     }
     return sb.toString();
  }

  
  public static void main(String[] args) 
  {
    TicToe game = new TicToe();

    game.putMark(1,1);          game.putMark(0,2);
    game.putMark(2,2);          game.putMark(0,0);
    game.putMark(0,1);          game.putMark(2,1);
    game.putMark(1,2);          game.putMark(1,0);
    game.putMark(2,0);

    System.out.println(game);
    int winningPlayer = game.winner();
    String[] outcome = {"O wins", "Tie", "X wins"};  
    System.out.println(outcome[1 + winningPlayer]);
    
    game.clearBoard();
    
    game.putMark(0,2);          game.putMark(2,1);
    game.putMark(1,1);          game.putMark(2,2);
    game.putMark(2,0);          


    System.out.println(game);
    winningPlayer = game.winner(); 
    System.out.println(outcome[1 + winningPlayer]);
    
    game.clearBoard();
    
    game.putMark(0,0);          game.putMark(2,2);
    game.putMark(1,1);          game.putMark(1,2);
    game.putMark(2,0);          game.putMark(0,2);


    System.out.println(game);
    winningPlayer = game.winner();  
    System.out.println(outcome[1 + winningPlayer]);
  }
}
