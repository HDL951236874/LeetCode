package Rework.Contest;

import java.util.Dictionary;
import java.util.HashMap;

public class Contest2928 {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int distributeCandies(int n, int limit) {
        return dynamicDistribute(n,limit,3);
    }
    public int dynamicDistribute(int n, int limit, int child){
        if(map.containsKey(n)) return map.get(n);
        if(child == 1){
            //this is the final child
            return n<=limit? 1: 0;
        }
        if(n == 0) {
            return 1;
        }
        int count = 0;
        for(int i =0; i<=limit;i++){
            if(n>=i){
            count += dynamicDistribute(n-i, limit, child -1);}
        }
        if(!map.containsKey(n)) map.put(n,count);
        return count;
    }

    public static void main(String[] args) {
        Contest2928 c = new Contest2928();
        System.out.println(c.distributeCandies(3,3));
    }
}
