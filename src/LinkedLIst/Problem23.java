package LinkedLIst;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        int exam = 0;
        for(int i =0;i<lists.length;i++){
            if(lists[i]!=null) exam=1;
        }
        if(exam==0) return null;
        ListNode res = new ListNode();
        ListNode pointer = res;
        int flag = 0;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    flag = 1;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                }
            }
            if (flag == 0) {
                break;
            } else {
                res.next = new ListNode();
                res = res.next;
                res.val = min;
                lists[index] = lists[index].next;
                flag = 0;
                min = Integer.MAX_VALUE;
                index = -1;
            }
        }
        return pointer.next;
    }

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        ListNode[] lists = new ListNode[2];
//        lists[0] = new ListNode(0, new ListNode(1));
//        lists[1] = new ListNode(0, new ListNode(1));
        lists[0]=null;
        lists[1] =null;
        ListNode res = p.mergeKLists(null);
        System.out.println(res);
    }
}
