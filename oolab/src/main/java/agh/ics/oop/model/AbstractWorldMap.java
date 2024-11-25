package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.WorldElement;
import agh.ics.oop.model.util.WorldMap;

import java.util.HashMap;


public class AbstractWorldMap implements WorldMap {

    private final HashMap<Vector2d, Animal> animals = new HashMap<>();
    private HashMap<Vector2d, Grass> grasses = new HashMap<>();
    private final MapVisualizer visualizer = new MapVisualizer(this);
    public String toString(){
        return visualizer.draw(getBoundary().getLowerLeft(), getBoundary().getUpperRight());
    }
    public void setGrasses(HashMap<Vector2d, Grass> grasses){
        this.grasses = grasses;
    }
    public HashMap<Vector2d, Grass> getGrasses(){
        return grasses;
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        if(this.place(animal))
            animals.remove(oldPosition);
    }

    @Override
    public WorldElement objectAt(Vector2d position){
        if(animals.get(position) != null) return animals.get(position);
        if(grasses.get(position) != null) return grasses.get(position);
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.isInBounds(getBoundary().getLowerLeft(), getBoundary().getUpperRight()) && !isOccupied(position);
    }

    public <T> boolean placeObject(T object, HashMap<Vector2d, T> map) {
        try {
            WorldElement worldElement = (WorldElement) object;
            Vector2d position = worldElement.getPosition();
            if (!canMoveTo(position)) {
                throw new IncorrectPositionException(position);
            }
            map.put(position, object);
            return true;
        } catch (IncorrectPositionException e) {
            return false;
        }
    }
    @Override
    public boolean place(Animal animal) {
        return placeObject(animal, animals);
    }

    public boolean place(Grass grass) {
        return placeObject(grass, grasses);
    }


    public HashMap<Vector2d, WorldElement> getElements() {
        return new HashMap<Vector2d, WorldElement>() {{ putAll(animals); putAll(grasses); }};
    }
    public Boundary getBoundary() {
        int[] bounds = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (Vector2d pos : animals.keySet()) updateBounds(bounds, pos);
        for (Vector2d pos : grasses.keySet()) updateBounds(bounds, pos);

        return new Boundary(
                new Vector2d(bounds[0], bounds[1]),
                new Vector2d(bounds[2], bounds[3])
        );
    }

    private void updateBounds(int[] b, Vector2d pos) {
        b[0] = Math.min(b[0], pos.getX());
        b[1] = Math.min(b[1], pos.getY());
        b[2] = Math.max(b[2], pos.getX());
        b[3] = Math.max(b[3], pos.getY());
    }

}
