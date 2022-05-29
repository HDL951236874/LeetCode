package Top100;

public class Problem122 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length-1; i++) {
            total += Math.max(prices[i+1]-prices[i],0);
        }
        return total;
    }
}
