package Old.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem6064 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        if(special.length == 1){
            return Math.max(special[0]-bottom,top-special[special.length-1]);
        }
        int[] list = new int[special.length-1];
        for (int i = 0; i < special.length-1; i++) {
            list[i] = (special[i+1]-special[i]-1);
        }
        int max = Arrays.stream(list).max().getAsInt();
        return Math.max(max,Math.max(special[0]-bottom,top- special[special.length-1]));
    }
}
