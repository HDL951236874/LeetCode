package ukg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question11 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length-i){
                return citations.length-i;
            }
        }
        return 0;
    }
}
