package com.atypon.board;
import com.atypon.games.chess_game.utility.InitialPiecesLocation;

public class ChessBoard implements Board{
    private int rows,cols;
    private Spot[][] chessBoard;
    public ChessBoard(){
       rows=cols=8;
       chessBoard = new Spot[rows][cols];
       init();
    }

    @Override
    public void init() {
        InitialPiecesLocation.perform(chessBoard);
    }

    /*
    1- check if the piece king under check then this piece can't
    move except the king or something can make the king not under attack
    2- check if the piece is king then the next spot in not underAttack
    and check if the piece can't jump then all spots between from and to don't have pieces and so on
     */
    public boolean canMove(Spot from, Spot to){
        return true;
    }

    @Override
    public int rowsSize() {
        return rows;
    }

    @Override
    public int colsSize() {
        return cols;
    }

    public Spot getSpot(int x,int y) {
        return chessBoard[x][y];
    }

    public void setSpot(Spot spot) {
        if(spot == null)
            throw new IllegalArgumentException();
        chessBoard[spot.getCoordinates().getX()][spot.getCoordinates().getY()] = spot;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("   ");
        for(int j = 0; j < chessBoard[0].length; j++){
            ans.append((char)(j+'A')+"  ");
        }
        ans.append("\r\n");
        ans.append("   ");
        for(int j = 0; j < chessBoard[0].length; j++){
            ans.append("---");
        }
        ans.append("\r\n");
        for(int row = 0; row < chessBoard.length; row++) {
            ans.append(String.valueOf(row+1)+" |");
            for(int col = 0; col < chessBoard[row].length; col++) {
                ans.append(chessBoard[row][col].toString()+" ");
            }
            ans.append("\r\n");
        }
        return ans.toString();
    }
}
