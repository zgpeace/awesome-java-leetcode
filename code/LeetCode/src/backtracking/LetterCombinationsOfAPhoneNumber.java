package backtracking;

import java.util.*;

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
    obj.letterCombinationWithIterate("23");
  }

  public List<String> letterCombinationWithIterate(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }

    char[][] map = new char[8][];
    map[0] = "abc".toCharArray();
    map[1] = "def".toCharArray();
    map[2] = "ghi".toCharArray();
    map[3] = "jkl".toCharArray();
    map[4] = "mno".toCharArray();
    map[5] = "pqrs".toCharArray();
    map[6] = "tuv".toCharArray();
    map[7] = "wxyz".toCharArray();

    result.add("");
    for (char digit: digits.toCharArray()) {
      result = append(result, map[digit - '2']);
    }

    System.out.println("result > " + Arrays.toString(result.toArray()));

    return result;
  }

  private List<String> append(List<String> lastList, char[] charArray) {
    List<String>  nextList = new ArrayList<>();
    for (String s: lastList) {
      for (char c: charArray) {
        nextList.add(s + c);
      }
    }

    return nextList;
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
