package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    void MoveDirection(){
        String[] args = {"f", "f", "b", "b"};

        MoveDirection[] move = { MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD };
        MoveDirection[] parsed = OptionsParser.parse(args);
        for(int i = 0; i < move.length; i++) {
            assertEquals(parsed[i], move[i]);
        }

        String[] args2 = {"f", "f", "c", "asd", "b", "b"};
        MoveDirection[] move2 = { MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD };
        MoveDirection[] parsed2 = OptionsParser.parse(args2);
        for(int i = 0; i < move2.length; i++) {
            assertEquals(parsed2[i], move2[i]);
        }
    }
}
