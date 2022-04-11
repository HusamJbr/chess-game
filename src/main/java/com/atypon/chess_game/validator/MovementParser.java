package com.atypon.chess_game.validator;
import javafx.util.Pair;
import java.util.StringTokenizer;

enum Command {
    EMPTY,MOVE,DRAW
}
public class MovementParser {
    private Command command;
    private Pair<Integer,Integer> from,to;
    MovementParser(){
        command = Command.EMPTY;
        from = new Pair<>(-1,-1);
        to = new Pair<>(-1,-1);
    }

    public boolean parse(String move){
        if(move == null)
            throw new IllegalArgumentException();
        StringTokenizer stringTokenizer = new StringTokenizer(move," ");
        Command command = handleCommand(stringTokenizer);
        if(command == null)
            return false;
        if(command == Command.MOVE){
            Pair<Integer,Integer> from = handleSpots(stringTokenizer);
            Pair<Integer,Integer> to = handleSpots(stringTokenizer);
            if(from == null || to == null)
                return false;
            this.from = from;
            this.to = to;
        }
        this.command = command;
        return true;
    }

    private Pair<Integer, Integer> handleSpots(StringTokenizer input){
        if(!input.hasMoreTokens())
            return null;
        String start = input.nextToken();
        if(start.length() != 2)
            return null;
        int row = (start.charAt(1)-'0')-1;
        int col = start.charAt(0)-'A';
        return new Pair<>(col, row);
    }
    private Command handleCommand(StringTokenizer input){
        if(!input.hasMoreTokens())
            return null;
        String command = input.nextToken();
        switch (command){
            case "move":
                return Command.MOVE;
            case "draw":
                return Command.DRAW;
            default:
                return null;
        }
    }

    public boolean hasCommand(){
        return (command != Command.EMPTY);
    }
    public boolean hasFrom(){
        return (from != new Pair<>(-1,-1));
    }

    public boolean hasTo(){
        return (to != new Pair<>(-1,-1));
    }

    public Command getCommand() {
        return command;
    }

    public Pair<Integer,Integer> getFrom() {
        return from;
    }

    public Pair<Integer, Integer> getTo() {
        return to;
    }
}
