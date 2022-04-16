package com.atypon.pieces;

import com.atypon.jump_behaviour.NoJump;
import com.atypon.movement_behaviour.AroundAndOneHorizontally;
import com.atypon.movement_behaviour.AroundAndTwoHorizontally;

public class King extends Piece{

    private boolean hasMoved;
    public King(Color color){
        super(color);
        setMovementBehaviour(new AroundAndTwoHorizontally());
        setJumpBehaviour(new NoJump());
        hasMoved = false;
    }

    @Override
    public void move() {
        enableHasMoved();
        if(getMovementBehaviour() instanceof AroundAndTwoHorizontally)
            setMovementBehaviour(new AroundAndOneHorizontally());
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
            return "WK";
        }else{
            return "BK";
        }
    }
}
