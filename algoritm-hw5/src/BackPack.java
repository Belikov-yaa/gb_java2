import java.util.ArrayList;

public class BackPack {

    private ArrayList<Item> bestItems = null;
    private double maxWeight;
    private double bestPrice;

    public BackPack(double maxW) {
        this.maxWeight = maxW;
    }

    //вычисляет общий вес набора предметов
    private double calcWeight(ArrayList<Item> items) {
        double sumW = 0;
        for (Item i : items) {
            sumW += i.weight;
        }
        return sumW;
    }

    //вычисляет общую стоимость набора предметов
    private double calcPrice(ArrayList<Item> items) {
        double sumPrice = 0;
        for (Item i : items) {
            sumPrice += i.price;
        }
        return sumPrice;
    }

    //проверка, является ли данный набор лучшим решением задачи
    private void checkSet(ArrayList<Item> items) {
        if (bestItems == null) {
            if (calcWeight(items) <= maxWeight) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
            bestItems = items;
            bestPrice = calcPrice(items);
        }
    }

    //создание всех наборов перестановок значений путем поочереного рекурсивного удаления из стартового набора предметов
    public void makeAllSets(ArrayList<Item> items) {
        if (items.size() > 0)
            checkSet(items);

        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    //возвращает решение задачи (набор предметов)
    public ArrayList<Item> getBestItems() {
        return bestItems;
    }
}
