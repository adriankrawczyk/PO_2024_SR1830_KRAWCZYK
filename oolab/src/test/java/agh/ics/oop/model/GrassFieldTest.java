package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void grassCount() {
        int grassCount = 10;
        GrassField grassField = new GrassField(grassCount);
        assertEquals(grassCount, grassField.getGrasses().size());
    }

    @Test
    void positionWithinBounds() {
        int grassCount = 10;
        GrassField grassField = new GrassField(grassCount);
        int corner = (int) Math.sqrt(grassCount * 10);
        for (Vector2d position : grassField.getGrasses().keySet()) {
            assertTrue(position.getX() >= 0 && position.getX() < corner);
            assertTrue(position.getY() >= 0 && position.getY() < corner);
        }
    }

    @Test
    void uniqueGrassPositions() {
        int grassCount = 10;
        GrassField grassField = new GrassField(grassCount);
        HashSet<Vector2d> uniquePositions = new HashSet<>(grassField.getGrasses().keySet());
        assertEquals(grassCount, uniquePositions.size());
    }

    @Test
    void getGrasses() {
        int grassCount = 5;
        GrassField grassField = new GrassField(grassCount);
        Map<Vector2d, Grass> grasses = grassField.getGrasses();
        assertNotNull(grasses);
        assertEquals(grassCount, grasses.size());
    }
}
