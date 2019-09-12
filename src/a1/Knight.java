package a1;

import java.util.ArrayList;

public class Knight extends ChessPiece
{
    public Knight(ChessBoard board,Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color==Color.WHITE)
        {
            return "\u2658";
        }
        else
        {
            return "\u265E";
        }
    }

    public ArrayList<String> legalMoves()
    {
        ArrayList<String> moves = new ArrayList<String>();
        return moves;
    }
}
