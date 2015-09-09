package main.tdd;
import java.util.Random;

public class TicTacToe {

	//creo la board
	private Character[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    //indico l'ultimo giocatore vuoto per far giocare X
    private char lastPlayer = ' ';
    private static final int SIZE = 3;
    public static final String NO_FINISH = " ";
    public static final String RESULT_DRAW = "GAME ENDS WITH A DRAW!";
    public static final String CHANGE_POSITION = "OCCUPIED!";

    public void bot(){
    	String message = NO_FINISH;

    	do{
    		Random randx = new Random();
        	Random randy = new Random();
        	
        	message = play(randx.nextInt(3) + 1, randy.nextInt(3) + 1, true);
        	
        	if (message != CHANGE_POSITION) {
	        	try {
	        	    Thread.sleep(2000);
	        	} catch(InterruptedException ex) {
	        	    Thread.currentThread().interrupt();
	        	}
        	} else {
        		message = NO_FINISH;
        	}
        	
    	}while(message == NO_FINISH);
    	
    }
    
    
    
    //stampo la situazione di gioco
    public void printBoard(String message){
    	
    	System.out.println("PLAYER " + lastPlayer + ":");
    	
    	System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
    	System.out.println("-" + "+" + "-" + "+" + "-");
    	System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
    	System.out.println("-" + "+" + "-" + "+" + "-");
    	System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    	
    	System.out.println(message +"\n");
    	
    }
    
    //check su uno spazio, deve essere sulla board e deve essere vuoto
    public Boolean checkCell(int x, int y){
    	
    	if (x < 1 || x > 3){
    		throw new RuntimeException("X coord is outside board");
    	}
    	
    	if (y < 1 || y > 3){
    		throw new RuntimeException("Y coord is outside board");
    	}
    	
    	if (!Character.isWhitespace(board[x - 1][y - 1])) {
    		return false;
    	} else {
    		return true;
    	}
    	
    }
    
    
    //fa la giocata nella casella scelta
    public String play(int x, int y, boolean print) {
    	String message = NO_FINISH;
        if (checkCell(x,y)) {
        
	        lastPlayer = nextPlayer();
	        setSymbol(x, y, lastPlayer);
	        
	        if (isWin(x, y)) {
	        	message =  "PLAYER " + lastPlayer + " WON!";
	        } else if (isDraw()) {
	            message = RESULT_DRAW;
	        } else {
	            message = NO_FINISH;
	        }
	        
        } else {
        	
        	if (isDraw()) {
        		message = RESULT_DRAW;
        	} else {
        		message = CHANGE_POSITION;
        	}
        	
        }
        
        if (print && message != CHANGE_POSITION){
        	printBoard(message);
        }
        
        return message;
    }

    //indica chi è il prossimo a giocare
    public char nextPlayer() {
    	
        if (lastPlayer == 'X') {
            return 'O';
        }
        
        return 'X';
    }

    //inserisce il simbolo nello spazio
    private void setSymbol(int x, int y, char lastPlayer) {

    	board[x - 1][y - 1] = lastPlayer;
        
    }

    //check se l'ultimo giocatore ha vinto
    private boolean isWin(int x, int y) {
    	
        int playerTotal = lastPlayer * SIZE;
        
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        
        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }
        
        return false;
        
    }

    //se tutta la board è piena allora è patta
    private boolean isDraw() {
    	
        for (int x = 0; x < SIZE; x++) {
        
        	for (int y = 0; y < SIZE; y++) {
                if (Character.isWhitespace(board[x][y])) {
                	
                    return false;
                    
                }
            }
        	
        }
        
        return true;
        
    }

}