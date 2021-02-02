import fruits.Apple;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruits(5, Apple::new);
        appleBox.addFruit(new Apple());

        System.out.println(appleBox);

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruits(3, Apple::new);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruits(4, Orange::new);

        System.out.println(orangeBox.compareBox(appleBox));
        System.out.println(appleBox.compareBox(appleBox1));

        appleBox.moveAllFruits(appleBox1);

        System.out.println(appleBox);
        System.out.println(appleBox1);
    }

    public static <T> boolean swap(T[] arr, int i, int j) {
        if (i != j && i < arr.length && j < arr.length && i >= 0 && j >= 0) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return true;
        }
        return false;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
