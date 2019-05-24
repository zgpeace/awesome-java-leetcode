package String;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
  public static void reverseString(char[] s) {
    char c;
    int len = s.length;
    for (int i = 0; i < len >> 1; i++) {
      c = s[i];
      s[i] = s[len - 1 - i];
      s[len - 1 - i] = c;
    }
  }

  public static void reverseStringWithWhile(char[] s) {
    char c;
    int leftIndex = 0;
    int rightIndex = s.length - 1;
    while (leftIndex < rightIndex) {
      c = s[leftIndex];
      s[leftIndex] = s[rightIndex];
      s[rightIndex] = c;
      leftIndex++;
      rightIndex--;
    }
  }

  public static void main(String[] args) {
    char[] s = {'h','e','l','l','o'};
    System.out.println(s);
    reverseString(s);
    System.out.println(s);
  }
}
