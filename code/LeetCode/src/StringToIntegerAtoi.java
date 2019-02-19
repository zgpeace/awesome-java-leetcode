public class StringToIntegerAtoi {
    /*
    String to Integer (atoi)
    Description
    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
    Example 1:

    Input: "42"
    Output: 42
    Example 2:

    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.
    Example 3:

    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
    Example 4:

    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.
    Example 5:

    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Thefore INT_MIN (−2^31) is returned.
    Tags: Math, String
     */

    /*
    思路
    题意是把一个字符串转为整型，但要注意所给的要求，先去除最前面的空格，然后判断正负数，注意正数可能包含 +，
    如果之后存在非数字或全为空则返回 0，而如果合法的值超过 int 表示的最大范围，则根据正负号返回 INT_MAX 或 INT_MIN。
     */

    public int myAtoni(String str) {
        int sign = 1;
        int number = 0;
        int length = str.length();
        int i = 0;
        char[] chars = str.toCharArray();
        while (i < length && chars[i] == ' ') {
            i++;
        }
        if (i < length && (chars[i] == '+' || chars[i] == '-')) {
            sign = chars[i] == '+' ? 1 : -1;
            i++;
        }
        for (; i < length; i++) {
            int temp = chars[i] - '0';
            if (temp < 0 || temp > 9) {
                break;
            }
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && ((sign == 1 && temp > 7) || (sign == -1 && temp > 8)))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + temp;
        }

        return sign * number;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi obj = new StringToIntegerAtoi();
//        String input = "42";
//        int output = obj.myAtoni(input);
//        String input1 = "   -42";
//        int output1 = obj.myAtoni(input1);
//        String input2 = "4193 with words";
//        int output2 = obj.myAtoni(input2);
//        String input3 = "words and 987";
//        int output3 = obj.myAtoni(input3);
//        String input4 = "-91283472332";
//        int output4 = obj.myAtoni(input4);
        String input5 = "-3924x8fc";
        int output5 = obj.myAtoni(input5);
//        String input6 = "42";
//        int output6 = obj.myAtoni(input);
//        String input7 = "42";
//        int output7 = obj.myAtoni(input);
//        System.out.println("input: " + input + " output: " + output);
//        System.out.println("input: " + input1 + " output: " + output1);
//        System.out.println("input: " + input2 + " output: " + output2);
//        System.out.println("input: " + input3 + " output: " + output3);
//        System.out.println("input: " + input4 + " output: " + output4);
        System.out.println("input: " + input5 + " output: " + output5);
//        System.out.println("input: " + input6 + " output: " + output6);
//        System.out.println("input: " + input7 + " output: " + output7);

    }





































}
