package com.atypon.games.chess_game.utility;

import com.atypon.board.Coordinates;
import com.atypon.board.Spot;
import com.atypon.pieces.*;

public class InitialPiecesLocation {
    public static void perform(Spot[][] chessBoard){
        for(int i = 0; i <= 7; i+=7){
            chessBoard[i][0] = new Spot(new Coordinates(i, 0), new Rook((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][1] = new Spot(new Coordinates(i,1), new Knight((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][2] = new Spot(new Coordinates(i, 2), new Bishop((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][3] = new Spot(new Coordinates(i, 3), new Queen((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][4] = new Spot(new Coordinates(i, 4), new King((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][5] = new Spot(new Coordinates(i, 5), new Bishop((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][6] = new Spot(new Coordinates(i, 6), new Knight((i%2 == 0)? Color.WHITE: Color.BLACK));
            chessBoard[i][7] = new Spot(new Coordinates(i, 7), new Rook((i%2 == 0)? Color.WHITE: Color.BLACK));
        }
        for (int i = 1; i <= 6; i+=5){
            for (int j = 0; j < 8; j++){
                chessBoard[i][j] = new Spot(new Coordinates(i, j), new Pawn((i%2 == 1)? Color.WHITE: Color.BLACK));
            }
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = new Spot(new Coordinates(i, j), new NoPiece());
            }
        }
    }
}