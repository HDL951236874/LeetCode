package Jianzhi;

import java.util.Arrays;

class TreeNode {
    int val;
    Jianzhi.TreeNode left;
    Jianzhi.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, Jianzhi.TreeNode left, Jianzhi.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class jianzhi5 {
    int pre_index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return backtrack(preorder, inorder);

    }

    public TreeNode backtrack(int[] pre, int[] in) {
        if (in.length == 0) return null;
        TreeNode node = new TreeNode(pre[this.pre_index]);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[pre_index]) {
                index = i;
                break;
            }
        }
        int[] temp1 = Arrays.copyOfRange(in, 0, index);
        int[] temp2 = Arrays.copyOfRange(in, index + 1, in.length);
        this.pre_index++;
        TreeNode node1 = backtrack(pre,temp1);
        TreeNode node2 = backtrack(pre,temp2);
        node.left = node1;
        node.right = node2;
        return node;
    }

    public static void main(String[] args) {
        jianzhi5 jianzhi5 = new jianzhi5();
        jianzhi5.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
