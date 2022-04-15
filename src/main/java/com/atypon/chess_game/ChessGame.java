package com.atypon.chess_game;

import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.parser.MovementParser;
import com.atypon.chess_game.pieces.Color;
import com.atypon.chess_game.utility.Move;

public class ChessGame {
    private ChessBoard chessBoard;
    private Player whitePlayer, blackPlayer;
    private String winnerName;
    private boolean turn;
    ChessGame(String whitePlayerName, String blackPlayerName){
        chessBoard = new ChessBoard();
        whitePlayer = new Player(Color.WHITE, whitePlayerName);
        blackPlayer = new Player(Color.BLACK, blackPlayerName);
        turn = false;
        winnerName = "";
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
        if(isStealMate(whitePlayer,blackPlayer)){
            winnerName = "Draw";
            return true;
        }
        return false;
    }

    /*
    check if king spot is check and king can't defend him self then its check mated
     */
    private boolean isCheckMated(Player player){
        return false;
    }
    /*
    check if the king spot isn't check and king can't defend himself then it steal mated
     */
    private boolean isStealMate(Player whitePlayer, Player blackPlayer){
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
            Move.move(chessBoard, from, to);
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
