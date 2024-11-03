package agh.ics.oop.model;

import agh.ics.oop.model.util.MoveValidator;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;

    public Animal() {
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d position) {
        this.position = position;
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    public Vector2d getPosition() {
        return position;
    }
    public MapDirection getDirection() {
        return direction;
    }
    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }
    public void setPosition(Vector2d position) {
        this.position = position;
    }
    public String toString() {
        return this.getDirection().toString();
    }
    public boolean isAt(Vector2d other){
        return other.getX() == this.position.getX() && other.getY() == this.position.getY();
    }
    public void move(MoveDirection direction, MoveValidator moveValidator){
        Vector2d movedVector = this.position;
        switch (direction){
            case MoveDirection.RIGHT -> this.setDirection(this.direction.next());
            case MoveDirection.LEFT -> this.setDirection(this.direction.previous());
            case MoveDirection.FORWARD -> movedVector = this.position.add(this.direction.toUnitVector());
            case MoveDirection.BACKWARD -> movedVector = this.position.subtract(this.direction.toUnitVector());
        }
        if (moveValidator.canMoveTo(movedVector)) {
            this.setPosition(movedVector);
        }
    }
}
