package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.WorldMap;

import java.util.HashMap;

    public class RectangularMap implements WorldMap {
    private final HashMap<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final MapVisualizer visualizer = new MapVisualizer(this);
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public String toString(){
        return visualizer.draw(new Vector2d(0,0), new Vector2d(width,height));
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        if(this.place(animal))
            animals.remove(oldPosition);
    }
    @Override
    public Animal objectAt(Vector2d position){
        if(animals.get(position) != null) return animals.get(position);
        return null;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.isInBounds() && !isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (!canMoveTo(animalPosition)) return false;
        animals.put(animalPosition, animal);
        return true;
    }

}
