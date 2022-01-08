package LinkedLIst;

public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pointer = head;
        int flag = 1;
        while (flag == 1) {
            //this is the judgement
            ListNode temp = head;
            for (int i = 0; i < k; i++) {
                if (temp.next == null) {
                    flag = 0;
                    break;
                } else {

                }
            }
            //this is the main function
        }
        return new ListNode(0);
    }
}




