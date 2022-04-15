package com.atypon.chess_game.validator;

import com.atypon.chess_game.board.Board;
import com.atypon.chess_game.board.ChessBoard;
import com.atypon.chess_game.board.Spot;
import com.atypon.chess_game.parser.MovementParser;
import com.atypon.chess_game.pieces.Piece;
import com.atypon.chess_game.Player;

public class MovementValidator {
    MovementValidator(){ //, chessBoard

    }


    public boolean isValidMove(Board board, Player player, String move){
        if(board == null || player == null || move == null || !(board instanceof ChessBoard)){
            throw new IllegalArgumentException();
        }
        ChessBoard chessBoard = (ChessBoard) board;
        MovementParser movementParser = MovementParser.parseString(move);

        Spot from = chessBoard.getSpot(movementParser.getFrom().getX(), movementParser.getFrom().getY());
        Spot to = chessBoard.getSpot(movementParser.getTo().getX(), movementParser.getTo().getY());
        Piece fromPiece = from.getPiece();
        if(chessBoard.canMove(from, to) && player.canMove(from, to) && fromPiece.canMove(from, to)){

        }
        return false;
    }
}
