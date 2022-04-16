package com.atypon.games.chess_game.utility;
import com.atypon.board.ChessBoard;
import com.atypon.board.Spot;
import com.atypon.pieces.*;

public class ChessMovement {

    private static boolean isCastling(Spot from, Spot to){
        if(from == null || to == null)
            throw new IllegalArgumentException();
        return (from.getPiece() instanceof King
                && Math.abs(from.getCoordinates().getY()-to.getCoordinates().getY()) == 2);
    }
    private static void performCastling(ChessBoard chessBoard, Spot from, Spot to){
        if(chessBoard == null || from == null || to == null)
            throw new IllegalArgumentException();
        Spot rookSpot;
        Spot newRookSpot;
        if(to.getCoordinates().getY() > from.getCoordinates().getY()) { // kingSide castling
            rookSpot = chessBoard.getSpot(from.getCoordinates().getX(), 7);
            newRookSpot = chessBoard.getSpot(from.getCoordinates().getX(), 5);
        }else{ // queenSide castling
            rookSpot = chessBoard.getSpot(from.getCoordinates().getX(), 0);
            newRookSpot = chessBoard.getSpot(from.getCoordinates().getX(), 3);
        }
        performMove(chessBoard, rookSpot, newRookSpot);
    }
    private static boolean isPromotion(Spot from, Spot to){
        if(from == null || to == null)
            throw new IllegalArgumentException();
        return (from.getPiece() instanceof Pawn
                && from.getPiece().getColor() == Color.WHITE
                && to.getCoordinates().getX() == 7
                || from.getPiece().getColor() == Color.BLACK
                && to.getCoordinates().getX() == 0);
    }
    private static void performPromotion(Spot from){
        if(from == null)
            throw new IllegalArgumentException();
        from.setPiece(new Queen(from.getPiece().getColor()));
    }
    private static void performMove(ChessBoard chessBoard, Spot from, Spot to){
        if(chessBoard == null || from == null || to == null)
            throw new IllegalArgumentException();
        to.setPiece(from.getPiece());
        to.getPiece().move();
        from.setPiece(new NoPiece());
    }

    /*
    remove underAttack spots
     */
    private static void removeUnderAttackSpots(ChessBoard chessBoard, Spot from){

    }

    /*
    add underAttack spots
     */
    private static void addUnderAttackSpots(ChessBoard chessBoard, Spot to){

    }
    public static void move(ChessBoard chessBoard, Spot from, Spot to){
        if(chessBoard == null || from == null || to == null)
            throw new IllegalArgumentException();
        removeUnderAttackSpots(chessBoard, from);
        if(isCastling(from,to))
            performCastling(chessBoard, from, to);
        if(isPromotion(from, to))
            performPromotion(from);
        performMove(chessBoard, from, to);
        addUnderAttackSpots(chessBoard, to);

        System.out.println();
        System.out.println(chessBoard);
    }

}
