package agh.ics.oop;
import java.util.*;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {
    public static void main(String[] args){
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
    }
    public static void run(String[] args){
        List<MoveDirection> moves = OptionsParser.parse(args);

        for(MoveDirection move : moves){
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD ->  System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak skreca w prawo");
                case RIGHT ->  System.out.println("Zwierzak skreca w lewo");
            };
        }
    }
}
