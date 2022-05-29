package Top100;

import java.util.LinkedList;
import java.util.Queue;

public class Problem101 {
    public boolean isSymmetric_(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) return true;
        if ((treeNode1 == null && treeNode2 != null) || (treeNode1 != null && treeNode2 == null)) return false;
        if (treeNode1.val != treeNode2.val) return false;
        return helper(treeNode1.left, treeNode2.right) && helper(treeNode1.right, treeNode2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem101 p = new Problem101();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        System.out.println(p.isSymmetric(treeNode));
    }
}
