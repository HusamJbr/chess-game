package com.atypon.chess_game.pieces;

import com.atypon.chess_game.jump_behaviour.NoJump;
import com.atypon.chess_game.movement_behaviour.ForwardByOne;
import com.atypon.chess_game.movement_behaviour.ForwardByTwo;

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
        setHasMoved(true);
        if(getMovementBehaviour() instanceof ForwardByTwo)
            setMovementBehaviour(new ForwardByOne());
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
