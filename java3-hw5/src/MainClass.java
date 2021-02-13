import java.util.concurrent.*;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    public static CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            executorService.execute(car);
//            new Thread(car).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        executorService.shutdown();
        while (!executorService.isTerminated());

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
