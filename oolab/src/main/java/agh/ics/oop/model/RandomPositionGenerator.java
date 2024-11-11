package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final ArrayList<Vector2d> positions;
    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        positions = new ArrayList<>();
        for  (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        randomizedArray(positions);
        if (positions.size() > grassCount) {
            positions.subList(grassCount, positions.size()).clear();
        }
    }
    private void randomizedArray(ArrayList<Vector2d> arr) {
        Random r = new Random();
        for (int i = arr.size() - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Vector2d temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }
    @Override
    public Iterator<Vector2d> iterator() {
        return positions.iterator();
    }
}
