package Old.HashTable;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap() {{
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }};
        String res = "";
        for (int i = String.valueOf(num).length() - 1; i >= 0; i--) {
            int facter = (int) Math.pow(10, i);
            int number = num / facter;
            num = num - facter * number;
            String temp = "";
            if (number == 4) {
                temp = map.get((int) Math.pow(10, i)) + map.get((int) Math.pow(10, i) * 5);
            }
            if (number == 9) {
                temp = map.get((int) Math.pow(10, i)) + map.get((int) Math.pow(10, i) * 10);
            }
            if (number < 4) {
                for (int j = 0; j < number; j++) {
                    temp += map.get((int) Math.pow(10, i));
                }
            }
            if (number < 9 && number > 4) {
                temp = map.get((int) Math.pow(10, i) * 5);
                for (int j = 0; j < number - 5; j++) {
                    temp += map.get((int) Math.pow(10, i));
                }
            }
            res += temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem13 h = new Problem13();
        System.out.println(h.intToRoman(100));
    }
}
