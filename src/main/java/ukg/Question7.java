package ukg;

public class Question7 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<buy){
                buy = prices[i];
            }else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}
