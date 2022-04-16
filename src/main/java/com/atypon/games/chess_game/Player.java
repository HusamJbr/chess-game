package com.atypon.games.chess_game;
import com.atypon.board.Spot;
import com.atypon.pieces.Color;

public class Player {
    private Color playerColor;
    private String playerName;
    public Player(Color playerColor, String playerName){
        this.playerColor = playerColor;
        this.playerName = playerName;
    }

    public boolean canMove(Spot from, Spot to) {
        if(from == null || to == null)
            throw new IllegalArgumentException();
        if(from.getPiece().getColor() != playerColor) {
            return false;
        }
        return true;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        if(playerColor == null)
            throw new IllegalArgumentException();
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        if(playerName == null)
            throw new IllegalArgumentException();
        this.playerName = playerName;
    }
}
