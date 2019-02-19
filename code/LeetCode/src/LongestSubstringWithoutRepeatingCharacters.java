public class LongestSubstringWithoutRepeatingCharacters {
    /*
    Longest Substring Without Repeating Characters
    Description
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Tags: Hash Table, Two Pointers, String
     */

    /*
    思路
    题意是计算不带重复字符的最长子字符串的长度，开辟一个 hash 数组来存储该字符上次出现的位置，
    比如 hash[a] = 3 就是代表 a 字符前一次出现的索引在 3，遍历该字符串，获取到上次出现的最大索引（只能向前，不能退后），
    与当前的索引做差获取的就是本次所需长度，从中迭代出最大值就是最终答案。
     */

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int previous = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        int[] charIndexArray = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexArray[c] > previous) {
                previous = charIndexArray[c];
            }
            int currentLongChar = i - previous + 1;
            if (currentLongChar > max) {
                max = currentLongChar;
            }
            charIndexArray[c] = i + 1;
        }

        return max;
    }











































}
