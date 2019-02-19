import java.util.Arrays;

public class WildcardMatching {
    /*
    Wildcard Matching
    Description
    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.
    Example 1:

    Input:
    s = "aa"
    p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:

    Input:
    s = "aa"
    p = "*"
    Output: true
    Explanation: '*' matches any sequence.
    Example 3:

    Input:
    s = "cb"
    p = "?a"
    Output: false
    Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
    Example 4:

    Input:
    s = "adceb"
    p = "*a*b"
    Output: true
    Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
    Example 5:

    Input:
    s = "acdcb"
    p = "a*c?b"
    Output: false
    Tags: String, Dynamic Programming, Backtracking, Greedy
     */

    /*
    思路 0
    题意是让让你从判断 s 字符串是否通配符匹配于 p，这道题和Regular Expression Matching很是相似，
    区别在于 *，正则匹配的 * 不能单独存在，前面必须具有一个字符，其意义是表明前面的这个字符个数可以是任意个数，包括 0 个；
    而通配符的 * 是可以随意出现的，跟前面字符没有任何关系，其作用是可以表示任意字符串。
    在此我们可以利用 贪心算法 来解决这个问题，需要两个额外指针 p 和 match 来分别记录最后一个 * 的位置和 * 匹配到 s 字符串的位置，
    其贪心体现在如果遇到 *，那就尽可能取匹配后方的内容，如果匹配失败，那就回到上一个遇到 * 的位置来继续贪心。
     */

    public boolean isMatchByGreedy(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        int sindex = 0;
        int pindex = 0;
        int smatch = 0;
        int pstar = -1;
        int slen = s.isEmpty() ? 0 : s.length();
        int plen = p.isEmpty() ? 0 : p.length();
        char[] schars = s.isEmpty() ? null : s.toCharArray();
        char[] pchars = p.isEmpty() ? null : p.toCharArray();
        while (sindex < slen) {
            if (pindex < plen && (schars[sindex] == pchars[pindex] || pchars[pindex] == '?')) {
                sindex++;
                pindex++;
            } else  if (pindex < plen && pchars[pindex] == '*') {
                smatch = sindex;
                pstar = pindex++;
            } else if (pstar != -1) {
                sindex = ++smatch;
                pindex = pstar + 1;
            } else {
                return false;
            }
        }

        while (pindex < plen && pchars[pindex] == '*') {
            pindex++;
        }

        return pindex == plen;
    }

    /*
    思路 1
    另一种思路就是动态规划了，我们定义 dp[i][j] 的真假来表示 s[0..i) 是否匹配 p[0..j)，其状态转移方程如下所示：

    如果 p[j - 1] != '*'，P[i][j] = P[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?');

    如果 p[j - 1] == '*'，P[i][j] = P[i][j - 1] || P[i - 1][j]
     */
    public boolean isMatchByDynamic(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        int slen = s.isEmpty() ? 0 : s.length();
        int plen = p.isEmpty() ? 0 : p.length();
        char[] schars = s.isEmpty() ? null : s.toCharArray();
        char[] pchars = p.isEmpty() ? null : p.toCharArray();
        boolean[][] spFlag = new boolean[slen + 1][plen + 1];
        spFlag[0][0] = true;

        for (int i = 1; i <= plen; i++) {
            if (pchars[i - 1] == '*') {
                spFlag[0][i] = spFlag[0][i - 1];
            }
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (pchars[j - 1] != '*') {
                    spFlag[i][j] = spFlag[i - 1][j - 1] && (pchars[j - 1] == schars[i - 1] || pchars[j - 1] == '?');
                } else {
                    spFlag[i][j] = spFlag[i][j - 1] || spFlag[i - 1][j];
                }
            }
        }

        return spFlag[slen][plen];
    }

    public static void main(String[] args) {
        WildcardMatching obj = new WildcardMatching();
        String s0 = "aab";
        String p0 = "c*a*b";
        System.out.println("s: " +s0+ " ,p: " +p0+ " , result: " +obj.isMatchByDynamic(s0, p0));

//        String s1 = "aa";
//        String p1 = "a";
//        System.out.println("s: " +s1+ " ,p: " +p1+ " , result: " +obj.isMatchByDynamic(s1, p1));
//
//        String s2 = "aa";
//        String p2 = "*";
//        System.out.println("s: " +s2+ " ,p: " +p2+ " , result: " +obj.isMatchByDynamic(s2, p2));
//
//        String s3 = "cb";
//        String p3 = "*a";
//        System.out.println("s: " +s3+ " ,p: " +p3+ " , result: " +obj.isMatchByDynamic(s3, p3));
//
//        String s4 = "adceb";
//        String p4 = "*a*b";
//        System.out.println("s: " +s4+ " ,p: " +p4+ " , result: " +obj.isMatchByDynamic(s4, p4));
//
//        String s5 = "acdcb";
//        String p5 = "a*c?b";
//        System.out.println("s: " +s5+ " ,p: " +p5+ " , result: " +obj.isMatchByDynamic(s5, p5));
    }











































}
