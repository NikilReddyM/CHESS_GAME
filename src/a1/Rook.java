package a1;

import java.util.ArrayList;

public class Rook extends ChessPiece
{


    public Rook(ChessBoard board,Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color==Color.WHITE)
        {
            return "\u2656";
        }
        else
        {
            return "\u265C";
        }
    }

    public ArrayList<String> legalMoves()
    {
        ArrayList<String> moves = new ArrayList<String>();

        String position = this.getPosition();
        int[] coord = positionStrToNum(position);
        int row_K = coord[0];
        int col_k = coord[1];

        try{
            //move up
            for(int i=row_K+1;i<8;i++)
            {
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(i,col_k));
                if(tempPiece==null)
                {
                    moves.add(positionNumToStr(i,col_k));
                }
                else if(tempPiece.getColor()==this.color)
                {
                    break;
                }
                else
                {
                    moves.add(positionNumToStr(i,col_k));
                    break;
                }
            }

        }
        catch (IllegalPositionException e)
        {
        }


        try{
            //move down
            for(int i=row_K-1;i>-1;i--)
            {
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(i,col_k));
                if(tempPiece==null)
                {
                    moves.add(positionNumToStr(i,col_k));
                }
                else if(tempPiece.getColor()==this.color)
                {
                    break;
                }
                else
                {
                    moves.add(positionNumToStr(i,col_k));
                    break;
                }
            }
        }
        catch (IllegalPositionException e)
        {
        }


        try
        {
            //move right
            for(int i=col_k+1;i<8;i++)
            {
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_K,i));
                if(tempPiece==null)
                {
                    moves.add(positionNumToStr(row_K,i));
                }
                else if(tempPiece.getColor()==this.color)
                {
                    break;
                }
                else
                {
                    moves.add(positionNumToStr(row_K,i));
                    break;
                }
            }
        }
        catch (IllegalPositionException e)
        {
        }

        try
        {
        //move left
            for(int i=col_k-1;i>-1;i--)
            {
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_K,i));
                if(tempPiece==null)
                {
                    moves.add(positionNumToStr(row_K,i));
                }
                else if(tempPiece.getColor()==this.color)
                {
                    break;
                }
                else
                {
                    moves.add(positionNumToStr(row_K,i));
                    break;
                }
            }
        }
        catch (IllegalPositionException e)
        {
        }

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
