package com.atypon.chess_game.movement_behaviour;

import com.atypon.chess_game.board.Spot;

public class LMove implements MovementBehaviour{

    @Override
    public boolean canMove(Spot from, Spot to) {
        return true;
    }
}
