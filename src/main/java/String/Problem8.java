package String;

import java.util.ArrayList;
import java.util.List;

public class Problem8 {
    public int myAtoi(String s) {
        boolean min_flag =false;
        List<Integer> container = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-'){
                min_flag = true;
            }
            if(Character.isDigit(s.charAt(i))){
                container.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        return 1;
    }
}
