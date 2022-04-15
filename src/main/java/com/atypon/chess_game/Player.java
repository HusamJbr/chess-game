package com.atypon.chess_game;

import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.pieces.Color;

public class Player {
    private Color playerColor;
    private String playerName;
    private boolean isCheckmated;
    public Player(Color playerColor, String playerName){
        this.playerColor = playerColor;
        this.playerName = playerName;
        isCheckmated = false;
    }

    public boolean canMove(Spot from, Spot to) {
        return true;
    }

    public boolean isCheckmated() {
        return (isCheckmated == true);
    }

    public void enableCheckmated() {
        isCheckmated = true;
    }
    public void disableCheckmated(){
        isCheckmated = false;
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
