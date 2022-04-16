package com.atypon;

import com.atypon.games.chess_game.ChessGame;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    // client code for chess game
      ChessGame game = new ChessGame("fahed", "ahmad"); // fahed is name of white player
                                                                                   // ahmad is name of black player
      while(!game.isDone()){
          String move = readMoveFromConsole(); // e.g., "move B8 C6"
          if(game.isWhiteTurn())
              game.playWhite( move );
          else
              game.playBlack( move );
      }
      game.printWinnerName();
  }

  public static String readMoveFromConsole(){
      Scanner sc = new Scanner(System.in);
      return sc.nextLine();
  }
}
