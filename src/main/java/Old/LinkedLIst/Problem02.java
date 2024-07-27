package LinkedLIst;
/*
* This question should be updated
* */
public class Problem02 {
    public static void main(String[] args) {
        Problem02 p =new Problem02();
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode res = p.addTwoNumbers(l1,l2);
        System.out.println(res);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer = new ListNode();
        ListNode res = new ListNode();
        pointer.next = res;
        int add = 0;
        int sum = 0;
        while (true) {
            if (l1 == null && l2 != null) {
                sum = l2.val;
                l2 = l2.next;
            }
            if (l1 != null && l2 == null) {
                sum = l1.val;
                l1 = l1.next;
            }
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum = sum+add;
            if(sum>=10){
                sum=sum%10;
                add = 1;
            }
            else {
                add = 0;
            }
            res.val = sum;
            sum = 0;
            if (l1 == null && l2 == null && add==0) {
                break;
            }
            res.next = new ListNode();
            res = res.next;
        }
        return pointer.next;
    }
}


