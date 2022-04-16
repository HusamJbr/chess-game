package com.atypon.pieces;

import com.atypon.board.Coordinates;
import com.atypon.board.Spot;
import com.atypon.jump_behaviour.JumpBehaviour;
import com.atypon.movement_behaviour.MovementBehaviour;

import java.util.List;

public abstract class Piece {
    private Color color;
    private MovementBehaviour movementBehaviour;
    private JumpBehaviour jumpBehaviour;
    Piece(Color color){
        if(color == null)
            throw new IllegalArgumentException();
        this.color = color;
    }
    public void setMovementBehaviour(MovementBehaviour movementBehaviour){
        if(movementBehaviour == null)
            throw new IllegalArgumentException();
        this.movementBehaviour = movementBehaviour;
    }

    public MovementBehaviour getMovementBehaviour() {
        return movementBehaviour;
    }

    public void setJumpBehaviour(JumpBehaviour jumpBehaviour) {
        if(jumpBehaviour == null)
            throw new IllegalArgumentException();
        this.jumpBehaviour = jumpBehaviour;
    }
    public abstract void move();
    public boolean canMove(Spot from, Spot to){
        if(from == null || to == null)
            throw new IllegalArgumentException();
        return movementBehaviour.canMove(from, to);
    }
    public List<Coordinates> listOfThreateningSpots(Spot spot) {
        if(spot == null)
            throw new IllegalArgumentException();
        return movementBehaviour.listOfThreateningSpots(spot);
    }
    public boolean canJump(){
        return jumpBehaviour.canJump();
    }

    public Color getColor() {
        return color;
    }
}
