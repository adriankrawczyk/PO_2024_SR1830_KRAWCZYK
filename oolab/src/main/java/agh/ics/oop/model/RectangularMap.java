package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.WorldMap;
    public class RectangularMap extends AbstractWorldMap implements WorldMap  {
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
}
