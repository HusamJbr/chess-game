package com.atypon.pieces;

import com.atypon.jump_behaviour.CanJump;
import com.atypon.movement_behaviour.LMove;

public class Knight extends Piece{

    private boolean hasMoved;
    public Knight(Color color){
        super(color);
        setMovementBehaviour(new LMove());
        setJumpBehaviour(new CanJump());
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
            return "WN";
        }else{
            return "BN";
        }
    }
}
