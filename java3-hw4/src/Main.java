public class Main {
    private final Object lock = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main mainThread = new Main();

        Thread thread1 = new Thread(mainThread::printA);

        Thread thread2 = new Thread(mainThread::printB);

        Thread thread3 = new Thread(mainThread::printC);

        thread1.start();
        thread2.start();
        thread3.start();

    }

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        lock.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        lock.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        lock.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
