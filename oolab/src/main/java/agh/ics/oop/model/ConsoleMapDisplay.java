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
        System.out.println(String.format("Mapa: %s", worldMap.getId()));
        System.out.println(String.format("Ruch: %s", message));
        System.out.println(String.format("Stan mapy:\n%s", map.toString()));
        System.out.println(String.format("Ilosc zmian: %d", updateCount));
        System.out.println("==================");
    }

}
