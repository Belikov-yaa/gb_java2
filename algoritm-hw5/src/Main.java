import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(recExponentiation(2,8));

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Карта", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Компас", 2, 1000));
        items.add(new Item("Котелок", 1, 500));

        BackPack backPack = new BackPack(7.0);
        backPack.makeAllSets(items);
        backPack.getBestItems().forEach(System.out::print);
    }

    public static long recExponentiation(int base, int exp) {
        if (exp == 1) return base;
        return base * recExponentiation(base, exp - 1);
    }
}
