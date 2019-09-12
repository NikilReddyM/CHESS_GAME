package a1;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class KnightTest
{
    private ChessBoard board;
    public void createNewBoard() {
        board = new ChessBoard();
    }

    @Test
    public void testOnKnightName()
    {
        createNewBoard();
        board.initialize();
        try {
            assertEquals(board.getPiece("b1").toString(), "\u2658");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("g1").toString(), "\u2658");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("b8").toString(), "\u265E");
        } catch (IllegalPositionException e) { }

        try {
            assertEquals(board.getPiece("g8").toString(), "\u265E");
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnEmptyBoard()
    {
        try {
            createNewBoard();
            ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
            board.placePiece(knight, "b1");
            assertTrue(board.getPiece("b1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
            board.placePiece(knight, "g1");
            assertTrue(board.getPiece("g1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
            board.placePiece(knight, "b8");
            assertTrue(board.getPiece("b8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
            board.placePiece(knight, "g8");
            assertTrue(board.getPiece("g8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnInitializedBoard()
    {
        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("b1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("g1").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("b8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

        try {
            createNewBoard();
            board.initialize();
            assertTrue(board.getPiece("g8").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }
    }

    @Test
    public void testOnAnyPosition()
    {
        try {
            createNewBoard();
            board.initialize();
            ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
            board.placePiece(knight, "b4");
            assertTrue(board.getPiece("b4").legalMoves().size() == 0);
        } catch (IllegalPositionException e) { }

    }
}
