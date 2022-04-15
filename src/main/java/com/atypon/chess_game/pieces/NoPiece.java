package com.atypon.chess_game.pieces;

public class NoPiece extends Piece{
    public NoPiece() {
        super(Color.NO_COLOR);
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return "--";
    }
}
