public class AddBinary {
    /*
    Add Binary
    Description
    Given two binary strings, return their sum (also a binary string).

    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"
    Tags: Math, String
     */

    /*
    思路
    题意是给你两个二进制串，求其和的二进制串。我们就按照小学算数那么来做，用 carry 表示进位，从后往前算，依次往前，
    每算出一位就插入到最前面即可，直到把两个二进制串都遍历完即可。
     */

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carray = 0;
        int aLastIndex = a.length() - 1;
        int bLastIndex = b.length() - 1;
        while (aLastIndex >= 0 && bLastIndex >= 0) {
            carray = carray + (aLastIndex >= 0 ? a.charAt(aLastIndex--) - '0' : 0);
            carray = carray + (bLastIndex >= 0 ? b.charAt(bLastIndex--) - '0' : 0);
            sb.insert(0, (char)(carray % 2 + '0'));
            carray = carray >> 1;
        }
        while (aLastIndex >= 0) {
            carray = carray + (aLastIndex >= 0 ? a.charAt(aLastIndex--) - '0' : 0);
            sb.insert(0, (char)(carray % 2 + '0'));
            carray = carray >> 1;
        }
        while (bLastIndex >= 0) {
            carray = carray + (bLastIndex >= 0 ? b.charAt(bLastIndex--) - '0' : 0);
            sb.insert(0, (char)(carray % 2 + '0'));
            carray = carray >> 1;
        }
        if (carray > 0) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a1 = "11";
        String b1 = "1";
        System.out.println(a1+ " + " +b1+ " = " + addBinary(a1, b1));
        String a2 = "1010";
        String b2 = "1011";
        System.out.println(a2+ " + " +b2+ " = " + addBinary(a2, b2));
    }
}
