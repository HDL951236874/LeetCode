package Contest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class contest2233 {
    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int sum_ = 0;
        while (sum < k && i < nums.length - 1) {
            i++;
            sum_ = sum;
            sum += (nums[i] - nums[i - 1]) * i;
        }
        int base = 0;
        int col = 0;
        int over = 0;
        int layer = 0;
        int left = 0;
        if (sum <= k) {
            base = nums[i];
            col = i;
            left = k - sum;
            layer = left / (nums.length);
            over = left % (nums.length);
        }
        if (sum > k) {
            base = nums[i - 1];
            col = i - 1;
            left = k - sum_;
            layer = left / (col + 1);
            over = left % (col + 1);
        }
        long m = 1;
        for (int j = 0; j < nums.length; j++) {
            if (j <= col - over) {
                m *= (base + layer);
            }
            if (j > col - over && j <= col) {
                m *= (base + layer + 1);
            }
            if (j > col) {
                m *= nums[j];
            }
            if (m >= 1000000007) m %= 1000000007;
        }
        return (int) m;
    }

    public static void main(String[] args) {
        contest2233 contest2233 = new contest2233();
        System.out.println(contest2233.maximumProduct(new int[]{7,10,6,1,8}, 5));
    }
}
