package Old.Contest;
import java.math.BigDecimal;

import java.util.*;

public class contest6076 {
    public int minimumLines(int[][] stockPrices) {
        if(stockPrices.length == 1) return 0;

        if(stockPrices.length<1000){
            quickSort(stockPrices,0,stockPrices.length-1);
            int res = 1;
            double xie = xielv(stockPrices[1], stockPrices[0]);
            for (int i = 2, len = stockPrices.length; i < len; i++) {
                double new_xie = xielv(stockPrices[i], stockPrices[i - 1]);
                if (BigDecimal.valueOf(new_xie ).subtract(BigDecimal.valueOf(xie)).equals(BigDecimal.valueOf(0))) {
                    res++;
                    xie = new_xie;
                }
            }
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stockPrices.length; i++) {
            map.put(stockPrices[i][0], stockPrices[i][1]);
        }
        int min = Collections.min(map.keySet());
        int max = Collections.max(map.keySet());
        int res = 0;
        double xie = 0.0;
        int[] last = new int[2];
        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) continue;
            if (i == min) {
                last[0] = i;
                last[1] = map.get(i);
                continue;
            }
            if (i > min && res == 0) {
                res++;
                xie = xielv(new int[]{i,map.get(i)},last);
                last[0] = i;
                last[1] = map.get(i);
                continue;
            }
            double new_xie = xielv(new int[]{i,map.get(i)},last);
            if (BigDecimal.valueOf(new_xie ).subtract(BigDecimal.valueOf(xie)).equals(BigDecimal.valueOf(0))) {
                res++;
                xie = new_xie;
            }
            last[0] = i;
            last[1] = map.get(i);
        }
        return res;

    }

    public double xielv(int[] hou, int[] qian) {
        return (double) (hou[1] - qian[1]) / (hou[0] - qian[0]);
    }

    public static void quickSort(int[][] arr, int low, int high) {
        int i, j;
        int[] temp, p;

        if (low >= high) {
            return;
        }
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            while (arr[j][0] >= p[0] && i < j) {
                j--;
            }
            while (arr[i][0] <= p[0] && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }


    public static void main(String[] args) {
        contest6076 contest6076 = new contest6076();
        System.out.println(contest6076.minimumLines(new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}}));
    }
}
