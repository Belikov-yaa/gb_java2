package fruits;

public abstract class Fruit {
    private double weight;

    public Fruit() {
        this.weight = 0.5;
    }

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
