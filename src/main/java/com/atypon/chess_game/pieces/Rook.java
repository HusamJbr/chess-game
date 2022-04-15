package com.atypon.chess_game.pieces;

import com.atypon.chess_game.jump_behaviour.NoJump;
import com.atypon.chess_game.movement_behaviour.HorizontallyAndVertically;

public class Rook extends Piece{
    private boolean hasMoved;
    public Rook(Color color){
        super(color);
        setMovementBehaviour(new HorizontallyAndVertically());
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
            return "WR";
        }else{
            return "BR";
        }
    }
}
