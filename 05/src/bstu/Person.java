package bstu;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Person extends  Thread{
    Queue<Entrance> queue = new LinkedList<>();
    String personName;
    int maxWaitingTime, waitingTime;

    public Person(String name, Entrance door1, Entrance door2) {
        this.personName = name;
        int possibility = (int)(Math.random()*100);
        if(possibility >= 50) {
            queue.offer(door1);
            queue.offer(door2);
        }
        else {
            queue.offer(door2);
            queue.offer(door1);
        }
        this.maxWaitingTime = (int)(Math.random()*4000);
        this.waitingTime = 0;
    }

    @Override
    public void run()
    {
        while(true)
        {
            long t1 = System.currentTimeMillis();
            try
            {
                if (queue.peek().entrance.tryAcquire(maxWaitingTime, TimeUnit.MILLISECONDS))
                {
                    //System.out.println("В очереди в " + queue.peek().entranceName + " " + queue.size() + " человек(а)");
                    System.out.println(personName + " --> " + queue.peek().entranceName);
                    //sleep((int) (Math.random() * 5000));
                    sleep(800);
                    queue.peek().entrance.release();
                    break;
                }
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            long t2 = System.currentTimeMillis();
            System.out.println(personName + " (лимит: " + maxWaitingTime + ", прождал: " + (double)(t2 - t1) + ") не дождался своей очереди " + queue.peek().entranceName);
            ChangeDoor();
        }

    }
    public void ChangeDoor()
    {
        queue.offer(queue.poll());
    }
}
