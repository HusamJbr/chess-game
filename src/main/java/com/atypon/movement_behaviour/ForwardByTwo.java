package com.atypon.movement_behaviour;

import com.atypon.board.Spot;

public class ForwardByTwo implements MovementBehaviour{
    @Override
    public boolean canMove(Spot from, Spot to) {
        return true;
    }
}
