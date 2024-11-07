package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {
    private ArrayList<MoveDirection> directions = new ArrayList<>();
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final RectangularMap rectangularMap;
    public Simulation(ArrayList<Vector2d> positions, ArrayList<MoveDirection> directions, RectangularMap rectangularMap){
        this.rectangularMap = rectangularMap;
        for(Vector2d position : positions){
            Animal animal = new Animal(position);
            if (rectangularMap.place(animal)) {
                animals.add(animal);
            }
        }
        this.directions = directions;
    }
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    public void run(){
        int len = animals.size();
        int i = 0;
        for(MoveDirection direction: directions){
            Animal animal = animals.get(i);
            rectangularMap.move(animal, direction);
            System.out.println(rectangularMap);
            i++;
            if(len == i) i = 0;
        }
    }
}
