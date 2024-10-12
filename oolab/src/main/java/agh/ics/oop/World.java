package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
public class World {
    public static void main(String[] args){
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
    }
    public static void run(String[] args){
        MoveDirection[] moves = OptionsParser.parse(args);

        for(MoveDirection move : moves){
            if(move == null) continue;
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD ->  System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak skreca w prawo");
                case RIGHT ->  System.out.println("Zwierzak skreca w lewo");
                default -> {}
            };
        }
    }
}
