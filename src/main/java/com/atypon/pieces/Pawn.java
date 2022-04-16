package com.atypon.pieces;

import com.atypon.jump_behaviour.NoJump;
import com.atypon.movement_behaviour.ForwardByOne;
import com.atypon.movement_behaviour.ForwardByTwo;

public class Pawn extends Piece{
    private boolean hasMoved;
    public Pawn(Color color){
        super(color);
        setMovementBehaviour(new ForwardByTwo());
        setJumpBehaviour(new NoJump());
        hasMoved = false;
    }

    @Override
    public void move() {
        enableHasMoved();
        if(getMovementBehaviour() instanceof ForwardByTwo)
            setMovementBehaviour(new ForwardByOne());
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
            return "WP";
        }else{
            return "BP";
        }
    }
}
