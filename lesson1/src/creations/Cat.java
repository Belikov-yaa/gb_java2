package creations;

public class Cat implements Runnable, Jumpable {
    int maxHeight;
    int maxLength;

    public Cat(int maxHeight, int maxLength) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает");
    }

    @Override
    public boolean isJumpingOver(int height) {
        if (height <= maxHeight) {
            System.out.println("Кот перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Кот не смог перепрыгнуть препятствие");
            return false;
        }
    }

    @Override
    public void run() {
        System.out.println("Кот бежит");
    }

    @Override
    public boolean isRunning(int wayLength) {
        if (wayLength <= maxLength) {
            System.out.println("Кот пробежал препятствие");
            return true;
        } else {
            System.out.println("Кот не смог пробежать препятствие");
            return false;
        }
    }
}
