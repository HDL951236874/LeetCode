package Old.LinkedLIst;

// queue can be implemented by the linkedList
public class Problem25 {
    public LinkedLIst.ListNode reverseKGroup(LinkedLIst.ListNode head, int k) {
        LinkedLIst.ListNode pointer = head;
        int flag = 1;
        while (flag == 1) {
            //this is the judgement
            LinkedLIst.ListNode temp = head;
            LinkedLIst.ListNode inverse = new LinkedLIst.ListNode(0);
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    flag = 0;
                    break;
                } else {
                    LinkedLIst.ListNode newList = new LinkedLIst.ListNode(temp.val);
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
        LinkedLIst.ListNode input = new LinkedLIst.ListNode(1,new LinkedLIst.ListNode(2,
                new LinkedLIst.ListNode(3,new LinkedLIst.ListNode(4))));
        LinkedLIst.ListNode res = p.reverseKGroup(input,2);
        res.print();
    }
}




