package stack;

import java.util.Stack;

class MinStackWithNode {
  Node head;

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x, null);
    } else {
      head = new Node(x, Math.min(x, head.min), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }
}

class Node {
  int val;
  int min = Integer.MAX_VALUE;
  Node next;

  public Node(int val, int min, Node head) {
    this.val = val;
    this.min = min;
    this.next = head;
  }
}

class MinsStackWithOneStack {
  // data stack
  Stack<Integer> stack = new Stack<>();
  int min = Integer.MAX_VALUE;

  /*
    if x <= min, then push min, and set min = x;
   */
  public void push(int x) {
    if (x <= min) {
      stack.push(min);
      min = x;
    }

    stack.push(x);
  }

  public void pop() {
    if (stack.pop() == min) {
      min = stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}

public class MinStack {
  // data stack
  Stack<Integer> dataStack;
  // min stack
  Stack<Integer> minStack;

  /** initialize your data structure here. */
  public MinStack() {
    dataStack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    dataStack.push(x);
    if (minStack.size() == 0 || minStack.peek() >= x) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (dataStack.size() > 0) {
      int d = dataStack.pop();
      if (minStack.size() > 0 && minStack.peek() == d) {
        minStack.pop();
      }
    }

  }

  public int top() {
    if (dataStack.size() > 0) {
      return dataStack.peek();
    }
    // data is empty
    return -1;
  }

  public int getMin() {
    if (minStack.size() > 0) {
      return minStack.peek();
    }

    // data is empty
    return -1;
  }
}

