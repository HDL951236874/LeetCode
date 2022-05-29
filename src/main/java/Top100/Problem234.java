package Top100;

import java.util.ArrayList;
import java.util.List;

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> container = new ArrayList<>();
//        ListNode temp = new ListNode(0);
//        temp.next = head;
        while (head!=null){
            container.add(head.val);
            head = head.next;
        }
        int l = 0 ;
        int r = container.size()-1 ;
        while (l<r){
            if(container.get(l)!=container.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
