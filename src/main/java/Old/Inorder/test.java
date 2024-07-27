package Inorder;

import java.util.List;
import java.util.Stack;

public class test {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        test test = new test();
        System.out.println(test.reversePrint(listNode));
    }
}
