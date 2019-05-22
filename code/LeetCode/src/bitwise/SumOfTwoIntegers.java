package bitwise;

// https://leetcode.com/problems/sum-of-two-integers/
// solution -->
// https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
public class SumOfTwoIntegers {
  public static int getSum(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }

    return a;
  }

  public static void main(String[] args) {
    int result = getSum(1 ,2);
    int result1 = getSum(-2, 3);
    System.out.println("a = 1, b = 2, c = " + result);
    System.out.println("a = -2, b = 3, c = " + result1);
  }
}
