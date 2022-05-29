package Inorder;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Problem437 {
    int res = 0;
    int target = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        target = targetSum;
        backtrack(root);
        return this.res;
    }

    public List<Integer> backtrack(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (node.val == target) res++;
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            return temp;
        }
        List<Integer> llist = new ArrayList<>();
        List<Integer> rlist = new ArrayList<>();
        if (node.left != null)
            llist = backtrack(node.left);
        if (node.right != null)
            rlist = backtrack(node.right);
        llist.addAll(rlist);
        for (int i = 0; i < llist.size(); i++) {
            if (llist.get(i) + node.val == target) res++;
            llist.set(i, llist.get(i) + node.val);
        }
        if(node.val == target) res++;
        llist.add(node.val);
        return llist;
    }
}
