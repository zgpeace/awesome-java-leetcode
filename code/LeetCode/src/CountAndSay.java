public class CountAndSay {
    /*
    Count and Say
    Description
    The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    1 is read off as "one 1" or 11.

    11 is read off as "two 1s" or 21.

    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n, generate the nth term of the count-and-say sequence.

    Note: Each term of the sequence of integers will be represented as a string.

    Example 1:

    Input: 1
    Output: "1"
    Example 2:

    Input: 4
    Output: "1211"
    Tags: String
     */

    /*
    思路
    题意是数和说，根据如下序列 1, 11, 21, 1211, 111221, ...，求第 n 个数，规则很简单,就是数和说，数就是数这个数数字有几个，
    说就是说这个数，所以 1 就是 1 个 1：11,11 就是有 2 个 1：21，21 就是 1 个 2、1 个 1：1211，可想而知后面就是 111221，
    思路的话就是按这个逻辑模拟出来即可。
     */

    public static String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int i = 1; i < len; i++) {
                if (chars[i] == chars[i - 1]) {
                    times++;
                } else {
                    sb.append(times).append(chars[i - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }


        return str;
    }

    public  static void main(String[] args) {
        int input1 = 1;
        int input2 = 2;
        int input3 = 3;
        int input4 = 4;
        int input5 = 5;
        int input6 = 20;
        System.out.println("input: " + input1 + " result: " + countAndSay(input1));
        System.out.println("input: " + input2 + " result: " + countAndSay(input2));
        System.out.println("input: " + input3 + " result: " + countAndSay(input3));
        System.out.println("input: " + input4 + " result: " + countAndSay(input4));
        System.out.println("input: " + input5 + " result: " + countAndSay(input5));
        System.out.println("input: " + input6 + " result: " + countAndSay(input6));
    }






















}
