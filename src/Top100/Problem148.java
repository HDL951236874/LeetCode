package Top100;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode tem = new ListNode(0);
        tem.next = head;
        List<Integer> container = new ArrayList<>();
        while (head != null) {
            container.add(head.val);
            head = head.next;
        }
        Collections.sort(container);
        ListNode res = new ListNode(0);
        ListNode res_temp = new ListNode(0);
        res_temp.next = res;
        for (int i = 0; i < container.size(); i++) {
            res.val = container.get(i);
            if (i != container.size() - 1) {
                res.next = new ListNode(0);
                res = res.next;
            }
        }
        return res_temp.next;
    }

    public static void main(String[] args) {
        Problem148 p = new Problem148();
        ListNode temp = new ListNode(0);
        ListNode a = new ListNode(3);
        a.next = new ListNode(2);
        temp.next = a;
        System.out.println(p.sortList(temp.next));
    }
}
