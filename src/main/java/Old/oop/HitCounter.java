package oop;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    List<Integer> list = new ArrayList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > timestamp - 300) {
                return list.size() - i ;
            }
        }
        return 0;
    }
}
