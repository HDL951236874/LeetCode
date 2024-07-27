package oop;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()){
            reverse(stack1,stack2);
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()){
            reverse(stack1,stack2);
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void reverse(Stack<Integer> stack1, Stack<Integer> stack2){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
