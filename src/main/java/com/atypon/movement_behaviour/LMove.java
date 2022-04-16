package com.atypon.movement_behaviour;

import com.atypon.board.Coordinates;
import com.atypon.board.Spot;

import java.util.List;

public class LMove implements MovementBehaviour{

    @Override
    public boolean canMove(Spot from, Spot to) {
        return true;
    }

    @Override
    public List<Coordinates> listOfThreateningSpots(Spot spot) {
        return null;
    }
}
