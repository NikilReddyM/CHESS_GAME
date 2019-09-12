package a1;

import java.util.ArrayList;

public class Pawn extends ChessPiece
{
    public Pawn(ChessBoard board,Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color==Color.WHITE)
        {
            return "\u2659";
        }
        else
        {
            return "\u265F";
        }
    }

    public ArrayList<String> legalMoves()
    {
        String position = this.getPosition();

        ArrayList<String> moves = new ArrayList<String>();
        //System.out.println("position of piece "+position);
        int[] coord = positionStrToNum(position);
        int row_K = coord[0];
        int col_k = coord[1];
        int row_k1 = -1,col_k1 = -1;
        if(this.getColor()==Color.WHITE)
        {
            if(row_K==1)
            {
                row_k1 = row_K+2;
                col_k1 = col_k;
            }
            row_K = row_K+1;
        }
        else
        {
            if(row_K==6)
            {
                row_k1 = row_K-2;
                col_k1 = col_k;
            }
            row_K = row_K-1;
        }

        try
        {
            if (positionOnBoard(row_K, col_k)) {
                String currPoss = positionNumToStr(row_K, col_k);
                ChessPiece temp_piece = board.getPiece(currPoss);
                boolean condition = (temp_piece == null || this.getColor() != temp_piece.getColor());
                if (condition) {
                    moves.add(currPoss);
                }
            }
        }catch (IllegalPositionException e){}

        try
        {
            if (positionOnBoard(row_k1, col_k1)) {
                String currPoss = positionNumToStr(row_k1-1, col_k1);
                ChessPiece temp_piece = board.getPiece(currPoss);
                boolean condition = (temp_piece == null);

                currPoss = positionNumToStr(row_k1, col_k1);
                temp_piece = board.getPiece(currPoss);
                boolean condition1 = (temp_piece == null || this.getColor() != temp_piece.getColor());
                if (condition && condition1) {
                    moves.add(currPoss);
                }
            }
        }catch (IllegalPositionException e){}

        return moves;
    }


    private int[] positionStrToNum(String position)
    {
        int row;
        int col;

        col = position.charAt(0);
        row = Character.getNumericValue(position.charAt(1));

        col = col-97;
        row = row-1;

        int[] position_converted = {row,col};
        return position_converted;
    }

    private String positionNumToStr(int row,int col)
    {
        col = col+97;
        row = row+1;
        return (char)col+Integer.toString(row);
    }

    private Boolean positionOnBoard(int row,int col)
    {
        if((col>=0 && col<= 7)&&(row>=0 && row<= 7))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
