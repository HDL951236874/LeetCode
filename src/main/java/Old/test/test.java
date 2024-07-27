package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class test {
    public void test(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,2);

        map.put(1,1);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x->map.put(x.getKey(),x.getValue()));
        System.out.println(1);
    }

    public static void main(String[] args) {
        test test = new test();
        test.test();
    }
}
