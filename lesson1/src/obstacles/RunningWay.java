package obstacles;

import creations.Runnable;

public class RunningWay {
    int length;

    public RunningWay(int length) {
        this.length = length;
    }
    public boolean obstaclePass(Runnable obj) {
        obj.run();
        return obj.isRunning(length);
    }
}
