package agh.ics.oop;

import java.util.*;
import agh.ics.oop.model.*;

public class World {
    public static void main(String[] args) throws IncorrectPositionException {
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        ArrayList<Simulation> simulations = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            AbstractWorldMap abstractWorldMap = new AbstractWorldMap(i);
            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay(abstractWorldMap);
            abstractWorldMap.addObserver(consoleMapDisplay);
            Simulation simulation = new Simulation(positions, directions, abstractWorldMap);
            simulations.add(simulation);
        }
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsync();
        simulationEngine.awaitSimulationsEnd();
    }
}
