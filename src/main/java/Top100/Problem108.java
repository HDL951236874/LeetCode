package Top100;

import java.util.Arrays;

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = new TreeNode();
        helper(res,nums);
        return res;
    }
    public void helper(TreeNode treeNode, int[] nums){
        int mid = nums.length/2;
        treeNode.val = nums[mid];
        int[] l = Arrays.copyOfRange(nums,0,mid);
        int[] r = Arrays.copyOfRange(nums,mid+1,nums.length);
        if(l.length>0){
            treeNode.left = new TreeNode();
            helper(treeNode.left,l);
        }
        if(r.length>0){
            treeNode.right = new TreeNode();
            helper(treeNode.right,r);
        }
    }

    public static void main(String[] args) {
        Problem108 p = new Problem108();
        System.out.println(p.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
