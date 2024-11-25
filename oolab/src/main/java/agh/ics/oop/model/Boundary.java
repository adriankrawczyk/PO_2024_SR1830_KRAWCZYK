package agh.ics.oop.model;

public class Boundary {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public Boundary(Vector2d lowerLeft, Vector2d upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }
    public Vector2d getLowerLeft() {
        return lowerLeft;
    }
    public Vector2d getUpperRight() {
        return upperRight;
    }
}
