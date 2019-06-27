package String;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return true;
    }
    int head = 0, tail = s.length() - 1;
    char cHead, cTail;
    while(head <= tail) {
      cHead = s.charAt(head);
      cTail = s.charAt(tail);
      if (!Character.isLetterOrDigit(cHead)) {
        head++;
      } else if(!Character.isLetterOrDigit(cTail)) {
        tail--;
      } else {
        if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
          return false;
        }
        head++;
        tail--;
      }
    }

    return true;
  }

  public static boolean isPalindromeWithReverse(String s) {
    String lower = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    String reverse = new StringBuilder(lower).reverse().toString();
    return lower.equals(reverse);
  }


  public static void main(String[] args) {
    System.out.println("result: " + isPalindrome("0P"));
  }
}
