package Inorder;

public class Problem99 {
    public void recoverTree(TreeNode root) {
        do {
            TreeNode res = helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }while (!check(root));
    }

    public TreeNode helper(TreeNode root, int max, int min) {
        if (root == null) return null;
        if (root.val >= max) {
            return root;
        }
        if (root.val <= min) {
            return root;
        }
        TreeNode res1 = helper(root.left, root.val, min);
        TreeNode res2 = helper(root.right, max, root.val);
        if (res1 == null && res2 == null) return null;
        else if (res1 != null && res2 != null) {
            int temp = res1.val;
            res1.val = res2.val;
            res2.val = temp;
            return null;
        } else {

            if (res1 != null && res1.val > root.val) {
                int temp = root.val;
                root.val = res1.val;
                res1.val = temp;
                return null;
            } else if (res2 != null && res2.val < root.val) {
                int temp = root.val;
                root.val = res2.val;
                res2.val = temp;
                return null;
            } else
                return res1 == null ? res2 : res1;
        }
    }

    public boolean check(TreeNode root) {
        if (root == null) return true;
        boolean b1;
        boolean b2;
        boolean b0;
        int l = root.left == null ? Integer.MIN_VALUE : root.left.val;
        int r = root.right == null ? Integer.MAX_VALUE : root.right.val;
        if (root.val <= r && root.val >= l) b0 = true;
        else return false;
        b1 = check(root.left);
        b2 = check(root.right);
        return b1 && b2;
    }

    public static void main(String[] args) {
        Problem99 p = new Problem99();
        TreeNode l = new TreeNode(3);
        l.left = new TreeNode(1);
        l.right = new TreeNode(4);
        l.right.left = new TreeNode(2);
        p.recoverTree(l);
    }
}
