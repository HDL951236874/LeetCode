package ukg;

import java.util.*;

public class Question12 {
    class RandomizedSet {
        Set<Integer> set;
        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            return set.add(val);
        }

        public boolean remove(int val) {
            return set.remove(val);
        }

        public int getRandom() {
            int i = new Random().nextInt(set.size());
            int c = 0;
            for(int num : set){
                if(c == i){
                    return num;
                }
                c++;
            }
            return 0;
        }
    }
    /**
     * On the same time you can also you the ArrayList and a map to work as a set.
     * The Map is used to record the element and the corresponding position.
     * The ArrayList is only used to record the element. The reason why we just the ArrayList is that
     * This data structure is simple for the random withdraw.
     * */
    class RandomizedSet1 {
        Map<Integer, Integer> map;
        List<Integer> list;
        public RandomizedSet1() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }
    }
}
