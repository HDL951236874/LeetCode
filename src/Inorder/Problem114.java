package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem114 {
    public void flatten(TreeNode root) {
        if(root  == null) return;
        List<Integer> container = new ArrayList<>();
        backtracker(container,root);
        root.left = null;
        root.right = null;

        for (int i = 0; i < container.size(); i++) {
            root.val = container.get(i);
            if(i!=container.size()-1){
                root.right = new TreeNode(0);
                root = root.right;
            }
        }

    }
    public void backtracker(List<Integer> container,TreeNode root){
        if(root == null) return;
        container.add(root.val);
        backtracker(container,root.left);
        backtracker(container,root.right);
    }

    public static void main(String[] args) {
        Problem114 p = new Problem114();
        TreeNode l = new TreeNode(0);
        l.left = new TreeNode(1);
        l.right= new TreeNode(2);
        p.flatten(l);
    }
}
