package Top100;

import java.util.ArrayList;
import java.util.List;

public class contest2 {
    public int averageOfSubtree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res.size();
    }

    public int[] helper(TreeNode root, List<Integer> res) {
        int[] temp1 = new int[]{0,0};
        int[] temp2 = new int[]{0,0};

        if (root.left != null) {
            temp1 = helper(root.left, res);
        }
        if (root.right != null) {
            temp2 = helper(root.right, res);
        }
        int[] temp = new int[2];
        if((temp1[0] + temp2[0] + root.val) / (temp1[1] + temp2[1] + 1) == root.val){
            res.add(root.val);
        }
        temp[0] = (temp1[0] + temp2[0] + root.val);
        temp[1] = (temp1[1] + temp2[1] + 1);
        return temp;
    }
}
