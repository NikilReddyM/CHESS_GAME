package a1;

import java.util.ArrayList;

public class Bishop extends ChessPiece
{
    public Bishop(ChessBoard board,Color color)
    {
        super(board,color);
    }
    public String toString()
    {
        if(this.color==Color.WHITE)
        {
            return "\u2657";
        }
        else
        {
            return "\u265D";
        }
    }

    public ArrayList<String> legalMoves()
    {
        ArrayList<String> moves = new ArrayList<String>();

        String position = this.getPosition();
        int[] coord = positionStrToNum(position);
        int row_K = coord[0];
        int col_k = coord[1];
        int row_k_temp, col_k_temp;
        try {
            //top-right

            row_k_temp = row_K + 1;
            col_k_temp = col_k + 1;
            while (true) {
                if (!positionOnBoard(row_k_temp, col_k_temp)) {
                    break;
                }
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_k_temp, col_k_temp));
                if (tempPiece == null) {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    row_k_temp = row_k_temp + 1;
                    col_k_temp = col_k_temp + 1;
                } else if (tempPiece.getColor() == this.color) {
                    break;
                } else {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    break;
                }
            }

        }
        catch (IllegalPositionException e)
        {
        }

        try {
            //top-left

            row_k_temp = row_K + 1;
            col_k_temp = col_k - 1;
            while (true) {
                if (!positionOnBoard(row_k_temp, col_k_temp)) {
                    break;
                }
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_k_temp, col_k_temp));
                if (tempPiece == null) {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    row_k_temp = row_k_temp + 1;
                    col_k_temp = col_k_temp - 1;
                } else if (tempPiece.getColor() == this.color) {
                    break;
                } else {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    break;
                }
            }
        }
        catch (IllegalPositionException e)
        {}

        try {
            //bottom left

            row_k_temp = row_K - 1;
            col_k_temp = col_k - 1;
            while (true) {
                if (!positionOnBoard(row_k_temp, col_k_temp)) {
                    break;
                }
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_k_temp, col_k_temp));
                if (tempPiece == null) {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    row_k_temp = row_k_temp - 1;
                    col_k_temp = col_k_temp - 1;
                } else if (tempPiece.getColor() == this.color) {
                    break;
                } else {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    break;
                }
            }
        }
        catch (IllegalPositionException e)
        {}

        try {
            //bottom right

            row_k_temp = row_K - 1;
            col_k_temp = col_k + 1;
            while (true) {
                if (!positionOnBoard(row_k_temp, col_k_temp)) {
                    break;
                }
                ChessPiece tempPiece = this.board.getPiece(positionNumToStr(row_k_temp, col_k_temp));
                if (tempPiece == null) {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
                    row_k_temp = row_k_temp - 1;
                    col_k_temp = col_k_temp + 1;
                } else if (tempPiece.getColor() == this.color) {
                    break;
                } else {
                    moves.add(positionNumToStr(row_k_temp, col_k_temp));
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
