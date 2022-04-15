package com.atypon.chess_game;

import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.pieces.Color;

public class Player {
    private Color playerColor;
    private String playerName;
    public Player(Color playerColor, String playerName){
        this.playerColor = playerColor;
        this.playerName = playerName;
    }

    /*
    check if the player king under check then this player can't
    move anything except the king or something can make king not under attack
     */
    public boolean canMove(Spot from, Spot to) {
        if(from.getPiece().getColor() != playerColor) {
            return false;
        }
        return true;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
