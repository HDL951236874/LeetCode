package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        backtracker(root, new ArrayList<>());
        return this.path;
    }

    public void backtracker(TreeNode node, List<String> now) {
        if (node.left == null && node.right == null) {
            now.add(String.valueOf(node.val));
            path.add(String.join("->", now));
        }
        now.add(String.valueOf(node.val));
        if (node.left != null) {
            List<String> temp1 = new ArrayList<>(now);
            backtracker(node.left, temp1);
        }
        if (node.right != null) {
            List<String> temp2 = new ArrayList<>(now);
            backtracker(node.right, temp2);
        }
    }
}
