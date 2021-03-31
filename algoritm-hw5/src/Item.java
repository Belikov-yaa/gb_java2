public class Item {
        public String name;

        public double weight;
        public double price;

        public Item(String name, double weight, double price)
        {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

    @Override
    public String toString() {
        return "{" +
                 name +
                ", вес=" + weight +
                ", цена=" + price +
                '}';
    }
}
