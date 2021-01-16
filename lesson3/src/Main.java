import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"палка", "кегля", "сахар", "лужа", "ворона", "палка", "стакан",
                "вечер", "лужа", "карета", "кегля", "кегля", "стакан"};
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words) {
            int freq = mapWords.getOrDefault(word, 0);
            mapWords.put(word, ++freq);
        }

        System.out.println(mapWords);

        PhoneList phoneList = new PhoneList();
        phoneList.add("Иванов", "+79234567890");
        phoneList.add("Петров", "+79455671892");
        phoneList.add("Сидоров", "+79235123891");
        phoneList.add("Иванов", "+79224567874");
        phoneList.add("Петров", "+79214567846");

        System.out.println(phoneList.get("Иванов"));
        System.out.println(phoneList.get("Петров"));
        System.out.println(phoneList);
    }
}
