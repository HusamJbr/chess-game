package com.atypon.chess_game.pieces;

import com.atypon.chess_game.jump_behaviour.NoJump;
import com.atypon.chess_game.movement_behaviour.AroundAndOneHorizontally;
import com.atypon.chess_game.movement_behaviour.AroundAndTwoHorizontally;

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
        setHasMoved(true);
        if(getMovementBehaviour() instanceof AroundAndTwoHorizontally)
            setMovementBehaviour(new AroundAndOneHorizontally());
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
            return "WK";
        }else{
            return "BK";
        }
    }
}
