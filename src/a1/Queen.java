package a1;

import java.util.ArrayList;

public class Queen extends ChessPiece
{
    public Queen(ChessBoard board, ChessPiece.Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color== ChessPiece.Color.WHITE)
        {
            return "\u2655";
        }
        else
        {
            return "\u265B";
        }
    }

    public ArrayList<String> legalMoves()
    {
        ArrayList<String> moves = new ArrayList<String>();
        return moves;
    }
}
