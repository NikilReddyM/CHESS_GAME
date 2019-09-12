package a1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RookTest {
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
            assertEquals(board.getPiece("a1").toString(), "\u2656");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("h1").toString(), "\u2656");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("a8").toString(), "\u265C");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("h8").toString(), "\u265C");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
            board.placePiece(rook, "a1");
            assertTrue(board.getPiece("a1").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
            board.placePiece(rook, "h1");
            assertTrue(board.getPiece("h1").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
            board.placePiece(rook, "a8");
            assertTrue(board.getPiece("a8").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

        try
        {
        createNewBoard();
        ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
        board.placePiece(rook, "h8");
        assertTrue(board.getPiece("h8").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
            board.placePiece(rook, "e1");
            assertTrue(board.getPiece("e1").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece rook = new Rook(board, ChessPiece.Color.WHITE);
            board.placePiece(rook, "e4");
            assertTrue(board.getPiece("e4").legalMoves().size() == 14);
        } catch (IllegalPositionException e) { }

    }

    @Test
    public void testOnInitializedBoard() {
        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("a1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) {
        }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("a8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) {
        }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("h1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) {
        }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("h8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) {
        }

    }

    @Test
    public  void testDuringGameProcess()
    {
        try{
            createNewBoard();
            board.initialize();

            board.move("a2","a4");
            assertTrue(board.getPiece("a1").legalMoves().size() == 2);

            board.move("a4","a5");
            assertTrue(board.getPiece("a1").legalMoves().size() == 3);

            board.move("a1","a3");
            assertTrue(board.getPiece("a3").legalMoves().size() == 10);

            board.move("a7","a5");
            assertTrue(board.getPiece("a3").legalMoves().size() == 11);

            board.move("a3","a5");
            assertTrue(board.getPiece("a5").legalMoves().size() == 14);

            board.move("a5","d5");
            assertTrue(board.getPiece("d5").legalMoves().size() == 11);

            board.move("d5","a5");
            board.move("a5","a7");
            assertTrue(board.getPiece("a7").legalMoves().size() == 8);
        }
        catch (IllegalPositionException e) { }
        catch (IllegalMoveException e) { }
    }




}
