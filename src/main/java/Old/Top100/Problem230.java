package Top100;

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,new int[]{k});
    }

    public int helper(TreeNode root, int[] k) {
        if (root.left != null) {
            int l = helper(root.left, k);
            if (l != -1) return l;
        }
        if(--k[0] == 0) {
            return root.val;
        }
        if (root.right != null) {
            int r = helper(root.right, k);
            if(r != -1) return r;
        }
        return -1;
    }
}

