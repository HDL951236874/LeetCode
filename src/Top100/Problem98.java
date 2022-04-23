package Top100;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        //this is the first way use the limite
        return helper(null, root.val, root.right) && helper(root.val,null, root.left);
    }

    public boolean helper(Integer upper_bound, Integer lower_bound, TreeNode treeNode) {
        if (treeNode == null) return true;
        if ((upper_bound != null && treeNode.val >= upper_bound) || (lower_bound != null && treeNode.val <= lower_bound))
            return false;

        return helper(treeNode.val, lower_bound, treeNode.left) && helper(upper_bound, treeNode.val, treeNode.right);
    }

    public static void main(String[] args) {
        Problem98 p = new Problem98();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(p.isValidBST(treeNode));
        System.out.println(null==null);
    }
}
