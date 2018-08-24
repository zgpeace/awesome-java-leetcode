# [Substring with Concatenation of All Words][title]

## Description

You are given a string, **s**, and a list of words, **words**, that are all of the same length. Find all starting indices of substring(s) in **s** that is a concatenation of each word in **words** exactly once and without any intervening characters.

**Example 1:**

```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

**Example 2:**

```
Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
```

**Tags:** Hash Table, Two Pointers, String


## 思路

1. 使用HashMap来保存L中所有的字串。

2. 暴力破解之。使用i记录我们的查找结果字符串的位置，j记录单个单词的查找位置。j每次移动一个L中单词的位置。

3. 注意各种越界条件：i查到离结束还有L*N（L中所有单词总长）的时候，即需要停止。

    j 也要考虑每一次查找的单词的长度。

4. 使用第二个HashMap来记录我们查到的单词。如果所有的单词都查到了，即可记录一个解。

```java

```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][zgpeace]



[title]: https://leetcode.com/problems/substring-with-concatenation-of-all-words
[zgpeace]: https://github.com/zgpeace/awesome-java-leetcode
