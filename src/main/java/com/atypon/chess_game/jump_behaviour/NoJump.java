package com.atypon.chess_game.jump_behaviour;

public class NoJump implements JumpBehaviour{
    @Override
    public boolean canJump() {
        return false;
    }
}
