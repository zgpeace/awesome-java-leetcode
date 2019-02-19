import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    /*
    Letter Combinations of a Phone Number
    Description
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    img

    Example:

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:

    Although the above answer is in lexicographical order, your answer could be in any order you want.

    Tags: String, Backtracking
     */

    /*
    思路 0
    题意是给你按键，让你组合出所有不同结果，首先想到的肯定是回溯了，对每个按键的所有情况进行回溯，
    回溯的终点就是结果字符串长度和按键长度相同。
     */
    static final String[] lettersArray = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        int len = digits.length();
        List<String> resultList = new ArrayList<String>();
        helper(resultList, digits, "");

        return resultList;
    }

    public void helper(List<String> list, String digits, String letters) {
        if (digits.length() == letters.length()) {
            list.add(letters);
            return;
        }

        for (char c: lettersArray[digits.charAt(letters.length()) - '2'].toCharArray()) {
            helper(list, digits, letters + c);
        }
    }

    /*
    思路 1
    还有一种思路就是利用队列，根据上一次队列中的值，该值拼接当前可选值来不断迭代其结果，具体代码如下。
     */
    public List<String> letterCombinationsWithQueue(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        int len = digits.length();
        char[] digitArray = digits.toCharArray();
        LinkedList<String> resultList = new LinkedList<String>();
        resultList.add("");
        for (int i = 0; i < len; i++) {
            char digit = digitArray[i];
            while (resultList.getFirst().length() == i) {
                String pop = resultList.removeFirst();
                for (char c: lettersArray[digit - '2'].toCharArray()) {
                    resultList.addLast(pop + c);
                }
            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        String input = "23";

        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
//        List<String> list = obj.letterCombinations(input);
        List<String> list = obj.letterCombinationsWithQueue(input);
        System.out.println(list);

    }


































}
