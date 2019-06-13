package String;

// https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {

  public static int titleToNumber(String s) {
    int sum = 0;
    char current;
    int num;
    int carry = 1;
    int len = s.length();
    for (int i = len - 1; i >= 0; i--) {
      current = s.charAt(i);
      num = current - 'A' + 1;
       sum = sum + num * carry;
       carry *= 26;
    }

    return sum;
  }

  public static int titleToNumberAsc(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }

    return result;
  }

  public static void main(String[] args) {
    int sum = titleToNumberAsc("AA");
    System.out.println("sum: " + sum);
  }

}
