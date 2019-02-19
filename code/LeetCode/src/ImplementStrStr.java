public class ImplementStrStr {
    /*
    Implement strStr().

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     */

    /*
    思路
    题意是从主串中找到子串的索引，如果找不到则返回-1，当子串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。
     */
    public static int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (haystackLen < needleLen) {
            return -1;
        }
        for (int i = 0; ; i++) {
            if (i + needleLen > haystackLen) {
                return -1;
            }
            for (int j = 0; ; j++) {
                if (j == needleLen) {
                    return i;
                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public  static void main(String[] args) {
        String haystack1 = "hello", needle1 = "ll";
        System.out.println("haystack: " + haystack1 + "; needle: " + needle1 + "; resullt: " + strStr(haystack1, needle1));
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println("haystack: " + haystack2 + "; needle: " + needle2 + "; resullt: " + strStr(haystack2, needle2));
    }


}
