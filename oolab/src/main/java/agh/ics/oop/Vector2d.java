package agh.ics.oop;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    public boolean precedes(Vector2d other){
        return x <= other.x && y <= other.y;
    }
    public boolean follows(Vector2d other){
        return x >= other.x && y >= other.y;
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }
    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(other.x, x), Math.max(other.y, y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(other.x, x), Math.min(other.y, y));
    }
    public Vector2d opposite(Vector2d other) {
        return new Vector2d(-other.x, -other.y);
    }
    public boolean equals(Object other){
        Vector2d otherVector = (Vector2d) other;
        return x == otherVector.x && y == otherVector.y;
    }
}
