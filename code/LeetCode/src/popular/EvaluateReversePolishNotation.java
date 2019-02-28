package popular;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        for (String s: tokens) {
            if (s.equals("+")) {
                temp = stack.pop() + stack.pop();
            } else  if (s.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                temp = left - right;
            } else if (s.equals("*")) {
                temp = stack.pop() * stack.pop();
            } else if (s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                temp = left / right;
            } else  {
                temp = Integer.parseInt(s);
            }
            stack.push(temp);
        }

        return temp;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        String[] input = {"2", "1", "+", "3", "*"};
        System.out.println("ouput: " + obj.evalRPN(input));
    }
}
