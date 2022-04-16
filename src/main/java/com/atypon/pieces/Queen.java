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
        enableHasMoved();
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void enableHasMoved(){
        this.hasMoved = true;
    }
    public void disableHasMoved(){
        this.hasMoved = false;
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
