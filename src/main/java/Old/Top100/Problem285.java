package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root.val == 0 && root.left == null && root.right == null) return null;
        int n = 0;
        if (p.val == 1) n = 1;
        else {
            n = 2;
            while (true) {
                if (Math.pow(2, n - 1) - 1 < p.val && Math.pow(2, n) - 1 >= p.val) {
                    break;
                }
                n++;
            }
        }
        List<TreeNode> res = new ArrayList<>();
        backtrack(root, 1, n, res);
        return res.get(p.val - (int) Math.pow(2, n - 1));
    }

    public void backtrack(TreeNode root, int deep, int aim_deep, List<TreeNode> res) {
        if (deep == aim_deep) {
            if (root == null) res.add(null);
            else {
                res.add(root);
            }
            return;
        }
        if (root == null && deep < aim_deep) {
            int num = aim_deep - deep;
            for (int i = 0; i <= num; i++) {
                res.add(null);
            }
            return;
        }
        if (deep > aim_deep) return;
        backtrack(root.left, deep + 1, aim_deep, res);
        backtrack(root.right, deep + 1, aim_deep, res);
    }

    public static void main(String[] args) {
        Problem285 p = new Problem285();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(p.inorderSuccessor(root, root.right));
    }
}
