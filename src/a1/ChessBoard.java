package a1;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessBoard {
    private ChessPiece[][] board;

    ChessBoard() {
        board = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = null;
            }
        }
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = null;
            }
        }

        //white pieces
        ChessPiece white_rook_right = new Rook(this, ChessPiece.Color.WHITE);
        ChessPiece white_knight_right = new Knight(this, ChessPiece.Color.WHITE);
        ChessPiece white_bishop_right = new Bishop(this, ChessPiece.Color.WHITE);
        ChessPiece white_rook_left = new Rook(this, ChessPiece.Color.WHITE);
        ChessPiece white_knight_left = new Knight(this, ChessPiece.Color.WHITE);
        ChessPiece white_bishop_left = new Bishop(this, ChessPiece.Color.WHITE);
        ChessPiece white_queen = new Queen(this, ChessPiece.Color.WHITE);
        ChessPiece white_king = new King(this, ChessPiece.Color.WHITE);
        //black pieces
        ChessPiece black_rook_right = new Rook(this, ChessPiece.Color.BLACK);
        ChessPiece black_knight_right = new Knight(this, ChessPiece.Color.BLACK);
        ChessPiece black_bishop_right = new Bishop(this, ChessPiece.Color.BLACK);
        ChessPiece black_rook_left = new Rook(this, ChessPiece.Color.BLACK);
        ChessPiece black_knight_left = new Knight(this, ChessPiece.Color.BLACK);
        ChessPiece black_bishop_left = new Bishop(this, ChessPiece.Color.BLACK);
        ChessPiece black_queen = new Queen(this, ChessPiece.Color.BLACK);
        ChessPiece black_king = new King(this, ChessPiece.Color.BLACK);


        // add white pieces to the chess board
        placePiece(white_rook_right, "h1");
        placePiece(white_knight_right, "g1");
        placePiece(white_bishop_right, "f1");
        placePiece(white_queen, "d1");
        placePiece(white_king, "e1");
        placePiece(white_rook_left, "a1");
        placePiece(white_knight_left, "b1");
        placePiece(white_bishop_left, "c1");

        for (int i = 0; i < 8; i++) {
            ChessPiece white_pawn = new Pawn(this, ChessPiece.Color.WHITE);
            String position = positionNumToStr(1, i);
            if (placePiece(white_pawn, position) == false) {
                System.out.println("white pawn Piece not placed in the right position");
            }
        }

        // add black pieces to the chess board
        placePiece(black_rook_right, "h8");
        placePiece(black_knight_right, "g8");
        placePiece(black_bishop_right, "f8");
        placePiece(black_queen, "d8");
        placePiece(black_king, "e8");
        placePiece(black_rook_left, "a8");
        placePiece(black_knight_left, "b8");
        placePiece(black_bishop_left, "c8");

        for (int i = 0; i < 8; i++) {
            ChessPiece black_pawn = new Pawn(this, ChessPiece.Color.BLACK);
            String position = positionNumToStr(6, i);
            if (placePiece(black_pawn, position) == false) {
                System.out.println("black pawn Piece not placed in the right position");
            }
        }

    }


    public ChessPiece getPiece(String position) throws IllegalPositionException {
        //System.out.println("in getpiece method starting: "+position);
        int[] positionCoOrdinates = positionStrToNum(position);

        boolean isPositionOnBoard = positionOnBoard(positionCoOrdinates[0], positionCoOrdinates[1]);

        if (isPositionOnBoard) {
            return board[positionCoOrdinates[0]][positionCoOrdinates[1]];
        } else {
            throw new IllegalPositionException("enter valid positions, illegal position exception is thrown in get " +
                    "piece method of chess board class");
        }

    }

    public boolean placePiece(ChessPiece piece, String position) {

        try {
            piece.setPosition(position);
            ChessPiece piece_in_afterposition = getPiece(position);
            int[] positionCoOrdinates = positionStrToNum(position);
            boolean condition = ((piece_in_afterposition == null) ||
                    (piece.getColor() == ChessPiece.Color.WHITE && piece_in_afterposition.getColor() == ChessPiece.Color.BLACK) ||
                    (piece.getColor() == ChessPiece.Color.BLACK && piece_in_afterposition.getColor() == ChessPiece.Color.WHITE));
            if (condition) {
                this.board[positionCoOrdinates[0]][positionCoOrdinates[1]] = piece;
                return true;
            } else {
                return false;
            }
        } catch (IllegalPositionException e) {
            return false;
        }

    }

    public void move(String fromPosition, String toPosition) throws IllegalMoveException {

        int row_from;
        int col_from;
        ChessPiece piece;

        int[] temp_position = positionStrToNum(fromPosition);
        row_from = temp_position[0];
        col_from = temp_position[1];

        try {
            piece = getPiece(fromPosition);

            ArrayList<String> moves = piece.legalMoves();


            if (moves.contains(toPosition)) {
                placePiece(piece, toPosition);
                board[row_from][col_from] = null;
            } else {
                throw new IllegalMoveException();
            }
        } catch (IllegalPositionException e) {
        }

    }

    public String toString() {
        String chess = "";
        String upperLeft = "\u250C";
        String upperRight = "\u2510";
        String horizontalLine = "\u2500";
        String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
        String verticalLine = "\u2502";
        String upperT = "\u252C";
        String bottomLeft = "\u2514";
        String bottomRight = "\u2518";
        String bottomT = "\u2534";
        String plus = "\u253C";
        String leftT = "\u251C";
        String rightT = "\u2524";

        String topLine = upperLeft;
        for (int i = 0; i < 7; i++) {
            topLine += horizontal3 + upperT;
        }
        topLine += horizontal3 + upperRight;

        String bottomLine = bottomLeft;
        for (int i = 0; i < 7; i++) {
            bottomLine += horizontal3 + bottomT;
        }
        bottomLine += horizontal3 + bottomRight;
        chess += topLine + "\n";

        for (int row = 7; row >= 0; row--) {
            String midLine = "";
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    midLine += verticalLine + " \u3000 ";
                } else {
                    midLine += verticalLine + " " + board[row][col] + " ";
                }
            }
            midLine += verticalLine;
            String midLine2 = leftT;
            for (int i = 0; i < 7; i++) {
                midLine2 += horizontal3 + plus;
            }
            midLine2 += horizontal3 + rightT;
            chess += midLine + "\n";
            if (row >= 1)
                chess += midLine2 + "\n";
        }

        chess += bottomLine;
        return chess;
    }


    private int[] positionStrToNum(String position) {
        int row;
        int col;

        col = position.charAt(0);
        row = Character.getNumericValue(position.charAt(1));

        col = col - 97;
        row = row - 1;

        int[] position_converted = {row, col};
        return position_converted;
    }

    private String positionNumToStr(int row, int col) {
        col = col + 97;
        row = row + 1;
        return (char) col + Integer.toString(row);
    }

    private Boolean positionOnBoard(int row, int col) {
        if ((col >= 0 && col <= 7) && (row >= 0 && row <= 7)) {
            return true;
        } else {
            return false;
        }
    }

