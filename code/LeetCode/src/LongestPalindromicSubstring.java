public class LongestPalindromicSubstring {
    /*
    Longest Palindromic Substring
    Description
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"

    Output: "bab"

    Note: "aba" is also a valid answer.
    Example 2:

    Input: "cbbd"

    Output: "bb"
    Tags: String, Dynamic Programming
     */

    /*
    思路 0
    题意是寻找出字符串中最长的回文串，所谓回文串就是正序和逆序相同的字符串，也就是关于中间对称。
    我们先用最常规的做法，依次去求得每个字符的最长回文，要注意每个字符有奇数长度的回文串和偶数长度的回文串两种情况，
    相信你可以很轻易地从如下代码中找到相关代码，记录最长回文的始末位置即可，
    时间复杂度的话，首先要遍历一遍字符串，然后对每个字符都去求得最长回文，所以时间复杂度为 O(n^2)。
     */
    int start = 0, end = 0;
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; i++) {
            helper(charArray, i, i);
            helper(charArray, i, i + 1);
        }

        return s.substring(start, end + 1);
    }

    public void helper(char[] charArray, int leftInt, int rightInt) {
        while (leftInt >= 0 && rightInt < charArray.length && charArray[leftInt] == charArray[rightInt]) {
            leftInt--;
            rightInt++;
        }
        if (end - start < rightInt - leftInt - 2) {
            start = leftInt + 1;
            end = rightInt - 1;
        }
    }

    /*
    如果利用暴力法遍历所有字串是否回文的情况这道题肯定是 Time Limit Exceeded 的，那么我们是否可以把之前遍历的结果利用上呢，那么动态规划的想法就呼之欲出了，我们定义 dp[i][j] 的意思为字符串区间 [i, j] 是否为回文串，那么我们分三种情况：

    当 i == j 时，那么毫无疑问 dp[i][j] = true；

    当 i + 1 == j 时，那么 dp[i][j] 的值取决于 s[i] == s[j]；

    当 i + 1 < j 时，那么 dp[i][j] 的值取决于 dp[i + 1][j - 1] && s[i] == s[j]。

    根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话显而易见，也是 O(n^2)。
     */
    public String longestPalindromeWithDynamic(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int start = 0, end = 0;
        boolean[][] dynamicZoomFlag = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dynamicZoomFlag[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (j + 1 == i) {
                    dynamicZoomFlag[j][i] = charArray[j] == charArray[i];
                } else {
                    dynamicZoomFlag[j][i] = dynamicZoomFlag[j+1][i-1] && charArray[j] == charArray[i];
                }
                if (dynamicZoomFlag[j][i] && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }

        }

        return s.substring(start, end + 1);
    }

    /*
    思路 2
    马拉车算法(Manacher's Algorithm)

    背景
    给定一个字符串，求出其最长回文子串（回文字符串就是从左到右读和从右往左读完全一样，也就是字符串关于中间对称）。例如：

    s = "babad"，最长回文长度为 3，可以是 bab 或者 aba；

    s = "cbbda"，最长回文长度为 2，即 bb；

    s = "abcde"，最长回文长度为 1，即单个字符本身。

    这个问题等同于 LeetCode 上的 Longest Palindromic Substring，其相关题解可以查看这里：传送门

    以上问题的传统思路大概是遍历每一个字符，以该字符为中心向两边查找，其时间复杂度为 O(n^2)，效率很差。

    1975 年，一个叫 Manacher 的人发明了 Manacher 算法（中文名：马拉车算法），该算法可以把时间复杂度提升到 O(n)，下面我以我理解的思路来讲解其原理。

    分析
    由于回文串的奇偶行不确定，比如 lol 是奇回文，而 lool 是偶回文，马拉车算法的第一步就是对其进行预处理，做法就是在每个字符两侧都加上一个特殊字符，一般就是不会出现在原串中的即可，我们可以选取 #，那么

    lol  -> #l#o#l#
    lool -> #l#o#o#l#
    这样处理后，不管原来字符串长度是奇数还是偶数，最终得到的长度都将是奇数，从而能把两种情况合并起来一起考虑，记预处理后的字符串为 str。

    我们把一个回文串中最左或最右位置的字符与其对称轴的距离称为回文半径。

    马拉车算法定义了一个回文半径数组 len，用 len[i] 表示以第 i 个字符为对称轴的回文串的回文半径，比如以 str[i] 为中心的最长回文串是 str[l, r]，那么 len[i] = r - i + 1

    我们以 lollool 为例，参看下表。

    str	#	l	#	o	#	l	#	l	#	o	#	o	#	l	#
    len[]	1	2	1	4	l	2	5	2	1	2	5	2	1	2	1
    可以发现 len[i] - 1 就等于该回文串在原串中的长度。

    证明：在转换后的字符串 str 中，那么对于以 str[i] 为中心的最长回文串的长度为 2 * len[i] - 1，其中又有 len[i] 个分隔符，所以在原字符串中的回文串长度就是 len[i] - 1。

    那么我们剩下的工作就是求 len 数组。

    为了防止数组越界，我们在首位再加上非 # 的不常用字符，比如 ~，那么 lollool 就表示为 ~#l#o#l#l#o#o#l#~，这样我们就省去写很多 if else 的边界处理。
     */
    public String longestPalindromeWithManacher(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < length; i++) {
            sb.append(charArray[i]);
            sb.append('#');
        }
        int[] radius = new int[sb.length()];
        int right = -1;
        int id = -1;
        for (int i = 0; i < sb.length(); i++) {
            int r = 1;
            if (i <= right) {
                r = Math.min(radius[id] - (i - id), radius[id - (i - id)]);
            }
            while (i - r >= 0 && i + r < sb.length() && sb.charAt(i - r) == sb.charAt(i + r)) {
                r++;
            }
            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            radius[i] = r;
        }

        int maxLength = -1;
        int leftInt = -1;
        int longestLength = -1;
        for (int i = 0; i < radius.length; i++) {
            if (radius[i] > maxLength) {
                maxLength = radius[i];
                longestLength = (maxLength - 1) * 2;
                leftInt = i - (maxLength - 1);
            }
        }

        return sb.substring(leftInt, leftInt + longestLength + 1).replace("#", "");
    }

    public static void main(String[] args) {
//        String input = "babad";
        String input = "aaaa";
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
//        String output = obj.longestPalindrome(input);
//        String output = obj.longestPalindromeWithDynamic(input);
        String output = obj.longestPalindromeWithManacher(input);
        System.out.println("input: " + input + " ;output: " + output);
    }






























}
