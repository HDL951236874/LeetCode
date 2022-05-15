package Inorder;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.*;

public class Problem314 {
    Map<Integer, Map<Integer, List<Integer>>> map = new HashMap();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, 0, 0);
        Map<Integer, Map<Integer, List<Integer>>> new_map = new HashMap<>();
        int start = Integer.MAX_VALUE;
        for (Integer num : map.keySet()) start = Math.min(start, num);
        for (; ; ) {
            for (Integer num : map.keySet()) {
                if (num == start) {
                    new_map.put(num, map.get(num));
                    start++;
                    break;
                }
            }
            if (new_map.size() == map.size()) break;
        }
        for (Integer num1 : new_map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for (Integer num2 : new_map.get(num1).keySet()) {
                temp.addAll(new_map.get(num1).get(num2));
            }
            res.add(temp);
        }
        return res;
    }

    public void backtrack(TreeNode node, int row, int col) {
        if (!map.containsKey(col)) {
            map.put(col, new HashMap<>());
        }
        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<>());
        }
        map.get(col).get(row).add(node.val);
        if (node.left != null) {
            backtrack(node.left, row + 1, col - 1);
        }
        if (node.right != null) {
            backtrack(node.right, row + 1, col + 1);
        }
    }

    public static void main(String[] args) {
        Problem314 problem314 = new Problem314();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        problem314.verticalOrder(treeNode);
    }
}
