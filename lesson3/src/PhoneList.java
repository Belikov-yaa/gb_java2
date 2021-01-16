import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneList {
    private Map<String, List<String>> phoneList;

    public PhoneList() {
        phoneList = new HashMap<>();
    }

    public void add(String name, String telNumber) {
        List<String> telList = new ArrayList<>();
        if (phoneList.containsKey(name)) {
            telList = phoneList.get(name);
        }
        if (!telList.contains(telNumber)) {
            telList.add(telNumber);
        }
        phoneList.put(name, telList);
    }

    public List<String> get(String name) {
        return phoneList.getOrDefault(name, null);
    }

    @Override
    public String toString() {
        return "PhoneList{" + phoneList +
                '}';
    }
}
