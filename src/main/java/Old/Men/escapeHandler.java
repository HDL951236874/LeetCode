package Men;

import java.util.HashMap;
import java.util.Map;

public class escapeHandler {
    public void test() {
        //for primitive variable this not work
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(map);
        map2.put(1, 10);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

    public void test2() {
        HashMap<String,costumer> map = new HashMap<>();
        map.put("A",new costumer("A"));
        map.put("B",new costumer("B"));
        Map<String, costumer> map2 = new HashMap<>(map);
//        map2.put("B",new costumer("V"));
        costumer temp = map.get("B");
        temp.setName("V");
        map2.put("B",temp);
        System.out.println(map.get("B").getName());
//        System.out.println(map.get("A").hashCode());
//        System.out.println(map2.get("A").hashCode());
    }

    public static void main(String[] args) {
        escapeHandler escapeHandler = new escapeHandler();
        escapeHandler.test2();
    }
}


class costumer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public costumer(String name) {
        this.name = name;
    }
}