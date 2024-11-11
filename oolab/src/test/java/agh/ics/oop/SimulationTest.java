package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {
    @Test
    public void rightDirection(){
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(1, 1)));
        ArrayList<MoveDirection> directions = OptionsParser.parse(new String[]{"l", "r", "l", "r", "l"});
        AbstractWorldMap abstractWorldMap = new AbstractWorldMap();
        Simulation simulation = new Simulation(positions, directions,abstractWorldMap);

        simulation.run();
        ArrayList<Animal> animals = simulation.getAnimals();

        assertSame(animals.get(0).getDirection(), MapDirection.EAST);
        assertSame(animals.get(1).getDirection(), MapDirection.SOUTH);
    }


    @Test
    public void rightPosition(){
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(0, 0), new Vector2d(4, 4)));
        ArrayList<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f"});
        AbstractWorldMap abstractWorldMap = new AbstractWorldMap();
        Simulation simulation = new Simulation(positions, directions,abstractWorldMap);

        simulation.run();
        ArrayList<Animal> animals = simulation.getAnimals();

        assertEquals(animals.get(0).getPosition(), new Vector2d(1, 1));
        assertEquals(animals.get(1).getPosition(), new Vector2d(3, 3));
    }

    @Test
    public void mapCorner(){
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(0, 0), new Vector2d(4, 4)));
        ArrayList<MoveDirection> directions = OptionsParser.parse(new String[]{"b", "f", "b", "f"});
        AbstractWorldMap abstractWorldMap = new AbstractWorldMap();
        Simulation simulation = new Simulation(positions, directions,abstractWorldMap);


        simulation.run();
        ArrayList<Animal> animals = simulation.getAnimals();
        assertEquals(animals.get(0).getPosition(), new Vector2d(0, 0));
        assertEquals(animals.get(1).getPosition(), new Vector2d(4, 4));
    }

}
