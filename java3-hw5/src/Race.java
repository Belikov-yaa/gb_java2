import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Race {
    private ArrayList<Stage> stages;

    public AtomicBoolean isWinnerFound = new AtomicBoolean(false);
    public CyclicBarrier cb;
    public CountDownLatch countDownLatch;

    public void setCountDown(int countDown) {
        this.cb = new CyclicBarrier(countDown);
        this.countDownLatch = new CountDownLatch(countDown);
    }

    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}