package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {

  Map<Character, String> phone = new HashMap<Character, String>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  public static void main(String[] args) {
    LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
    obj.letterCombinationsWithBacktrack("23");
  }

  private List<String> resultList = new ArrayList<>();

  public List<String> letterCombinationsWithBacktrack(String digits) {
    if (digits == null || digits.length() == 0) {
      return resultList;
    }
    backTrack("", digits);

    return resultList;
  }

  public void backTrack(String combination, String nextDigits) {
    if (nextDigits == null || nextDigits.length() == 0) {
      resultList.add(combination);
      return;
    }
    char c = nextDigits.charAt(0);
    for (char item: phone.get(c).toCharArray()) {
      backTrack(combination + item, nextDigits.substring(1));
    }
  }


  public List<String> letterCombinations(String digits) {
    // result queue
    List<String> queue = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return queue;
    }
    // first
    queue.add("");
    int gap;
    int size;
    String charString;
    for (char c: digits.toCharArray()) {
      charString = phone.get(c);
      size = queue.size();
      // iterate exist queue
      for (int i = 0; i < size; i++) {
        String s = queue.remove(0);
        // append char
        for (char phoneChar: charString.toCharArray()) {
          String result = s + phoneChar;
          queue.add(result);
        }
      }
    }

    return queue;
  }
}
