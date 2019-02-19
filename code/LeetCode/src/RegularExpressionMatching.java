public class RegularExpressionMatching {
    /*
    Regular Expression Matching
    Description
    Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.
    Example 1:

    Input:
    s = "aa"
    p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:

    Input:
    s = "aa"
    p = "a*"
    Output: true
    Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
    Example 3:

    Input:
    s = "ab"
    p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".
    Example 4:

    Input:
    s = "aab"
    p = "c*a*b"
    Output: true
    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
    Example 5:

    Input:
    s = "mississippi"
    p = "mis*is*p*."
    Output: false
    Tags: String, Dynamic Programming, Backtracking
     */

    /*
    思路 0
    题意是让让你从判断 s 字符串是否正则匹配于 p，这道题和 Wildcard Matching 很是相似，
    区别在于 *，通配符的 * 是可以随意出现的，跟前面字符没有任何关系，其作用是可以表示任意字符串；
    而正则匹配的 * 不能单独存在，前面必须具有一个字符，其意义是表明前面的这个字符个数可以是任意个数，包括 0 个。
    首先我们用递归的方式来实现，其思路如下：

    如果 s 和 p 都为空，那么返回 true；

    如果 p 的长度为 1，当 s 的长度也为 1，并且他们首位匹配则返回 true，否则返回 false；

    如果 p 的第二个字符不为 '*'，如果 s 为空，那就返回 false，首位匹配则返回递归调用他们去掉首位的子字符串，否则返回 false；

    如果 p 的第二个字符为 '*'，循环当 s 不为空，且首位匹配，如果递归调用是否匹配 s 字符串和 p 去掉前两位的子字符串，则返回 true，
    否则 s 去掉首字母继续循环；

    返回递归调用 s 字符串和 p 去掉前两位的子字符串是否匹配。
     */

    public boolean isMathByLoop(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMathByLoop(s.substring(1), p.substring(1));
        }
        //p.charAt(1) == '*'
        while (!s.isEmpty() && p.charAt(1) == '*' && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            if (isMathByLoop(s, p.substring(2))) {
                return true;
            } else {
                s = s.substring(1);
            }
        }

        return isMathByLoop(s, p.substring(2));
    }

    /*
    思路 1
    我们可以把上面的思路更简单化，如下：

    如果 s 和 p 都为空，那么返回 true；

    如果 p 的第二个字符为 *，由于 * 前面的字符个数可以为任意，那么我们先递归调用个数为 0 的情况；
    或者当 s 不为空，如果他们的首字母匹配，那么我们就递归调用去掉去掉首字母的 s 和完整的 p；

    如果 p 的第二个字符不为 *，那么我们就老老实实判断第一个字符是否匹配并且递归调用他们去掉首位的子字符串。
     */
    public boolean isMathByLoopLess(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMathByLoopLess(s, p.substring(2)) || (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMathByLoopLess(s.substring(1), p));
        }
        return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMathByLoopLess(s.substring(1), p.substring(1));
    }

    /*
    思路 2
    另一种思路就是动态规划了，我们定义 dp[i][j] 的真假来表示 s[0..i) 是否匹配 p[0..j)，通过思路 1，我们可以确定其状态转移方程如下所示：

    如果 p[j - 1] == '*', dp[i][j] = dp[i][j - 2] || (pc[j - 2] == sc[i - 1] || pc[j - 2] == '.') && dp[i - 1][j];；

    如果 p[j - 1] != '*'，dp[i][j] = dp[i - 1][j - 1] && (pc[j - 1] == '.' || pc[j - 1] == sc[i - 1]);。
     */
    public boolean isMathByDynamic(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        int sl = s.length();
        int pl = p.length();
        boolean[][] spArray = new boolean[sl + 1][pl + 1];
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        spArray[0][0] = true;
        for (int i = 2; i <= pl; i++) {
            if (pchars[i - 1] == '*' && spArray[0][i - 2]) {
                spArray[0][i] = true;
            }
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (pchars[j - 1] == '*') {
                    spArray[i][j] = spArray[i][j - 2] || (spArray[i - 1][j] && (schars[i - 1] == pchars[j - 2] || pchars[j - 2] == '.'));
                } else {
                    spArray[i][j] = spArray[i - 1][j - 1] && (schars[i - 1] == pchars[j - 1] || pchars[j - 1] == '.');
                }
            }
        }

        return spArray[sl][pl];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
