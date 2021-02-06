import fruits.Fruit;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruits(int count, Supplier<? extends T> ctor) {
        for (int i = 0; i < count; i++) {
            this.fruits.add(ctor.get());
        }
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double weight = 0.0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void moveAllFruits(Box<T> newBox) {
        if (this!=newBox) {
            newBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }

    public boolean compareBox(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0000001;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
