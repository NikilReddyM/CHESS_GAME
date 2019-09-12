package a1;

import java.util.ArrayList;

public class King extends ChessPiece
{
    public King(ChessBoard board,Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color==Color.WHITE)
        {
            return "\u2654";
        }
        else
        {
            return "\u265A";
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
        //System.out.println(position+" "+coord[0]+" "+coord[1]);
        int[][] allPossibleMoves = {{row_K,col_k-1},{row_K,col_k+1},{row_K-1,col_k-1},{row_K-1,col_k},
                {row_K-1,col_k+1},{row_K+1,col_k-1},{row_K+1,col_k},{row_K+1,col_k+1}};

        try
        {
            for (int i = 0; i < 8; i++)
            {
                if (positionOnBoard(allPossibleMoves[i][0], allPossibleMoves[i][1]))
                {
                    String currPoss = positionNumToStr(allPossibleMoves[i][0], allPossibleMoves[i][1]);
                    //System.out.println(allPossibleMoves[i][0]+" "+allPossibleMoves[i][1]+" "+currPoss);
                    ChessPiece temp_piece = board.getPiece(currPoss);
                    boolean condition = (temp_piece == null || this.getColor() != temp_piece.getColor());
                    if (condition) {
                        moves.add(currPoss);
                    }
                }
            }
        }
        catch (IllegalPositionException e){}

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
