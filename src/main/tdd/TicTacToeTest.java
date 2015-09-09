package main.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicTacToeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    
    @Test
    public void xFirstPlayerAllCellEmpty() {
    	
    	assertEquals('X', ticTacToe.nextPlayer());
    	
    	assertEquals(true, ticTacToe.checkCell(1, 1));
    	assertEquals(true, ticTacToe.checkCell(1, 2));
    	assertEquals(true, ticTacToe.checkCell(1, 3));
    	assertEquals(true, ticTacToe.checkCell(2, 1));
    	assertEquals(true, ticTacToe.checkCell(2, 2));
    	assertEquals(true, ticTacToe.checkCell(2, 3));
    	assertEquals(true, ticTacToe.checkCell(3, 1));
    	assertEquals(true, ticTacToe.checkCell(3, 2));
    	assertEquals(true, ticTacToe.checkCell(3, 3));
    	
    }
    
    
    @Test
    public void xFirstVLineWinner() {
    	
        ticTacToe.play(1, 1, false); // X
        ticTacToe.play(2, 2, false); // O
        ticTacToe.play(2, 1, false); // X
        ticTacToe.play(3, 3, false); // O
        String actual = ticTacToe.play(3, 1, false); // X
        
        assertEquals("PLAYER X WON!", actual);
        
    }

    
    @Test
    public void oFirstHLineWinner() {
    	
        ticTacToe.play(1, 1, false); // X
        ticTacToe.play(2, 2, false); // O
        ticTacToe.play(3, 1, false); // X
        ticTacToe.play(2, 1, false); // O
        ticTacToe.play(1, 3, false); // X
        String actual = ticTacToe.play(2, 3, false); // 0
        
        assertEquals("PLAYER O WON!", actual);
        
    }

    
    @Test
    public void xDiagonalWinner() {
    	
        ticTacToe.play(3, 3, false); // X
        ticTacToe.play(3, 1, false); // O
        ticTacToe.play(2, 2, false); // X
        ticTacToe.play(2, 1, false); // O
        String actual = ticTacToe.play(1, 1, false); // X
        
        assertEquals("PLAYER X WON!", actual);

    }
    

    @Test
    public void drawGame() {
    	
        ticTacToe.play(1, 1, false); //X
        ticTacToe.play(1, 2, false); //O
        ticTacToe.play(1, 3, false); //X
        ticTacToe.play(2, 1, false); //O
        ticTacToe.play(2, 3, false); //X
        ticTacToe.play(2, 2, false); //O
        ticTacToe.play(3, 1, false); //X
        ticTacToe.play(3, 3, false); //O
        String actual = ticTacToe.play(3, 2, false);
        
        assertEquals("GAME ENDS WITH A DRAW!", actual);
        
    }

    
    @Test
    public void testBotRandomGame() {
    	
    	ticTacToe.bot();
    	
    }
}