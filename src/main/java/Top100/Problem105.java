package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode res = new TreeNode();
        List<Integer> pre_list = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++) {
            pre_list.add(preorder[i]);
        }
        helper(res, pre_list, inorder);
        return res;
    }

    public void helper(TreeNode tree, List<Integer> pre, int[] in) {
        if (pre.size()==0) return;
        tree.val = pre.get(0);
        int mid = find_pos(in, pre.get(0));

        int[] left = Arrays.copyOfRange(in, 0, mid);
        int[] right = Arrays.copyOfRange(in, mid + 1, in.length);
        pre.remove(0);
        if (left.length > 0) {
            tree.left = new TreeNode();
            helper(tree.left, pre, left);
        }
        if (right.length > 0) {
            tree.right = new TreeNode();
            helper(tree.right, pre, right);
        }
    }

    public int find_pos(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem105 p = new Problem105();
        TreeNode tree = p.buildTree(new int[]{3, 1,2,4}, new int[]{1,2,3,4});
        System.out.println(1);
    }
}
