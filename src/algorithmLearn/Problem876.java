package algorithmLearn;



 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Problem876 {
    public ListNode middleNode(ListNode head) {
        //this is the 1st method
        int len = 0;
        ListNode temp = new ListNode();
        temp.next = head;
        while (head!= null){
            len ++;
            head = head.next;
        }
        int aim = len/2+1;
        while(aim>0){
            temp = temp.next;
            aim--;
        }
        return temp;
    }
}
