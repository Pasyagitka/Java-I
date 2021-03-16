package bstu;

import java.util.concurrent.Semaphore;

public class Entrance {
    Semaphore entrance;
    String entranceName;
    static int entranceId = 1;

    public Entrance(int capacity)
    {
        this.entranceName = "дверь " + Entrance.entranceId;
        this.entrance = new Semaphore(capacity);
        Entrance.entranceId++;
    }
}
