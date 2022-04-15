package com.atypon.chess_game.board;

import com.atypon.chess_game.pieces.Piece;

public class Spot {
    private Piece piece;
    private Coordinates coordinates;
    private int underAttack;
    public Spot(Coordinates coordinates, Piece piece){
       this.coordinates = coordinates;
       this.piece = piece;
       underAttack = 0;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void addUnderAttack(){
        underAttack++;
    }

    public void subUnderAttack(){
        underAttack--;
    }

    public boolean isUnderAttack(){
       return (underAttack!=0);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece(){
        return piece;
    }
}
