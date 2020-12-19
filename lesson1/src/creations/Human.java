package creations;

public class Human implements Runnable, Jumpable {
    int maxHeight;
    int maxLength;

    public Human(int maxHeight, int maxLength) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
    }

    @Override
    public boolean isJumpingOver(int height) {
        if (height <= maxHeight) {
            System.out.println("Человек перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Человек не смог перепрыгнуть препятствие");
            return false;
        }
    }

    @Override
    public void run() {
        System.out.println("Человек бежит");
    }

    @Override
    public boolean isRunning(int wayLength) {
        if (wayLength <= maxLength) {
            System.out.println("Человек пробежал препятствие");
            return true;
        } else {
            System.out.println("Человек не смог пробежать препятствие");
            return false;
        }
    }

}
