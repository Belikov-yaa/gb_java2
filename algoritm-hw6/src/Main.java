import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");

//        System.out.println(map.minKey());
//        System.out.println(map.maxKey());

//        System.out.println(map.get(3));
//        map.put(3, "tttrrreee");
//        System.out.println(map.get(3));
//
//        map.deleteMin();

        map.delele(2);
        map.delele(1);
//        System.out.println(map.get(4));

        System.out.println(map);

    }
}
