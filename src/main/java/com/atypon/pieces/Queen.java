package com.atypon.pieces;

import com.atypon.jump_behaviour.NoJump;
import com.atypon.movement_behaviour.AllDirections;

public class Queen extends Piece{
    private boolean hasMoved;
    public Queen(Color color){
        super(color);
        setMovementBehaviour(new AllDirections());
        setJumpBehaviour(new NoJump());
        hasMoved = false;
    }

    @Override
    public void move() {
        setHasMoved(true);
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }


    @Override
    public String toString() {

        if(getColor() == Color.WHITE){
            return "WQ";
        }else{
            return "BQ";
        }
    }
}