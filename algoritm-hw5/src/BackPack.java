import java.util.ArrayList;

public class BackPack {

    private ArrayList<Item> bestItems = null;

    private double maxW;

    private double bestPrice;

    public BackPack(double maxW) {
        this.maxW = maxW;
    }

    //вычисляет общий вес набора предметов
    private double CalcWeigth(ArrayList<Item> items)
    {
        double sumW = 0;

        for (Item i : items)
        {
            sumW += i.weigth;
        }

        return sumW;
    }

    //вычисляет общую стоимость набора предметов
    private double CalcPrice(ArrayList<Item> items)
    {
        double sumPrice = 0;

        for (Item i : items)
        {
            sumPrice += i.price;
        }

        return sumPrice;
    }
}
