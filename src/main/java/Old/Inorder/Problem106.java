package Old.Inorder;

import java.util.Arrays;

public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(0);
        int[] post_index = new int[]{postorder.length - 1};
        helper(root, inorder, postorder, post_index);
        return root;
    }

    public void helper(TreeNode root, int[] inorder, int[] postorder, int[] post_index) {
        int number = postorder[post_index[0]];
        int sep_index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == number) {
                sep_index = i;
                break;
            }
        }
        root.val = number;
        int[] left_part = Arrays.copyOfRange(inorder, 0, sep_index);
        int[] right_part = Arrays.copyOfRange(inorder, sep_index + 1, inorder.length);
        if (right_part.length > 0) {
            root.right = new TreeNode(0);
            post_index[0]--;
            helper(root.right, right_part, postorder, post_index);
        }
        if (left_part.length > 0) {
            root.left = new TreeNode(0);
            post_index[0]--;
            helper(root.left, left_part, postorder, post_index);
        }
    }

    public static void main(String[] args) {
        Problem106 p = new Problem106();
        p.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
