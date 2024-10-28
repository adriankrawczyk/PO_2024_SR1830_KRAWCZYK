package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equals(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = v1;
        Vector2d v3 = new Vector2d(1,2);

        assertEquals(v1,v2);
        assertEquals(v1,v3);
    }

    @Test
    void toStringTest(){
        Vector2d v1 = new Vector2d(1,2);
        String s1 = v1.toString();
        assertEquals(("(1,2)"), s1);
    }

    @Test
    void precedes(){
        Vector2d s = new Vector2d(1,1);
        assertTrue(s.precedes(new Vector2d(2,2)));
        assertTrue(s.precedes(new Vector2d(1,2)));
        assertTrue(s.precedes(new Vector2d(2,1)));
        assertFalse(s.precedes(new Vector2d(0,1)));
        assertFalse(s.precedes(new Vector2d(1,0)));
        assertFalse(s.precedes(new Vector2d(0,0)));
    }

    @Test
    void follows(){
        Vector2d s = new Vector2d(1,2);
        assertTrue(s.precedes(new Vector2d(2,2)));
        assertTrue(s.precedes(new Vector2d(1,2)));
        assertFalse(s.precedes(new Vector2d(2,1)));
        assertFalse(s.precedes(new Vector2d(0,1)));
        assertFalse(s.precedes(new Vector2d(1,0)));
        assertFalse(s.precedes(new Vector2d(0,0)));
    }

    @Test
    void upperRight(){
        Vector2d s = new Vector2d(1,2);
        assertEquals(s.upperRight(new Vector2d(5,5)), new Vector2d(5,5));
        assertEquals(s.upperRight(new Vector2d(0,0)), new Vector2d(1,2));
        assertEquals(s.upperRight(new Vector2d(0,5)), new Vector2d(1,5));
        assertEquals(s.upperRight(new Vector2d(5,1)), new Vector2d(5,2));
        assertEquals(s.upperRight(new Vector2d(1,2)), new Vector2d(1,2));
    }

    @Test
    void lowerLeft(){
        Vector2d s = new Vector2d(1,2);
        assertEquals(s.lowerLeft(new Vector2d(2,2)) , new Vector2d(1,2));
        assertEquals(s.lowerLeft(new Vector2d(1,2)) , new Vector2d(1,2));
        assertEquals(s.lowerLeft(new Vector2d(0,0)) , new Vector2d(0,0));
        assertEquals(s.lowerLeft(new Vector2d(3, 0)) , new Vector2d(1,0));
        assertEquals(s.lowerLeft(new Vector2d(0, 3)) , new Vector2d(0,2));
    }

    @Test
    void add(){
        Vector2d s = new Vector2d(1,2);
        Vector2d v = new Vector2d(1,2);
        assertEquals(s.add(v) , new Vector2d(2,4));
    }

    @Test
    void subtract(){
        Vector2d s = new Vector2d(1,2);
        Vector2d v = new Vector2d(1,2);
        assertEquals(s.subtract(v) , new Vector2d(0,0));
    }

    @Test
    void opposite(){
        Vector2d s = new Vector2d(1,2);
        assertEquals(s.opposite() , new Vector2d(-1,-2));
    }
}
