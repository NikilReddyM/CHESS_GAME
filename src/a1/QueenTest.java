package a1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class QueenTest {
    private ChessBoard board;
    public void createNewBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testOnQueenName()
    {
        createNewBoard();
        board.initialize();
        try {
            assertEquals(board.getPiece("d1").toString(), "\u2655");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("d8").toString(), "\u265B");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece queen = new Queen(board, ChessPiece.Color.WHITE);
            board.placePiece(queen, "d1");
            assertTrue(board.getPiece("d1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece queen = new Queen(board, ChessPiece.Color.WHITE);
            board.placePiece(queen, "d8");
            assertTrue(board.getPiece("d8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

    }

    @Test
    public void testOnInitializedBoard()
    {
        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("d1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("d8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnAnyPosition()
    {
        try {
            createNewBoard();
            board.initialize();
            ChessPiece queen = new Queen(board, ChessPiece.Color.WHITE);
            board.placePiece(queen, "d4");
            assertTrue(board.getPiece("d4").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

    }
}
