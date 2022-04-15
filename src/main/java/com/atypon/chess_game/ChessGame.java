package com.atypon.chess_game;

import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.pieces.Color;

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

    public void playWhite( String move){
        turn^=true; // flip the bit
    }

    public void playBlack( String move ){
        turn^=true;

    }

    public void printWinnerName(){

    }
}
