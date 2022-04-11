package com.atypon.chess_game.validator;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovementParserTest {

    @Test
    public void testParse() {
        MovementParser movementParser = new MovementParser();
        movementParser.parse("move B8 C6");
        assertEquals(Command.MOVE, movementParser.getCommand());
        assertEquals(new Pair<>(1,7), movementParser.getFrom());
        assertEquals(new Pair<>(2,5), movementParser.getTo());
    }

    @Test
    public void testParse2() {
        MovementParser movementParser = new MovementParser();
        movementParser.parse("draw");
        assertEquals(Command.DRAW, movementParser.getCommand());
        assertEquals(false, movementParser.hasFrom());
        assertEquals(false, movementParser.hasTo());
    }

    @Test
    public void testParse3() {
        MovementParser movementParser = new MovementParser();
        movementParser.parse("move B C6");
        assertEquals(false, movementParser.hasCommand());
        assertEquals(false, movementParser.hasFrom());
        assertEquals(false, movementParser.hasTo());
    }
}