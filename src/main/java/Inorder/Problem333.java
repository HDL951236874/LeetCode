package Inorder;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Map;

public class Problem333 {
    long res = 1;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        backtrack(root);
        return (int)this.res;
    }

    public long[] backtrack(TreeNode node) {
        //0: sum; 1: min; 2:max
        long[] left = new long[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        long[] right = new long[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        ;
        if (node.left != null) {
            left = backtrack(node.left);
            if (node.val <= left[2]) {
                left[0] = Integer.MIN_VALUE;
            }
        }
        if (node.right != null) {
            right = backtrack(node.right);
            if (node.val >= right[1]) {
                right[0] = Integer.MIN_VALUE;
            }
        }
        long[] res_ = new long[3];
        res = Math.max(right[0] + left[0] + 1, res);
        res_[0] = right[0] + left[0] + 1;
        res_[1] = Math.min(left[1],node.val);
        res_[2] = Math.max(right[2],node.val);
        return res_;
    }

    public static void main(String[] args) {
        Problem333 problem333 = new Problem333();
        TreeNode l = new TreeNode(1);
        l.left = new TreeNode(4);
        l.right = new TreeNode(3);
        l.right.right = new TreeNode(2);
        System.out.println(problem333.largestBSTSubtree(l));
    }
}
