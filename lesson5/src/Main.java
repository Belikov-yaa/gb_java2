import java.util.Arrays;

public class Main {
    static final int size = 10000000;
//    static final int size = 20;
    static final int threatCount = 5; // количество нитей
    static final int h = size / threatCount;

    static float[] arr = new float[size];
    static float[] arr2 = new float[size];

    public static void main(String[] args) {
        Arrays.fill(arr, 1);
        Arrays.fill(arr2, 1);
        long a = System.currentTimeMillis();
        // выполняем в одной нитью
        calcArrItems(arr, 0, arr.length);
        System.out.printf("Время выполнения в одном потоке: %d мс\n", (System.currentTimeMillis() - a));

        // выполняем в нескольких нитях
        a = System.currentTimeMillis();
        Thread[] threatsArr = new Thread[threatCount];
        for (int i = 0; i < threatCount; i++) {
            int startI = i * h;
            int endI = i + 1 == threatCount ? size : (i + 1) * h;
            threatsArr[i] = new Thread(new Mythreat(arr2, startI, endI));
            threatsArr[i].start();
        }

        for (Thread threat : threatsArr) {
            try {
                threat.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Время выполнения в %d потоках: %d мс\n", threatCount, (System.currentTimeMillis() - a));

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));
    }

    public static void calcArrItems(float[] arr, int i, int length) {
        for (int j = i; j < length; j++) {
            arr[j] = (float) (arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }

    static class Mythreat implements Runnable {
        private final int startIndex;
        private final int endIndex;
        public float[] arr;

        public Mythreat(float[] array, int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.arr = array;
        }

        @Override
        public void run() {
            calcArrItems(arr, startIndex, endIndex);
        }
    }
}