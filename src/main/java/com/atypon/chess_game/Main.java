package com.atypon.chess_game;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // client code for chess game
      ChessGame game = new ChessGame("fahed", "ahmad"); // fahed is name of white player
                                                                                   // ahmad is name of black player
      while(!game.isDone()){
          String move = read_move_from_console(); // e.g., "move B8 C6"
          if(game.isWhiteTurn())
              game.playWhite( move );
          else
              game.playBlack( move );
      }
      game.printWinnerName();
  }

  public static String read_move_from_console(){
      Scanner sc = new Scanner(System.in);
      return sc.nextLine();
  }
}
