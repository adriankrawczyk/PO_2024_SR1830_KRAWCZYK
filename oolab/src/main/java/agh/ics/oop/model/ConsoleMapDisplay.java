package agh.ics.oop.model;

import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.util.MapChangeListener;
import agh.ics.oop.model.util.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCount = 0;
    private final AbstractWorldMap map;

    public ConsoleMapDisplay(AbstractWorldMap map) {
        this.map = map;
    }
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCount++;
        System.out.println("Ruch: " + message);
        System.out.println("Stan mapy:\n" + map.toString());
        System.out.println("Ilosc zmian: " + updateCount);
        System.out.println("==================");
    }
}
