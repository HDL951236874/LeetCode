package Old.ArrayList;

import java.net.Inet4Address;
import java.util.*;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            for(int j = i;j<intervals.length;j++){
                if (intervals[j][0]<intervals[i][0]){
                    int[] temp = new int[2];
                    temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
        res.add(intervals[0]);
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]<=res.get(res.size()-1)[1]){
                res.get(res.size()-1)[1] = Math.max(intervals[i][1],res.get(res.size()-1)[1]);
            }else {
                res.add(intervals[i]);
            }
        }
        int[][] finalres = res.toArray(new int[0][0]);
        return finalres;
    }

    public static void main(String[] args) {
        Problem56 p = new Problem56();
        int[][] res = p.merge(new int[][]{{2,3},{2,2}});
        System.out.println(1);
    }
}
