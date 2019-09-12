package a1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BishopTest {
    private ChessBoard board;
    public void createNewBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testOnRookName()
    {
        createNewBoard();
        board.initialize();
        try {
            assertEquals(board.getPiece("c1").toString(), "\u2657");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("f1").toString(), "\u2657");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("c8").toString(), "\u265D");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("f8").toString(), "\u265D");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "c1");
            assertTrue(board.getPiece("c1").legalMoves().size() == 7);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "f1");
            assertTrue(board.getPiece("f1").legalMoves().size() == 7);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "f8");
            assertTrue(board.getPiece("f8").legalMoves().size() == 7);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "c8");
            assertTrue(board.getPiece("c8").legalMoves().size() == 7);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "b4");
            assertTrue(board.getPiece("b4").legalMoves().size() == 9);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "e4");
            assertTrue(board.getPiece("e4").legalMoves().size() == 13);
        } catch (IllegalPositionException e) { }



    }

    @Test
    public void testOnInitializedBoard()
    {
        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("c1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("f1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("f8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("c8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "b4");
            assertTrue(board.getPiece("b4").legalMoves().size() == 6);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            ChessPiece bishop = new Bishop(board, ChessPiece.Color.WHITE);
            board.placePiece(bishop, "e4");
            assertTrue(board.getPiece("e4").legalMoves().size() == 8);
        } catch (IllegalPositionException e) { }
    }
}
