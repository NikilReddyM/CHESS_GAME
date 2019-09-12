package a1;

import java.awt.*;
import java.util.ArrayList;

abstract class ChessPiece
{
    public enum Color {WHITE, BLACK};
    protected ChessBoard board; // the board it belongs to, default null
    protected int row; // the index of the horizontal rows 0..7
    protected int column; // the index of the vertical column 0..7
    protected Color color; // the color of the piece

    public ChessPiece(ChessBoard board, Color color)
    {
        this.board=board;
        this.color=color;
    }

    public Color getColor()
    {
        return color;
    }

    public String getPosition()
    {
        char temp_row = (char)(column+97);
        char temp_col = (char)(row+1+'0');
        //System.out.println("in get position method : "+temp_row+" "+temp_col);

        String position = new StringBuilder().append(temp_row).append(temp_col).toString();
        return position;
    }

    public void setPosition(String position) throws IllegalPositionException
    {
        int[] position_converted = positionStrToNum(position);
//        row = position_converted[0];
//        column = position_converted[1];
        if(positionOnBoard(position_converted[0],position_converted[1]))
        {
            row = position_converted[0];
            column = position_converted[1];
        }
        else
        {
            throw new IllegalPositionException("IllegalPositionException: position is not on board, enter valid positions");
        }

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

    abstract public String toString();

    abstract public ArrayList<String> legalMoves();
}
