package com.atypon.chess_game;

import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.parser.MovementParser;
import com.atypon.chess_game.pieces.Color;
import com.atypon.chess_game.pieces.Piece;

public class ChessGame {
    private ChessBoard chessBoard;
    private Player whitePlayer, blackPlayer;
    private boolean turn;
    ChessGame(String whitePlayerName, String blackPlayerName){
        chessBoard = new ChessBoard();
        whitePlayer = new Player(Color.WHITE, whitePlayerName);
        blackPlayer = new Player(Color.BLACK, blackPlayerName);
        turn = false;
    }

    public boolean isDone(){
        return true;
    }

   public boolean isWhiteTurn(){
        return !turn;
   }
    public boolean isBlackTurn(){
        return turn;
    }

    private boolean isValidMove(Player player, Spot from, Spot to){
        if(chessBoard.canMove(from, to) && player.canMove(from, to) && from.getPiece().canMove(from, to)){
            return true;
        }
        return false;
    }
    private void playAPlayer(Player player, String move){
        turn^=true; // flip the bit
        MovementParser movementParser = MovementParser.parseString(move);
        Spot from = chessBoard.getSpot(movementParser.getFrom().getX(), movementParser.getFrom().getY());
        Spot to = chessBoard.getSpot(movementParser.getTo().getX(), movementParser.getTo().getY());
        if(isValidMove(player, from, to)){

        }else {
            System.out.println("Try again");
        }
    }
    public void playWhite( String move){
        playAPlayer(whitePlayer, move);
    }

    public void playBlack( String move ){
        playAPlayer(blackPlayer, move);
    }

    public void printWinnerName(){

    }
}
