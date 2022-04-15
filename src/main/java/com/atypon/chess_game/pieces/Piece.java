package com.atypon.chess_game.pieces;

import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.jump_behaviour.JumpBehaviour;
import com.atypon.chess_game.movement_behaviour.MovementBehaviour;

public abstract class Piece {
    private Color color;
    private MovementBehaviour movementBehaviour;
    private JumpBehaviour jumpBehaviour;
    Piece(Color color){
        this.color = color;
    }
    public void setMovementBehaviour(MovementBehaviour movementBehaviour){
        this.movementBehaviour = movementBehaviour;
    }

    public MovementBehaviour getMovementBehaviour() {
        return movementBehaviour;
    }

    public void setJumpBehaviour(JumpBehaviour jumpBehaviour) {
        this.jumpBehaviour = jumpBehaviour;
    }
    public abstract void move();
    /*
        check if the piece can perform this move shape
     */
    public boolean canMove(Spot from, Spot to){
        return movementBehaviour.canMove(from, to);
    }
    public boolean canJump(){
        return jumpBehaviour.canJump();
    }

    public Color getColor() {
        return color;
    }
}
