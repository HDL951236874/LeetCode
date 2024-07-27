package Old.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] finalRes = new int[1][2];
            finalRes[0] = newInterval;
            return finalRes;
        }
        int l = newInterval[0];
        int r = newInterval[1];
        int finalIndex = -1;
        List<int[]> res = new ArrayList<>();
        for(int i =0;i<intervals.length;i++){
            if( i == intervals.length-1){
                if(l>intervals[i][1]){
                    res.add(intervals[i]);
                    res.add(new int[]{l,r});
                    finalIndex = i;
                    break;
                }else if(r<intervals[i][0]){
                    res.add(new int[]{l,r});
                    res.add(intervals[i]);
                    finalIndex = i;
                    break;
                }
                r = Math.max(r,intervals[i][1]);
                l = Math.min(l,intervals[i][0]);
                res.add(new int[]{l,r});
                finalIndex = i;
                break;
            }
            if(i == 0 && r< intervals[i][0]){
                res.add(new int[]{l,r});
                finalIndex = i-1;
                break;
            }
            if(l>intervals[i+1][0]){
                res.add(intervals[i]);
            }else if(l<=intervals[i][1] && l>=intervals[i][0]){
                l= intervals[i][0];
            }else if(l<intervals[i+1][0] && l>intervals[i][1]){
                res.add(intervals[i]);
            }
            if(intervals[i][0]>r){
                res.add(intervals[i]);
            }else if(r>=intervals[i][0] && r<=intervals[i][1]){
                r = intervals[i][1];
                res.add(new int[]{l,r});
                finalIndex = i;
                break;
            }else if(r>intervals[i][1]&&r<intervals[i+1][0]){
                res.add(new int[]{l,r});
                finalIndex = i;
                break;
            }
        }
        for (int i = finalIndex+1;i<intervals.length;i++){
            res.add(intervals[i]);
        }
        int[][] finalRes = new int[res.size()][2];
        for(int i =0;i<res.size();i++){
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    public static void main(String[] args) {
        Problem57 p = new Problem57();
        int[][] intervals = new int[3][2];
        intervals[0] = new int[]{0,3};
        intervals[1] = new int[]{5,8};
        intervals[2] = new int[]{9,11};
        int[] insert_array = new int[]{9,18};
        int[][] res = p.insert(intervals,insert_array);
        System.out.println(1);
    }
}
