package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.Arrays;

public class OptionsParser {
        public static MoveDirection[] parse(String[] args) {
            String[] argsFormatted = String.join( " ", args ).split("[, ]");
            MoveDirection[] md = new MoveDirection[argsFormatted.length];
            int i = 0;
            for (String arg: argsFormatted){
                switch (arg) {
                    case "f" -> md[i] = MoveDirection.FORWARD;
                    case "b" -> md[i] = MoveDirection.BACKWARD;
                    case "r" -> md[i] = MoveDirection.RIGHT;
                    case "l" -> md[i] = MoveDirection.LEFT;
                    default -> i--;
                    }
                    i++;
                }
            return Arrays.copyOfRange(md, 0, i);
        }
}
