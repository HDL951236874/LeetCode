package LinkedLIst;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pointer = head;
        //main
        while (pointer != null) {
            if (pointer.next==null) break;
            int temp;
            temp = pointer.next.val;
            pointer.next.val = pointer.val;
            pointer.val = temp;
            pointer = pointer.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem24 p = new Problem24();
        ListNode res = p.swapPairs(new ListNode(1));
        System.out.println(res.val);
    }
}
