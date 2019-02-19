import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    /*
    Substring with Concatenation of All Words
    Description
    You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

    Example 1:

    Input:
      s = "barfoothefoobarman",
      words = ["foo","bar"]
    Output: [0,9]
    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
    The output order does not matter, returning [9,0] is fine too.
    Example 2:

    Input:
      s = "wordgoodstudentgoodword",
      words = ["word","student"]
    Output: []
    Tags: Hash Table, Two Pointers, String
     */

    /*
    思路
    使用HashMap来保存L中所有的字串。

    暴力破解之。使用i记录我们的查找结果字符串的位置，j记录单个单词的查找位置。j每次移动一个L中单词的位置。

    注意各种越界条件：i查到离结束还有L*N（L中所有单词总长）的时候，即需要停止。

    j 也要考虑每一次查找的单词的长度。

    使用第二个HashMap来记录我们查到的单词。如果所有的单词都查到了，即可记录一个解。
     */

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return resultList;
        }
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        Map<String, Integer> foundMap = new HashMap<String, Integer>();
        for (String word: words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, (wordMap.get(word) + 1));
            } else {
                wordMap.put(word, 1);
            }
        }
        int wordCount = words.length;
        int wordLen = words[0].length();
        int allLen = wordLen * wordCount;

        for (int i = 0; i <= s.length() - allLen; i++) {
            foundMap.clear();
            int foundCount = 0;
            for (int j = 0; j < wordCount; j++) {
                String tempWord = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordMap.containsKey(tempWord)) {
                    if (foundMap.containsKey(tempWord)) {
                        foundMap.put(tempWord, (foundMap.get(tempWord) + 1));
                    } else {
                        foundMap.put(tempWord, 1);
                    }

                    if (foundMap.get(tempWord) > wordMap.get(tempWord)) {
                        break;
                    }
                    foundCount++;
                } else {
                    break;
                }
            }

            if (foundCount == wordCount) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    /*
    通过滑动窗口的思维，窗口大小为words数组的1个单位。

    An O(N) solution with detailed explanation

    travel all the words combinations to maintain a window

    there are wl(word len) times travel

    each time, n/wl words, mostly 2 times travel for each word

    one left side of the window, the other right side of the window

    so, time complexity O(wl * 2 * N/wl) = O(2N)
     */
    public List<Integer> findSubstringByWindowSlide(String s, String[] words) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return resultList;
        }
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        int distinguishCount = 0;
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            if (wordMap.get(word) == 1) {
                distinguishCount += 1;
            }
        }
        int wordLen = words[0].length();
        int wordCount = words.length;
        for (int k = 0; k < wordLen; k++) {
            Map<String, Integer> foundMap = new HashMap<String, Integer>();
            int foundCount = 0;
            for (int i = k, j = k; j <= s.length() - wordLen; j = j + wordLen) {

                if (j - i >= wordLen * wordCount) {
                    String firstWord = s.substring(i, i + wordLen);
                    if (wordMap.containsKey(firstWord)) {
                        foundMap.put(firstWord, foundMap.get(firstWord) - 1);
                        if (foundMap.get(firstWord) == wordMap.get(firstWord) - 1) {
                            foundCount -= 1;
                        }
                    }

                    i += wordLen;
                }

                String nextWord = s.substring(j, j + wordLen);
                if (wordMap.containsKey(nextWord)) {
                    foundMap.put(nextWord, foundMap.getOrDefault(nextWord, 0) + 1);
                    if (wordMap.get(nextWord) == foundMap.get(nextWord)) {
                        foundCount += 1;
                    }
                }

                if (foundCount == distinguishCount) {
                    resultList.add(i);
                }
            }

        }

        return resultList;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
//        System.out.println("s: " +s+ " \n word: " + Arrays.toString(words) + " \n result: " + Arrays.toString(obj.findSubstring(s, words).toArray()));
        System.out.println("s: " +s+ " \n word: " + Arrays.toString(words) + " \n result: " + Arrays.toString(obj.findSubstringByWindowSlide(s, words).toArray()));

    }




































































}
