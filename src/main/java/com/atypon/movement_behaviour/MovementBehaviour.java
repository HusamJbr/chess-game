package com.atypon.movement_behaviour;

import com.atypon.board.Coordinates;
import com.atypon.board.Spot;

import java.util.List;

public interface MovementBehaviour {
    boolean canMove(Spot from, Spot to);
    List<Coordinates> listOfThreateningSpots(Spot spot);
}
