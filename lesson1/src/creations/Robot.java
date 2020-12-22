package creations;

import creations.Jumpable;

public class Robot implements Runnable, Jumpable {
    int maxHeight;
    int maxLength;

    public Robot(int maxHeight, int maxLength) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }

    @Override
    public boolean isJumpingOver(int height) {
        if (height <= maxHeight) {
            System.out.println("Робот перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть препятствие");
            return false;
        }
    }

    @Override
    public void run() {
        System.out.println("Робот бежит");
    }

    @Override
    public boolean isRunning(int wayLength) {
        if (wayLength <= maxLength) {
            System.out.println("Робот пробежал препятствие");
            return true;
        } else {
            System.out.println("Робот не смог пробежать препятствие");
            return false;
        }
    }

}
