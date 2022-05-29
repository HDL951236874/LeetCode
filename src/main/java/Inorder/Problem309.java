package Inorder;

import java.util.Map;

public class Problem309 {
    public int maxProfit(int[] prices) {
        return  backtrack(prices,prices.length-1);
    }
    public int backtrack(int[] prices,int n){
        if(n==0) return 0;
        if(n == 1) return Math.max(0,prices[1]-prices[0]);
        if(n == 2) return Math.max(Math.max(Math.max(0,prices[1]-prices[1]),Math.max(0,prices[2]-prices[1])),Math.max(0,prices[2]-prices[0]));
        if(prices[n]<=prices[n-1]){
            return backtrack(prices,n-1);
        }else {
            return Math.max(backtrack(prices,n-1),backtrack(prices,n-3)+prices[n]-prices[n-1]);
        }
    }
}
