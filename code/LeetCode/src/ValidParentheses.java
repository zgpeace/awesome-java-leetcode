public class ValidParentheses {
    /*
    Valid Parentheses
    Description
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true
    Example 3:

    Input: "(]"
    Output: false
    Example 4:

    Input: "([)]"
    Output: false
    Example 5:

    Input: "{[]}"
    Output: true
    Tags: Stack, String
     */

    /*
    思路
    题意是判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，当出现左括号的时候入栈，当遇到右括号时，
    判断栈顶的左括号是否何其匹配，不匹配的话直接返回 false 即可，最终判断是否空栈即可，这里我们可以
    用数组模拟栈的操作使其操作更快，有个细节注意下 top = 1;，从而省去了之后判空的操作和 top - 1 导致数组越界的错误。
     */

    public static boolean isValid(String s) {
        char stack[] = new char[s.length() + 1];
        int top = 1;
        for (char charItem: s.toCharArray()) {
            if (charItem == '(' || charItem == '[' || charItem == '{') {
                stack[top++] = charItem;
            } else if (charItem == ')' && stack[--top] != '(') {
                return false;
            } else if (charItem == ']' && stack[--top] != '[') {
                return false;
            } else if (charItem == '}' && stack[--top] != '{') {
                return false;
            }
        }


        return top == 1;
    }

    public static void main(String[] args) {
        String input1 = "()";
        System.out.println("input: " + input1 + " result: " + isValid(input1));
        String input2 = "()[]{}";
        System.out.println("input: " + input2 + " result: " + isValid(input2));
        String input3 = "(]";
        System.out.println("input: " + input3 + " result: " + isValid(input3));
        String input4 = "([)]";
        System.out.println("input: " + input4 + " result: " + isValid(input4));
        String input5 = "{[]}";
        System.out.println("input: " + input5 + " result: " + isValid(input5));
    }
}
