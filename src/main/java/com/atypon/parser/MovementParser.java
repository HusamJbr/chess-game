package com.atypon.parser;
import com.atypon.board.Coordinates;
import java.util.StringTokenizer;

public class MovementParser {
    public enum Command {
        EMPTY,MOVE,DRAW
    }
    private Command command;
    private Coordinates from,to;
    private MovementParser(Command command, Coordinates from, Coordinates to){
        this.command = command;
        this.from = from;
        this.to = to;
    }

    public static MovementParser parseString(String move) {
        if(move == null)
            throw new IllegalArgumentException();
        StringTokenizer stringTokenizer = new StringTokenizer(move," ");
        return new MovementParser(handleCommand(stringTokenizer), handleSpots(stringTokenizer), handleSpots(stringTokenizer));
    }

    private static Coordinates handleSpots(StringTokenizer input){
        if(!input.hasMoreTokens())
            return new Coordinates(Coordinates.EMPTY,Coordinates.EMPTY);
        String start = input.nextToken();
        if(start.length() != 2)
            return new Coordinates(Coordinates.EMPTY,Coordinates.EMPTY);
        int x = (start.charAt(1)-'0')-1;
        int y = start.charAt(0)-'A';
        return new Coordinates(x,y);
    }
    private static Command handleCommand(StringTokenizer input){
        if(!input.hasMoreTokens())
            return Command.EMPTY;
        String command = input.nextToken();
        switch (command){
            case "move":
                return Command.MOVE;
            case "draw":
                return Command.DRAW;
            default:
                return Command.EMPTY;
        }
    }

    public boolean hasCommand(){
        return (command != Command.EMPTY);
    }
    public boolean hasFrom(){
        return (!from.isEmpty());
    }

    public boolean hasTo(){
        return (!to.isEmpty());
    }

    public Command getCommand() {
        return command;
    }

    public Coordinates getFrom() {
        return from;
    }

    public Coordinates getTo() {
        return to;
    }

}
