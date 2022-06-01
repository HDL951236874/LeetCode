package Inorder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem346 {
    class MovingAverage {
        List<Integer> queue;
        int size;
        public MovingAverage(int size) {
            this.queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            queue.add(val);
            if(queue.size()>3) queue.remove(0);
            int res = 0;
            for (int i = 0; i < queue.size(); i++) {
                res += queue.get(i);
            }
            return res/queue.size();
        }
    }
}
