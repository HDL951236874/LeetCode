package oop;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        temp.addAll(queue);
        queue = temp;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
