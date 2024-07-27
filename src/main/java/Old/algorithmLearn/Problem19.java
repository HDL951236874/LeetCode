package algorithmLearn;

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        ListNode head_ = new ListNode();
        temp.next = head;
        head_ = temp;
        head = temp;
        int num = 0;
        while (head!=null){
            if(num >= n+1){
                head = head.next;
                head_ = head_.next;
            }else {
                head = head.next;
                num++;
            }
        };
        head_.next = head_.next.next;
        return temp.next;
    }
}
