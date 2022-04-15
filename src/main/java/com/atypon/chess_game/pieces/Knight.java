package com.atypon.chess_game.pieces;

import com.atypon.chess_game.jump_behaviour.CanJump;
import com.atypon.chess_game.movement_behaviour.LMove;

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
        setHasMoved(true);
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
