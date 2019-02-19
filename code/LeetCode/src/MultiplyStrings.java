public class MultiplyStrings {
    /*
    Multiply Strings
    Description
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

    Example 1:

    Input: num1 = "2", num2 = "3"
    Output: "6"
    Example 2:

    Input: num1 = "123", num2 = "456"
    Output: "56088"
    Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
    Tags: Math, String
     */

    /*
    思路
    题意是让你计算两个非负字符串的乘积，我们模拟小学数学的方式来做，一位一位模拟计算，再各位累加。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int l = l1 + l2;
        int[] sumArray = new int[l];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = l1 - 1; i >= 0; i--) {
            int item1 = chars1[i] - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int item2 = chars2[j] - '0';
                sumArray[(i + j + 1)] += item1 * item2;
            }
        }

        for (int k = l - 1; k >= 0; k--) {
            if (sumArray[k] > 9) {
                sumArray[k - 1] += sumArray[k] / 10;
                sumArray[k] = sumArray[k] % 10;
            }
        }

        int i = 0;
        while (sumArray[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < l; j++) {
            sb.append(((char)('0' + sumArray[j])));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        String num1 = "2", num2 = "3";
        System.out.println("input1: " + num1 + " ,input2: " + num2 + " ,result: " + obj.multiply(num1, num2));

        String num3 = "123", num4 = "456";
        System.out.println("input1: " + num3 + " ,input2: " + num4 + " ,result: " + obj.multiply(num3, num4));

    }













































}
