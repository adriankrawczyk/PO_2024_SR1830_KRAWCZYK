package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
        public static MoveDirection[] parse(String[] args) {
            String[] argsFormatted = String.join( " ", args ).split("[, ]");
            MoveDirection[] md = new MoveDirection[argsFormatted.length];
                for (int i = 0; i<argsFormatted.length; i++){
                    switch (argsFormatted[i]) {
                        case "f" -> md[i] = MoveDirection.FORWARD;
                        case "b" -> md[i] = MoveDirection.BACKWARD;
                        case "r" -> md[i] = MoveDirection.RIGHT;
                        case "l" -> md[i] = MoveDirection.LEFT;
                        default -> {}
                    }
                }


            return md;
        }
}
