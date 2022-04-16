package com.atypon.games.chess_game;

import com.atypon.board.ChessBoard;
import com.atypon.board.Spot;
import com.atypon.parser.MovementParser;
import com.atypon.pieces.Color;
import com.atypon.utility.ChessMovement;

public class ChessGame {
    private ChessBoard chessBoard;
    private Player whitePlayer, blackPlayer;
    private String winnerName;
    private boolean turn;
    public ChessGame(String whitePlayerName, String blackPlayerName){
        chessBoard = new ChessBoard();
        whitePlayer = new Player(Color.WHITE, whitePlayerName);
        blackPlayer = new Player(Color.BLACK, blackPlayerName);
        turn = false;
        winnerName = "No One";
        System.out.println(chessBoard);
    }

    public boolean isDone(){
        if(isCheckMated(whitePlayer)){
           winnerName = whitePlayer.getPlayerName();
           return true;
        }else if(isCheckMated(whitePlayer)){
            winnerName = blackPlayer.getPlayerName();
            return true;
        }
        if(isStealMate(whitePlayer) || isStealMate(blackPlayer)){
            winnerName = "Draw";
            return true;
        }
        return false;
    }

    /*
    From player color get the king and
    check if king spot is check and king can't defend him self then its check mated
     */
    private boolean isCheckMated(Player player){
        return false;
    }
    /*
    check if the king spot isn't check and king can't defend himself then it's staleMate
     */
    private boolean isStealMate(Player player){
        return false;
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
        MovementParser movementParser = MovementParser.parseString(move);
        Spot from = chessBoard.getSpot(movementParser.getFrom().getX(), movementParser.getFrom().getY());
        Spot to = chessBoard.getSpot(movementParser.getTo().getX(), movementParser.getTo().getY());
        if(isValidMove(player, from, to)){
            turn^=true; // flip the bit
            ChessMovement.move(chessBoard, from, to);
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

    public String printWinnerName(){
        return winnerName;
    }
}
