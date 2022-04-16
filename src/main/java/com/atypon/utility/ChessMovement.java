package com.atypon.utility;
import com.atypon.board.ChessBoard;
import com.atypon.board.Spot;
import com.atypon.pieces.*;

public class ChessMovement {

    private static void ifCastlingThenPerform(ChessBoard chessBoard, Spot from, Spot to){
        if(from.getPiece() instanceof King){
           if(Math.abs(from.getCoordinates().getY()-to.getCoordinates().getY()) == 2){
              if(to.getCoordinates().getY() > from.getCoordinates().getY()) { // kingSide castling
                    performMove(chessBoard, chessBoard.getSpot(from.getCoordinates().getX(),7), chessBoard.getSpot(from.getCoordinates().getX(),5));
              }else{ // queenSide castling
                    performMove(chessBoard, chessBoard.getSpot(from.getCoordinates().getX(),0), chessBoard.getSpot(from.getCoordinates().getX(), 3));
              }
           }
        }
    }
    private static void ifPromotionThenPerform(Spot from, Spot to){
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
    private static void performMove(ChessBoard chessBoard, Spot from, Spot to){
        to.setPiece(from.getPiece());
        to.getPiece().move();
        /*
        remove and add new underAttack spots
         */
        from.setPiece(new NoPiece());
    }
    public static void move(ChessBoard chessBoard, Spot from, Spot to){
        ifCastlingThenPerform(chessBoard, from, to);
        ifPromotionThenPerform(from, to);
        performMove(chessBoard, from, to);
        System.out.println();
        System.out.println(chessBoard);
    }

}
