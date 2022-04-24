package Top100;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        while (r < prices.length) {
            while (l < r) {
                min = Math.min(prices[l], min);
                l++;
            }
            max_profit = Math.max(max_profit, prices[r] - min);
            r++;
        }
        return max_profit;
    }
}
