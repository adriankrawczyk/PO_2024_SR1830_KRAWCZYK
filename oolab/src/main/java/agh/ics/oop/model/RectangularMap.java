package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.WorldMap;
    public class RectangularMap extends AbstractWorldMap implements WorldMap  {
    private final int width;
    private final int height;
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
