package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem202 {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int res = n;
        while (res != 1) {
            int temp = 0;
            while (res != 0) {
                temp += Math.pow(res % 10, 2);
                res /= 10;
            }
            if(!list.contains(temp)){
                list.add(temp);
            }
            else return false;
            res = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem202 p = new Problem202();
        System.out.println(p.isHappy(19));
    }
}