//    public void positionsInfo() throws IllegalPositionException
//    {
//        for(int i=0;i<8;i++)
//        {
//            for(int j=0;j<8;j++)
//            {
//                String position = positionNumToStr(i,j);
//                ChessPiece piece = getPiece(position);
//                if(piece!=null)
//                {
//                    System.out.println("========================");
//                    System.out.println("piece row "+piece.row);
//                    System.out.println("piece column "+piece.column);
//                    System.out.println("piece color is "+piece.getColor());
//                }
//
//            }
//        }
//    }

//    public static void main(String[] args) throws IllegalPositionException {
//        ChessBoard board = new ChessBoard();
//        String[] positions = {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1",
//                "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
//                "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
//                "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
//                "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
//                "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
//                "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
//                "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"
//        };
//        for (int i = 0; i < 64; i++) {
//
//            try {
//                System.out.println(i);
//                if (board.getPiece(positions[i]).toString() != null) {
//                    System.out.println("found");
//                }
//            } catch (IllegalPositionException e) {
//            }

//
//        ChessBoard board = new ChessBoard();
//
////        board.initialize();
////        board.move("a7","a5");
////        board.move("a5","a4");
////        board.move("a2","a3");
////        System.out.println(board.getPiece("a2").legalMoves().size());
////
////        board.initialize();
////        board.move("a7","a5");
////        board.move("a5","a4");
////        board.move("a4","a3");
////        System.out.println(board.getPiece("a2").legalMoves().size());
////        ArrayList<String> moves = board.getPiece("a2").legalMoves();
////        for(String name:moves) {
////            System.out.println(name);
////        }
////        board.move("a4","a3");
////        System.out.println(board.getPiece("a2").legalMoves().size());
//        System.out.println(board);
////        ChessBoard board = new ChessBoard();
////        ChessPiece knight = new Knight(board, ChessPiece.Color.WHITE);
////        board.placePiece(knight, "b1");
////        System.out.println(board.getPiece("b1").legalMoves().size());
//
//
//        //moving pawn
////        board.move("a2","a4");
//////        board.move("a3","a4");
////        board.move("a4","a5");
////        board.move("a7","a6");
////        board.move("a5","a6");
////        //moving rook
////        board.move("a1","a2");
////        board.move("a2","a5");
////        board.move("a5","b5");
////        board.move("b5","h5");
////        board.move("h5","c5");
////        board.move("c5","c3");
////        //ChessPiece cp = board.getPiece("a7");
////
////        board.move("d2","d3");
////        board.move("c1","d2");
////        board.move("d2","e3");
//////
//////        board.move("e3","d2");
//////        board.move("d2","c1");
////        board.move("e3","f4");
////        board.move("f4","e5");
////        board.move("e5","f4");
////
////        board.move("h7","h5");
////        board.move("h8","h6");
////
////        board.move("a7","a5");
////        board.move("a8","a6");
////        ChessPiece whiteking = new King(board, ChessPiece.Color.WHITE);
////
////
////        ChessPiece whiteking1 = new King(board, ChessPiece.Color.WHITE);
////        ChessPiece whiteking2 = new King(board, ChessPiece.Color.WHITE);
////        ChessPiece blackking1 = new King(board, ChessPiece.Color.BLACK);
////        ChessPiece blackking2 = new King(board, ChessPiece.Color.BLACK);
////        ChessPiece blackking3 = new King(board, ChessPiece.Color.BLACK);
////        ChessPiece blackking4 = new King(board, ChessPiece.Color.BLACK);
////
////        board.placePiece(whiteking, "e4");
////
////        board.placePiece(blackking1, "d5");
////        board.placePiece(blackking2, "e5");
////        board.placePiece(blackking3, "f5");
////
////        board.placePiece(whiteking1, "d4");
////        board.placePiece(whiteking2, "e3");
////        board.placePiece(blackking4, "f3");
////        ArrayList<String> moves = board.getPiece("e4").legalMoves();
////        ArrayList<String> moves = new ArrayList<String>();
////        moves.add("d5");
////        moves.add("e5");
////        moves.add("f5");
////        moves.add("d3");
////        moves.add("f4");
////        moves.add("f3");
////        System.out.println(board);
////        for(String name:moves) {
////            System.out.println(name);
////        }



}

