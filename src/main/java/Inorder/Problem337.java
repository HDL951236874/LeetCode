package Inorder;

import java.util.Arrays;

public class Problem337 {
    public int rob(TreeNode root) {
        int[] res = backtrack(root);
        return Arrays.stream(res).max().getAsInt();
    }

    public int[] backtrack(TreeNode node) {
        //0: with node.val, 1: without node.val
        if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        } else {
            int[] left = new int[2];
            int[] right = new int[2];
            if (node.left != null) {
                left = backtrack(node.left);
            }
            if (node.right != null) {
                right = backtrack(node.right);
            }
            int[] res = new int[2];
            res[0] = node.val + left[1] + right[1];
            res[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
            return res;
        }
    }
}
