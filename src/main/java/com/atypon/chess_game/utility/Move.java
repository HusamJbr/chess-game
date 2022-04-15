package com.atypon.chess_game.utility;
import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.pieces.King;
import com.atypon.chess_game.pieces.NoPiece;
import com.atypon.chess_game.pieces.Pawn;
import com.atypon.chess_game.pieces.Queen;

public class Move {

    private static void ifCastlingPerform(ChessBoard chessBoard,Spot from, Spot to){
        if(from.getPiece() instanceof King){
           if(from.getCoordinates().getY()-to.getCoordinates().getY() == 2){
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
           if(from.getCoordinates().getX() == 6 && to.getCoordinates().getX() == 7){ // it's a promotion
                from.setPiece(new Queen(from.getPiece().getColor()));
           }
        }
    }
    private static void performMove(Spot from, Spot to){
        to.setPiece(from.getPiece());
        to.getPiece().move();
        from.setPiece(new NoPiece());
    }
    public static void move(ChessBoard chessBoard, Spot from, Spot to){
        ifCastlingPerform(chessBoard, from, to);
        ifPromotionPerform(from, to);
        performMove(from, to);
    }
}
