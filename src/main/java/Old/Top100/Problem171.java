package Top100;

import java.util.HashMap;
import java.util.Map;

public class Problem171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        Map<Character,Integer> map = new HashMap(){{
            put('A',1);
            put('B',2);
            put('C',3);
            put('D',4);
            put('E',5);
            put('F',6);
            put('G',7);
            put('H',8);
            put('I',9);
            put('J',10);
            put('K',11);
            put('L',12);
            put('M',13);
            put('N',14);
            put('O',15);
            put('P',16);
            put('Q',17);
            put('R',18);
            put('S',19);
            put('T',20);
            put('U',21);
            put('V',22);
            put('W',23);
            put('X',24);
            put('Y',25);
            put('Z',26);
        }};

        for (int i = 0; i < columnTitle.length(); i++) {
            int mi = columnTitle.length()-i-1;
            sum += map.get(columnTitle.charAt(i))*Math.pow(26,mi);
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem171 p = new Problem171();
        System.out.println(p.titleToNumber("A"));
    }

}
