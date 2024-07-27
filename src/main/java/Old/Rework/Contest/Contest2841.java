package Rework.Contest;

import java.math.BigInteger;
import java.util.*;

public class Contest2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Queue<Long> q = new LinkedList<>();
        long res = 0;
        int b = 0;
        int e = k-1;
        long sum = 0;
        int div = 0;
        for(int i = b;i<= e;i++){
            long now = nums.get(i);
            if(!q.contains(now)) div++;
            sum += now;
            q.add(now);
        }
        if(div>=m) {res = sum;}
        while(e<nums.size()-1){
            long l = nums.get(b);
            e++;
            long r = nums.get(e);
            if(!q.contains(r)) div++;
            q.add(r);
            q.poll();
            if(!q.contains(l)) div--;
            sum += r;
            sum -= l;
            b++;
            if(sum>res && div>=m){
                res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2841 c = new Contest2841();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(6);
        a.add(7);
        a.add(3);
        a.add(1);
        a.add(7);
        System.out.println(c.maxSum(a, 3, 4));
    }
}
