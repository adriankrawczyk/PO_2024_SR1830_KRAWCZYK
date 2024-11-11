package agh.ics.oop;
import java.util.*;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args){
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        AbstractWorldMap abstractWorldMap = new AbstractWorldMap();
        Simulation simulation = new Simulation(positions, directions, abstractWorldMap);
        simulation.run();
    }
}
