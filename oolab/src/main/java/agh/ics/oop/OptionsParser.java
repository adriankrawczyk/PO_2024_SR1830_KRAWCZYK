package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;

public class OptionsParser {
        public static ArrayList<MoveDirection> parse(String[] args) {
            String[] argsFormatted = String.join( " ", args ).split("[, ]");
            ArrayList<MoveDirection> md = new ArrayList<>();
            for (String arg: argsFormatted){
                switch (arg) {
                    case "f" -> md.add(MoveDirection.FORWARD);
                    case "b" -> md.add(MoveDirection.BACKWARD);
                    case "r" -> md.add(MoveDirection.RIGHT);
                    case "l" -> md.add(MoveDirection.LEFT);
                    default -> throw new IllegalArgumentException(arg + " nie jest odpowiednim ruchem zwierzęcia");
                    }
                }
            return md;
        }
}
