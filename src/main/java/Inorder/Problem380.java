package Inorder;

import java.util.*;

public class Problem380 {
    class RandomizedSet {
        Set<Integer> set;

        public RandomizedSet() {
            this.set = new HashSet<>();
        }

        public boolean insert(int val) {
            return this.set.add(val);
        }

        public boolean remove(int val) {
            return this.set.remove(val);
        }

        public int getRandom() {
            Random random = new Random();
            List<Integer> list = new ArrayList<>(this.set);
            int aim = random.nextInt(this.set.size());

            return list.get(aim);
        }
    }
}
