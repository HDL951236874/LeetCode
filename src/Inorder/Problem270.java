package Inorder;

public class Problem270 {
    double target = 0;
    double distance = Integer.MAX_VALUE;
    int close_value = 0;
    public int closestValue(TreeNode root, double target) {
        this.target = target;
        backtrack(root);
        return close_value;
    }
    public void backtrack(TreeNode node){
        if(node == null) return;
        if(Math.abs(node.val-this.target)<distance){
            distance = Math.abs(node.val-this.target);
            close_value = node.val;
        }
        if(node.val>this.target){
            backtrack(node.left);
        }
        if(node.val<this.target){
            backtrack(node.right);
        }
    }
}
