package Inorder;

import java.util.Map;

public class Problem255 {
    public boolean verifyPreorder(int[] preorder) {
        int lowest = Integer.MIN_VALUE;
        for (int i = 1; i < preorder.length; i++) {
            if(preorder[i]-preorder[i-1]>0){
                //increase happen
                for (int j = 0; j < i; j++) {
                    if(preorder[j]<preorder[i])
                        lowest = Math.max(lowest,preorder[j]);
                }
            }
            if(preorder[i]<lowest) return false;
        }
        return true;
    }
}
