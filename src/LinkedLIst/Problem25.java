package LinkedLIst;

// queue can be implemented by the linkedList
public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pointer = head;
        int flag = 1;
        while (flag == 1) {
            //this is the judgement
            ListNode temp = head;
            ListNode inverse = new ListNode(0);
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    flag = 0;
                    break;
                } else {
                    ListNode newList = new ListNode(temp.val);
                    temp = temp.next;
                    newList.next = inverse.next;
                    inverse.next = newList;

                }
            }
            if (flag != 0) {
                inverse = inverse.next;
                while (inverse != null) {
                    head.val = inverse.val;
                    head = head.next;
                    inverse = inverse.next;
                }
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        Problem25 p = new Problem25();
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode res = p.reverseKGroup(input,2);
        res.print();
    }
}




