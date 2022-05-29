package Inorder;

public class Problem112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }

    public boolean helper(TreeNode root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == target){
                return true;
            }else {
                return false;
            }
        }
        boolean b1 = false;
        boolean b2 = false;
        if(root.left!=null)
        b1 = helper(root.left,target-root.val);
        if(root.right!=null)
        b2 = helper(root.right,target-root.val);
        return b1|| b2;
    }
}