//        String s0 = "ab";
//        String p0 = ".*c";
//        System.out.println("s: " +s0+ " ,p: " +p0+ " ,result: " +obj.isMathByLoop(s0, p0));
//
//        String s1 = "aa";
//        String p1 = "a";
//        System.out.println("s: " +s1+ " ,p: " +p1+ " ,result: " +obj.isMathByLoop(s1, p1));
//
//        String s2 = "aa";
//        String p2 = "a*";
//        System.out.println("s: " +s2+ " ,p: " +p2+ " ,result: " +obj.isMathByLoop(s2, p2));
//
//        String s3 = "aa";
//        String p3 = ".*";
//        System.out.println("s: " +s3+ " ,p: " +p3+ " ,result: " +obj.isMathByLoop(s3, p3));
//
//        String s4 = "aab";
//        String p4 = "c*a*b";
//        System.out.println("s: " +s4+ " ,p: " +p4+ " ,result: " +obj.isMathByLoop(s4, p4));
//
//        String s5 = "mississippi";
//        String p5 = "mis*is*p*.";
//        System.out.println("s: " +s5+ " ,p: " +p5+ " ,result: " +obj.isMathByLoop(s5, p5));
        /*
        s: ab ,p: .*c ,result: false
        s: aa ,p: a ,result: false
        s: aa ,p: a* ,result: true
        s: aa ,p: .* ,result: true
        s: aab ,p: c*a*b ,result: true
        s: mississippi ,p: mis*is*p*. ,result: false
         */

//        String s0 = "ab";
//        String p0 = ".*c";
//        System.out.println("s: " +s0+ " ,p: " +p0+ " ,result: " +obj.isMathByLoopLess(s0, p0));
//
//        String s1 = "aa";
//        String p1 = "a";
//        System.out.println("s: " +s1+ " ,p: " +p1+ " ,result: " +obj.isMathByLoopLess(s1, p1));
//
//        String s2 = "aa";
//        String p2 = "a*";
//        System.out.println("s: " +s2+ " ,p: " +p2+ " ,result: " +obj.isMathByLoopLess(s2, p2));
//
//        String s3 = "aa";
//        String p3 = ".*";
//        System.out.println("s: " +s3+ " ,p: " +p3+ " ,result: " +obj.isMathByLoopLess(s3, p3));
//
//        String s4 = "aab";
//        String p4 = "c*a*b";
//        System.out.println("s: " +s4+ " ,p: " +p4+ " ,result: " +obj.isMathByLoopLess(s4, p4));
//
//        String s5 = "mississippi";
//        String p5 = "mis*is*p*.";
//        System.out.println("s: " +s5+ " ,p: " +p5+ " ,result: " +obj.isMathByLoopLess(s5, p5));

        String s0 = "ab";
        String p0 = ".*c";
        System.out.println("s: " +s0+ " ,p: " +p0+ " ,result: " +obj.isMathByDynamic(s0, p0));

        String s1 = "aa";
        String p1 = "a";
        System.out.println("s: " +s1+ " ,p: " +p1+ " ,result: " +obj.isMathByDynamic(s1, p1));

        String s2 = "aa";
        String p2 = "a*";
        System.out.println("s: " +s2+ " ,p: " +p2+ " ,result: " +obj.isMathByDynamic(s2, p2));

        String s3 = "aa";
        String p3 = ".*";
        System.out.println("s: " +s3+ " ,p: " +p3+ " ,result: " +obj.isMathByDynamic(s3, p3));

        String s4 = "aab";
        String p4 = "c*a*b";
        System.out.println("s: " +s4+ " ,p: " +p4+ " ,result: " +obj.isMathByDynamic(s4, p4));

        String s5 = "mississippi";
        String p5 = "mis*is*p*.";
        System.out.println("s: " +s5+ " ,p: " +p5+ " ,result: " +obj.isMathByDynamic(s5, p5));

    }











































}
