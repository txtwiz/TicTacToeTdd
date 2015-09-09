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
    	assertEquals(true, ticTacToe.checkSpace(1, 1));
    	assertEquals(true, ticTacToe.checkSpace(1, 2));
    	assertEquals(true, ticTacToe.checkSpace(1, 3));
    	assertEquals(true, ticTacToe.checkSpace(2, 1));
    	assertEquals(true, ticTacToe.checkSpace(2, 2));
    	assertEquals(true, ticTacToe.checkSpace(2, 3));
    	assertEquals(true, ticTacToe.checkSpace(3, 1));
    	assertEquals(true, ticTacToe.checkSpace(3, 2));
    	assertEquals(true, ticTacToe.checkSpace(3, 3));
    	ticTacToe.bot();
    }
    

    @Test
    public void xFirstVLineWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(3, 3); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("PLAYER X WON!", actual);
    }

    @Test
    public void oFirstHLineWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 3); // X
        String actual = ticTacToe.play(2, 3); // 0
        assertEquals("PLAYER O WON!", actual);
        //ticTacToe.printBoard(actual);
    }

    @Test
    public void xDiagonalWinner() {
        ticTacToe.play(3, 3); // X
        ticTacToe.play(3, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(2, 1); // O
        String actual = ticTacToe.play(1, 1); // X
        assertEquals("PLAYER X WON!", actual);
        //ticTacToe.printBoard(actual);
    }
    

    @Test
    public void drawGame() {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(1, 3); //X
        ticTacToe.play(2, 1); //O
        ticTacToe.play(2, 3); //X
        ticTacToe.play(2, 2); //O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(3, 3); //O
        String actual = ticTacToe.play(3, 2);
        assertEquals("GAME ENDS WITH A DRAW!", actual);
        //ticTacToe.printBoard(actual);
    }

}