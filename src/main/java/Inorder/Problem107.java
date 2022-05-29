package Inorder;

import java.util.*;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer,List<Integer>> res = new HashMap<>();
        helper(root,0,res);
        List<List<Integer>> final_res = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(!res.containsKey(i)) break;
            else {
                final_res.add(res.get(i));
            }
        }
        Collections.reverse(final_res);
        return final_res;
    }

    public void helper(TreeNode treeNode, int level, Map<Integer, List<Integer>> res) {
        if (treeNode == null) return;
        List<Integer> def_v = res.getOrDefault(level, new ArrayList<Integer>());
        def_v.add(treeNode.val);
        res.put(level, def_v);
        helper(treeNode.left, level + 1, res);
        helper(treeNode.right, level + 1, res);
    }
}
