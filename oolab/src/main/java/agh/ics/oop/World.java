package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
public class World {
    public static void main(String[] args){
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
    public static void run(String[] args){
        MoveDirection[] moves = OptionsParser.parse(args);

        for(MoveDirection move : moves){
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD ->  System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak skreca w prawo");
                case RIGHT ->  System.out.println("Zwierzak skreca w lewo");
            };
        }
    }
}
