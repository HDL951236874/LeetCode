package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {
    public List<String> letterCombinations(String digits) {
        //this is the letter combination of a phone number
        Map<Character,String[]> map = new HashMap<>();
        map.put('2', new String[]{"a","b","c"});
        map.put('3', new String[]{"d","e","f"});
        map.put('4', new String[]{"g","h","i"});
        map.put('5', new String[]{"j","k","l"});
        map.put('6', new String[]{"m","n","o"});
        map.put('7', new String[]{"p","q","r","s"});
        map.put('8', new String[]{"t","u","v"});
        map.put('9', new String[]{"w","x","y","z"});
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            if(res.isEmpty()){
                for (String c : map.get(digits.charAt(i))){
                    res.add(c);
                }
            }else {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < map.get(digits.charAt(i)).length; j++) {
                    for (int k = 0; k < res.size(); k++) {
                        temp.add(res.get(k)+map.get(digits.charAt(i))[j]);
                    }
                }
                res = new ArrayList<>(temp);
            }
        }
        return res;
    }
}
