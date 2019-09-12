package a1;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ChessBoardTest
{
    private ChessBoard board;
    public void createBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testChessBoardInitialization() {
        createBoard();
        board.initialize();
        try {
            int blackPieces = 0;
            int whitePieces = 0;
            for( int i = 0;i < 8; i++ )
            {
                for( int j = 0; j < 8; j++)
                {
                    String position = Character.toString((char)(j + 97)) + Integer.toString(i + 1);
                    ChessPiece piece = board.getPiece(position);
                    if (piece != null)
                    {
                        if (piece.getColor() == ChessPiece.Color.WHITE) {
                            whitePieces = whitePieces+1;
                        } else {
                            blackPieces = blackPieces+1;
                        }
                    }
                }
            }
            assertTrue(whitePieces == 16);
            assertTrue(blackPieces == 16);

            assertTrue(board.getPiece("g2").toString().equals("\u2659"));
            assertTrue(board.getPiece("h2").toString().equals("\u2659"));
            assertTrue(board.getPiece("a7").toString().equals("\u265F"));
            assertTrue(board.getPiece("b7").toString().equals("\u265F"));
            assertTrue(board.getPiece("c7").toString().equals("\u265F"));
            assertTrue(board.getPiece("d7").toString().equals("\u265F"));
            assertTrue(board.getPiece("e7").toString().equals("\u265F"));
            assertTrue(board.getPiece("a1").toString().equals("\u2656"));
            assertTrue(board.getPiece("b1").toString().equals("\u2658"));
            assertTrue(board.getPiece("c1").toString().equals("\u2657"));
            assertTrue(board.getPiece("e1").toString().equals("\u2654"));
            assertTrue(board.getPiece("d1").toString().equals("\u2655"));
            assertTrue(board.getPiece("f7").toString().equals("\u265F"));
            assertTrue(board.getPiece("g7").toString().equals("\u265F"));
            assertTrue(board.getPiece("h7").toString().equals("\u265F"));
            assertTrue(board.getPiece("a8").toString().equals("\u265C"));
            assertTrue(board.getPiece("b8").toString().equals("\u265E"));
            assertTrue(board.getPiece("c8").toString().equals("\u265D"));
            assertTrue(board.getPiece("d8").toString().equals("\u265B"));
            assertTrue(board.getPiece("e8").toString().equals("\u265A"));
            assertTrue(board.getPiece("f8").toString().equals("\u265D"));
            assertTrue(board.getPiece("g8").toString().equals("\u265E"));
            assertTrue(board.getPiece("h8").toString().equals("\u265C"));
            assertTrue(board.getPiece("f1").toString().equals("\u2657"));
            assertTrue(board.getPiece("g1").toString().equals("\u2658"));
            assertTrue(board.getPiece("h1").toString().equals("\u2656"));
            assertTrue(board.getPiece("a2").toString().equals("\u2659"));
            assertTrue(board.getPiece("b2").toString().equals("\u2659"));
            assertTrue(board.getPiece("c2").toString().equals("\u2659"));
            assertTrue(board.getPiece("d2").toString().equals("\u2659"));
            assertTrue(board.getPiece("e2").toString().equals("\u2659"));
            assertTrue(board.getPiece("f2").toString().equals("\u2659"));

        } catch (IllegalPositionException e) { }
    }


    @Test
    public void testPlacePieceType1() {
        createBoard();
        ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
        ChessPiece pawn1 = new Pawn(board, ChessPiece.Color.WHITE);
        assertTrue(board.placePiece(pawn, "a2"));
        assertFalse(board.placePiece(pawn1, "a2"));
    }

    @Test
    public void testPlacePieceType2() {
        createBoard();
        ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
        ChessPiece pawn1 = new Pawn(board, ChessPiece.Color.BLACK);
        assertTrue(board.placePiece(pawn, "a2"));
        assertTrue(board.placePiece(pawn1, "a2"));
    }

    @Test
    public void testPlacePieceType3()
    {
        createBoard();
        ChessPiece pawn = new Pawn(board, ChessPiece.Color.WHITE);
        board.placePiece(pawn, "b2");
        assertTrue(pawn.getPosition().equals("b2"));
        try {
            assertTrue(board.getPiece("b2").equals(pawn));
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testgetPiece() {
        createBoard();
        board.initialize();
        try {
            assertTrue(board.getPiece("h2").toString().equals("\u2659"));
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testgetPieceNull() {
        createBoard();
        board.initialize();
        try {
            assertTrue(board.getPiece("e3") == null );
        } catch (IllegalPositionException e) {

        }
    }

    @Test
    public void testInvalidMoves() {
        createBoard();
        board.initialize();
        boolean sucess = false;
        try {
            board.move("a2", "a5");
            sucess = true;
        } catch (IllegalMoveException e) { }
        assertFalse(sucess);
    }

    @Test
    public void testIllegalPositionException() {
        createBoard();
        board.initialize();
        boolean failed = false;
        try {
            board.getPiece("j8").toString();
        } catch (IllegalPositionException e) { failed = true;}
        assertTrue(failed);
    }

    @Test
    public void testValidMove() {
        createBoard();
        board.initialize();
        boolean success = false;
        try {
            board.move("a2", "a3");
            board.move("b2", "b4");
            success = true;
        } catch (IllegalMoveException e) { }
        assertTrue(success);
    }



}
