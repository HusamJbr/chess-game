package com.atypon.pieces;
import com.atypon.jump_behaviour.NoJump;
import com.atypon.movement_behaviour.Diagonals;

public class Bishop extends Piece{
   private boolean hasMoved;
   public Bishop(Color color) {
      super(color);
      setMovementBehaviour(new Diagonals());
      setJumpBehaviour(new NoJump());
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
        return "WB";
      }else{
         return "BB";
      }
   }
}
