package a1;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class KingTest
{

    private ChessBoard board;
    public void createNewBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testOnKingName()
    {
        createNewBoard();
        board.initialize();
        try {
            assertEquals(board.getPiece("e1").toString(), "\u2654");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("e8").toString(), "\u265A");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "e1");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("d1");
            moves.add("f1");
            moves.add("d2");
            moves.add("e2");
            moves.add("f2");
            assertTrue(board.getPiece("e1").legalMoves().size() == 5);
            assertTrue(board.getPiece("e1").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "e8");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("d8");
            moves.add("f8");
            moves.add("d7");
            moves.add("e7");
            moves.add("f7");
            assertTrue(board.getPiece("e8").legalMoves().size() == 5);
            assertTrue(board.getPiece("e8").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "a1");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("b1");
            moves.add("a2");
            moves.add("b2");
            assertTrue(board.getPiece("a1").legalMoves().size() == 3);
            assertTrue(board.getPiece("a1").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "h1");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("g1");
            moves.add("g2");
            moves.add("h2");
            assertTrue(board.getPiece("h1").legalMoves().size() == 3);
            assertTrue(board.getPiece("h1").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "h8");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("g8");
            moves.add("g7");
            moves.add("h7");
            assertTrue(board.getPiece("h8").legalMoves().size() == 3);
            assertTrue(board.getPiece("h8").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "a8");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("b8");
            moves.add("b7");
            moves.add("a7");
            assertTrue(board.getPiece("a8").legalMoves().size() == 3);
            assertTrue(board.getPiece("a8").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

        try {
            createNewBoard();
            ChessPiece king = new King(board, ChessPiece.Color.WHITE);
            board.placePiece(king, "e4");
            ArrayList<String> moves = new ArrayList<String>();
            moves.add("d5");
            moves.add("e5");
            moves.add("f5");
            moves.add("d4");
            moves.add("f4");
            moves.add("d3");
            moves.add("e3");
            moves.add("f3");
            assertTrue(board.getPiece("e4").legalMoves().size() == 8);
            assertTrue(board.getPiece("e4").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}

    }

    @Test
    public void testOnInitializedBoard()
    {
        createNewBoard();
        board.initialize();
        try
        {
            assertTrue(board.getPiece("e1").legalMoves().size() == 0);
        }catch (IllegalPositionException e){}
        try
        {
            assertTrue(board.getPiece("e8").legalMoves().size() == 0);
        }catch (IllegalPositionException e){}
    }

    @Test
    public void testDuringGameProcess()
    {
        try {
            createNewBoard();
            ChessPiece whiteking = new King(board, ChessPiece.Color.WHITE);


            ChessPiece whiteking1 = new King(board, ChessPiece.Color.WHITE);
            ChessPiece whiteking2 = new King(board, ChessPiece.Color.WHITE);
            ChessPiece blackking1 = new King(board, ChessPiece.Color.BLACK);
            ChessPiece blackking2 = new King(board, ChessPiece.Color.BLACK);
            ChessPiece blackking3 = new King(board, ChessPiece.Color.BLACK);
            ChessPiece blackking4 = new King(board, ChessPiece.Color.BLACK);

            board.placePiece(whiteking, "e4");

            board.placePiece(blackking1, "d5");
            board.placePiece(blackking2, "e5");
            board.placePiece(blackking3, "f5");

            board.placePiece(whiteking1, "d4");
            board.placePiece(whiteking2, "e3");
            board.placePiece(blackking4, "f3");

            ArrayList<String> moves = new ArrayList<String>();
            moves.add("d5");
            moves.add("e5");
            moves.add("f5");
            moves.add("d3");
            moves.add("f4");
            moves.add("f3");


            assertTrue(board.getPiece("e4").legalMoves().size() == 6);
            assertTrue(board.getPiece("e4").legalMoves().containsAll(moves));
        }catch (IllegalPositionException e){}
    }

}
