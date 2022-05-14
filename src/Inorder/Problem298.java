package Inorder;

public class Problem298 {
    int max = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {
        backtrack(root, 1);
        return max;
    }

    public void backtrack(TreeNode node, int count) {
        max = Math.max(max, count);

        if (node.left != null) {
            backtrack(node.left, node.val + 1 == node.left.val ? count + 1 : 1);
        }
        if (node.right != null) {
            backtrack(node.right, node.val + 1 == node.right.val ? count + 1 : 1);
        }
    }

    public static void main(String[] args) {
        Problem298 problem298 = new Problem298();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        System.out.println(problem298.longestConsecutive(treeNode));
    }
}
