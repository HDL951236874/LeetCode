package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem42 {
    public int trap(int[] height) {
        // the time complexity of this method is to high
        int max = Arrays.stream(height).max().getAsInt();
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            int l = 0;
            int r = height.length - 1;
            while (l < r) {
                if (height[l] < i) l++;
                if (height[r] < i) r--;
                if (height[l] >= i && height[r] >= i) break;
            }
            int count = 0;
            for (int j = l + 1; j < r; j++) {
                if (height[j] < i) {
                    count++;
                }
            }
            sum += count;
        }
        return sum;
    }


    public int trap2(int[] height) {
        int accumulate = 0;
        int sum = Arrays.stream(height).sum();
        int pos = getPositionOfMax(height);
        int max1 = height[0];
        for (int i = 0; i < pos; i++) {

            if (max1 < height[i]) {
                max1 = height[i];
            }
            accumulate += max1;
        }
        int max2 = height[height.length - 1];
        for (int i = height.length - 1; i > pos; i--) {

            if (max2 < height[i]) {
                max2 = height[i];
            }
            accumulate += max2;
        }
        return accumulate - sum + Arrays.stream(height).max().getAsInt();
    }

    public int getPositionOfMax(int[] height) {
        int max = Arrays.stream(height).max().getAsInt();
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public int trap3(int[] height) {
        // this is the brute force method
        // this method will exceed the time limite
        int sum = 0;
        for (int x = 0; x < height.length; x++) {
            //left side
            int[] leftPart = Arrays.copyOfRange(height, 0, x);
            int[] rightPart = Arrays.copyOfRange(height, x + 1, height.length);
            if (leftPart.length != 0 && rightPart.length != 0) {
                int leftMax = Arrays.stream(leftPart).max().getAsInt();
                int rightMax = Arrays.stream(rightPart).max().getAsInt();
                int min = Math.min(leftMax, rightMax);
                if (min > height[x]) {
                    sum += Math.min(leftMax, rightMax) - height[x];
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        System.out.println(p.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
