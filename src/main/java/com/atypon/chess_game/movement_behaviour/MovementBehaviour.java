package com.atypon.chess_game.movement_behaviour;

import com.atypon.chess_game.board.Spot;

public interface MovementBehaviour {
    boolean canMove(Spot from, Spot to);
}
