package com.atypon.movement_behaviour;

import com.atypon.board.Spot;

public interface MovementBehaviour {
    boolean canMove(Spot from, Spot to);
}
