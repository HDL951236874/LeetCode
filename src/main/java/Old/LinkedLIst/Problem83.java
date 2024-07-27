package LinkedLIst;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        if (head.next == null) return head;
        ListNode pointer = new ListNode();
        ListNode head_ = new ListNode();
        pointer = head_;
        int temp = head.val;
        head = head.next;
        head_.val = temp;
        while(head!=null){
            if(head.val!=temp){
                head_.next = new ListNode(head.val);
                head_ = head_.next;
                temp = head.val;
                head = head.next;
            }
            else {
                head = head.next;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        Problem83 p = new Problem83();
        ListNode res = p.deleteDuplicates(new ListNode(1,new ListNode(2, new ListNode(2, new ListNode(3)))));
        res.print();
    }
}
