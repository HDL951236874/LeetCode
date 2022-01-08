package LinkedLIst;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head ==null) return null;
        ListNode pointer = head;
        int number = 0;
        while(head!=null){
            number++;
            head = head.next;
        }
        head = pointer;
        k = k%number;
        for (int i = 0; i < k; i++) {
            int temp1, temp2;
            temp1 = pointer.val;

            while (head.next != null) {
                temp2 = head.next.val;
                head.next.val = temp1;
                temp1 = temp2;
                head = head.next;
            }
            pointer.val = temp1;
            head = pointer;
        }
        return pointer;
    }

    public static void main(String[] args) {
        Problem61 p = new Problem61();

        ListNode res = p.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3))), 4);
        res.print();
    }
}
