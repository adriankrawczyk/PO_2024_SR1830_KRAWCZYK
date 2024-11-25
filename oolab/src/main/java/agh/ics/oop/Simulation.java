package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private ArrayList<MoveDirection> directions = new ArrayList<>();
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final AbstractWorldMap abstractWorldMap;
    public Simulation(ArrayList<Vector2d> positions, ArrayList<MoveDirection> directions, AbstractWorldMap abstractWorldMap) throws IncorrectPositionException {
        this.abstractWorldMap = abstractWorldMap;
        abstractWorldMap.setGrasses(new GrassField(10).getGrasses());
        for (HashMap.Entry<Vector2d, Grass> entry : abstractWorldMap.getGrasses().entrySet()) {
            abstractWorldMap.place(entry.getValue());
        }

        for(Vector2d position : positions){
            Animal animal = new Animal(position);
            if (abstractWorldMap.place(animal)) {
                animals.add(animal);
            }
        }
        this.directions = directions;
    }
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            abstractWorldMap.move(animals.get(i % animals.size()), directions.get(i));
            System.out.println(abstractWorldMap);
        }
    }
}
