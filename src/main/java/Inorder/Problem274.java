package Inorder;

import java.util.*;
import java.util.stream.Collectors;

public class Problem274 {
    public int hIndex(int[] citations) {
        List<Integer> integerList = Arrays.stream(citations).boxed().collect(Collectors.toList());
        Collections.sort(integerList);
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i)>=integerList.size()-i){
                return integerList.size()-i;
            }
        }
        return 0;
    }
}
