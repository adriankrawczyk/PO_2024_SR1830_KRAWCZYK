package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;

public class Simulation {
    private ArrayList<MoveDirection> directions = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    public Simulation(ArrayList<Vector2d> positions, ArrayList<MoveDirection> directions){
        for(Vector2d position : positions){
            animals.add(new Animal(position));
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
            System.out.printf("Zwierze %d %s %n", i, animal.toString());
            animal.move(direction);
            i++;
            if(len == i) i = 0;
        }
    }
}
