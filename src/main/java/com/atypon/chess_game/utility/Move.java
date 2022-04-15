package com.atypon.chess_game.utility;
import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.board.Coordinates;
import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.pieces.*;

public class Move {

    private static void ifCastlingPerform(ChessBoard chessBoard,Spot from, Spot to){
        if(from.getPiece() instanceof King){
           if(Math.abs(from.getCoordinates().getY()-to.getCoordinates().getY()) == 2){
              if(to.getCoordinates().getY() > from.getCoordinates().getY()) { // kingSide castling
                   performMove(chessBoard.getSpot(0,7), chessBoard.getSpot(0,5));
              }else{ // queenSide castling
                    performMove(chessBoard.getSpot(0,0), chessBoard.getSpot(0, 3));
              }
           }
        }
    }
    private static void ifPromotionPerform(Spot from, Spot to){
        if(from.getPiece() instanceof Pawn){
           if(from.getPiece().getColor() == Color.WHITE
                   && from.getCoordinates().getX() == 6 && to.getCoordinates().getX() == 7){ // it's a promotion
                from.setPiece(new Queen(from.getPiece().getColor()));
           }else if(from.getPiece().getColor() == Color.BLACK
                   && from.getCoordinates().getX() == 1 && to.getCoordinates().getX() == 0){
               from.setPiece(new Queen(from.getPiece().getColor()));
           }
        }
    }
    private static void performMove(Spot from, Spot to){
        to.setPiece(from.getPiece());
        to.getPiece().move();
        /*
        remove and add new underAttack spots
         */
        from.setPiece(new NoPiece());
    }
    public static void move(ChessBoard chessBoard, Spot from, Spot to){
        if(from.getPiece() instanceof King){
            if(from.getPiece().getColor() == Color.WHITE){
                chessBoard.setWhiteKing(to.getCoordinates());
            }else{
                chessBoard.setBlackKing(to.getCoordinates());
            }
        }
        ifCastlingPerform(chessBoard, from, to);
        ifPromotionPerform(from, to);
        performMove(from, to);
        System.out.println();
        System.out.println(chessBoard);
    }
}
