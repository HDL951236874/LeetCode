package LinkedLIst;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode pointer = new ListNode();
        pointer.next = res;
        while (list1 != null || list2 != null) {
            res.next = new ListNode();
            res = res.next;
            if (list1 == null) {
                res.val = list2.val;
                list2 = list2.next;
            }
            else if (list2 == null) {
                res.val = list1.val;
                list1 = list1.next;
            }
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    res.val = list1.val;
                    list1 = list1.next;
                } else {
                    res.val = list2.val;
                    list2 = list2.next;
                }
            }
        }
        return pointer.next.next;
    }

    public static void main(String[] args) {
        Problem21 p = new Problem21();
        ListNode res = p.mergeTwoLists(null,new ListNode(1));
        res.print();
    }
}
