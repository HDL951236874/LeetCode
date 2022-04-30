package Top100;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        boolean[] success = new boolean[]{false};

        int res = backtrack(coins, amount, (int) Math.ceil(amount / coins[0]),success);
        if(success[0]) return res;
        else return -1;
    }

    public int backtrack(int[] coins, int amount, int left, boolean[] success) {

        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] == 0) {
                success[0] = true;
                return 1;
            } else if (left > 0 && amount - coins[i] > 0) {
                int step = backtrack(coins, amount - coins[i], left - 1,success);
                left = Math.min(left, step);
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Problem322 p = new Problem322();
        System.out.println(p.coinChange(new int[]{2}, 3));
    }
}
