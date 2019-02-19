public class PlusOne {
    /*
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
     */

    /*
    思路
    题意是给你一个数字数组，高位在前，并且首位不为 0 除非这个数组就是 [0]，让你给该数组低位加一求其结果，
    那么我们就模拟小学数学那样进位去算即可，如果一直进位到首位，这种情况也就是都是由 9 组成的数组，
    此时我们只要 new 出一个多一个长度的数组即可，并把第 0 个元素赋 1 即可。
     */
    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] < 9) {
            digits[lastIndex]++;
        } else {
            do {
                digits[lastIndex--] = 0;
            }while (lastIndex >= 0 && digits[lastIndex] == 9);

            if (digits[0] != 0) {
                digits[lastIndex]++;
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }

        printArray(digits, false);

        return digits;
    }

    public static void printArray(int[] input, boolean isInput) {
        System.out.print(isInput ? "Input: " : "Output: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3};
        printArray(input1, true);
        plusOne(input1);

        int[] input2 = {9,9,9};
        printArray(input2, true);
        plusOne(input2);

    }


























}
