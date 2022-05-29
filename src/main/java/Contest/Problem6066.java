package Contest;

import java.util.LinkedList;
import java.util.List;

public class Problem6066 {
    static class CountIntervals {
        List<int[]> list;

        public CountIntervals() {
            this.list = new LinkedList<>();
        }

        public void add(int left, int right) {
            List<int[]> temp = new LinkedList<>();
            int[] insertion = new int[]{left, right};
            if (list.size() == 0) {
                this.list.add(insertion);
                return;
            }
            if (insertion[1] < list.get(0)[0]) {
                this.list.add(0, insertion);
                return;
            }
            if (insertion[0] > list.get(list.size() - 1)[1]) {
                this.list.add(list.size(), insertion);
                return;
            }
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i)[1] < insertion[0]) {
                    temp.add(list.get(i));
                } else if (list.get(i)[1] >= insertion[0] && list.get(i)[0] <= insertion[0]) {
                    insertion[0] = list.get(i)[0];
                } else if (list.get(i)[0] <= insertion[1] && list.get(i)[1] >= insertion[1]) {
                    insertion[1] = list.get(i)[1];
                } else if (list.get(i)[0] > right) {
                    temp.add(insertion);
                    temp.add(list.get(i));
                } else if(list.get(i)[0]<=insertion[0]&&list.get(i)[1]>=insertion[1]){
                    temp.add(list.get(i));
                }
                if (i == list.size() - 1) {
                    temp.add(insertion);
                }
            }
            this.list = temp;
        }

        public int count() {
            int sum = 0;
            for (int i = 0; i < this.list.size(); i++) {
                sum += (this.list.get(i)[1] - this.list.get(i)[0] + 1);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(8, 43);
        countIntervals.add(13, 16);
        System.out.println(countIntervals.count());
        countIntervals.add(47, 50);
        System.out.println(countIntervals.count());
    }
}
