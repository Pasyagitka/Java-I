package Road;
import java.util.concurrent.CyclicBarrier;

public class Main {
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new Done());
    final static int COUNT_OF_CARS = 9;
    //Инициализируем барьер на три потока и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT_OF_CARS; i++) {
            if (i  == 0 || i== 1 || i==2 || i  == 6 || i== 7 || i==8  ) {
                new Thread(new Car(i, "слева")).start();
                Thread.sleep(400);
            }
            else {
                new Thread(new Car(i, "справа")).start();
                Thread.sleep(400);
            }
        }
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class Done implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Автомобили проехали по участку дороги");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private int carNumber;
        private String carName;


        public Car(int carNumber, String carName) {
            this.carNumber = carNumber;
            this.carName = carName;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль %d подъехал %s \n", carNumber, carName);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль %d (%s) продолжил движение по дороге\n", carNumber, carName);
            } catch (Exception e) {
            }
        }
    }
}