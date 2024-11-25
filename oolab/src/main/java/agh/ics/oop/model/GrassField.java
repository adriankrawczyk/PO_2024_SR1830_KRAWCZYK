package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.WorldMap;

import java.util.HashMap;

public class GrassField {
    private final HashMap<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassCount){
        int corner = (int) Math.sqrt(grassCount*10);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(corner, corner, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) {
          grasses.put(grassPosition, new Grass(grassPosition));
        }
    }
    public HashMap<Vector2d, Grass> getGrasses(){
        return grasses;
    }


}
