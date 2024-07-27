package Old.Inorder;

import java.util.ArrayList;
import java.util.List;
class ListNode {
    int val;
    Inorder.ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        List<Integer> tmp = new ArrayList<>();
        while (head!=null){
            tmp.add(head.val);
            head = head.next;
        }
        TreeNode temp = new TreeNode(0);
        helper(tmp,temp);
        return temp;
    }
    public void helper(List<Integer> tmp, TreeNode root){
        int num = tmp.size()/2;
        List<Integer> left_part = tmp.subList(0,num);
        List<Integer> right_part = tmp.subList(num+1,tmp.size());
        root.val = tmp.get(num);
        if(left_part.size()>0){
            root.left = new TreeNode(0);
            helper(left_part,root.left);
        }
        if(right_part.size()>0){
            root.right = new TreeNode(0);
            helper(right_part,root.right);
        }
    }
}
