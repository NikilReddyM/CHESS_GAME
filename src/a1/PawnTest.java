package a1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PawnTest {
    private ChessBoard board;
    public void createNewBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testOnPawnName()
    {
        createNewBoard();
        board.initialize();
        try {
            assertEquals(board.getPiece("a2").toString(), "\u2659");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("a7").toString(), "\u265F");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
            board.placePiece(pawn, "a2");
            assertTrue(board.getPiece("a2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.BLACK);
            board.placePiece(pawn, "a7");
            assertTrue(board.getPiece("a7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
            board.placePiece(pawn, "h2");
            assertTrue(board.getPiece("h2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.BLACK);
            board.placePiece(pawn, "h7");
            assertTrue(board.getPiece("h7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
            board.placePiece(pawn, "e2");
            assertTrue(board.getPiece("e2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.BLACK);
            board.placePiece(pawn, "e7");
            assertTrue(board.getPiece("e7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
            board.placePiece(pawn, "a3");
            assertTrue(board.getPiece("a3").legalMoves().size() == 1);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece pawn = new Pawn(board, ChessPiece.Color.BLACK);
            board.placePiece(pawn, "d4");
            assertTrue(board.getPiece("d4").legalMoves().size() == 1);
        } catch (IllegalPositionException e) { }

    }

    @Test
    public void testOnInitializedBoard()
    {
        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("a2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("a7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("h2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("h7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("e2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("e7").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }


        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("a2").legalMoves().size() == 2);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            board.move("a7","a5");
            board.move("a5","a4");
            assertTrue(board.getPiece("a2").legalMoves().size() == 2);
            board.move("a4","a3");
            assertTrue(board.getPiece("a2").legalMoves().size() == 1);
        }
        catch (IllegalPositionException e) { }
        catch (IllegalMoveException e){}

        try {
            createNewBoard();
            board.initialize();
            board.move("a7","a5");
            board.move("a5","a4");
            assertTrue(board.getPiece("a2").legalMoves().size() == 2);
            board.move("a2","a3");
            assertTrue(board.getPiece("a3").legalMoves().size() == 1);
        }
        catch (IllegalPositionException e) { }
        catch (IllegalMoveException e){}

    }


}
