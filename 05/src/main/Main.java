package main;

import bstu.Entrance;
import bstu.Person;

public class Main {
    final static int COUNT_OF_STUDENTS = 18;
    final static int CAPACITY_DOOR_1 = 5;
    final static int CAPACITY_DOOR_2 = 3;

    public static void main(String[] args) {
        Entrance door1 = new Entrance(CAPACITY_DOOR_1);
        Entrance door2 = new Entrance(CAPACITY_DOOR_2);
        for (int i = 1; i <= COUNT_OF_STUDENTS; i++)
        {
            new Person("Человек " + i, door1, door2).start();
        }
    }
}
