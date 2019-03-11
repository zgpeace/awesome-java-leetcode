public class Sqrt {
    /*
    Sqrt(x)
    Description
    Implement int sqrt(int x).

    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

    Example 1:

    Input: 4
    Output: 2
    Example 2:

    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since
                 the decimal part is truncated, 2 is returned.
    Tags: Binary Search, Math
     */

    /*
    思路
    题意是求平方根，参考 牛顿迭代法求平方根，然后再参考维基百科的 Integer square root 即可。
     */

    public static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        long y = x;
        while (y * y > x) {
            y = (long)(0.5 * (y + x / y));
        }

        return (int)y;
    }

    public static int mySqrtWithMid(int x) {
        if(x < 1) {
            return 0;
        }
        int left = 0;
        int right = x;
        while(true) {
            int mid = left + ((right - left) >> 1);
            if (mid < 1) {
                return 1;
            }
            if (mid > x / mid) {
                right = mid;
            } else {
                if (mid + 1 > x/(mid + 1)) {
                    return mid;
                }

                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        int input1 = 4;
        System.out.println("input: " +input1+ " sqrt: " + mySqrt(input1));
        System.out.println("input: " +input1+ " mySqrtWithMid: " + mySqrtWithMid(input1));

        int input2 = 8;
        System.out.println("input: " +input2+ " sqrt: " + mySqrt(input2));
        System.out.println("input: " +input2+ " mySqrtWithMid: " + mySqrtWithMid(input2));
    }
}
