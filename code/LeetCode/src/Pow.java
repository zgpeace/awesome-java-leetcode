public class Pow {
    /*
    Pow(x, n)
    Description
    Implement pow(x, n), which calculates x raised to the power n (xn).

    Example 1:

    Input: 2.00000, 10
    Output: 1024.00000
    Example 2:

    Input: 2.10000, 3
    Output: 9.26100
    Example 3:

    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
    Note:

    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]
    Tags: Math, Binary Search
     */

    /*
    思路
    题意是让你计算 x^n，如果直接计算肯定会超时，那么我们可以想到可以使用二分法来降低时间复杂度。
     */

    public double myPow(double x, int n) {
        if (n < 0) {
            return helper(1/x, -n);
        }

        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double d = helper(x, (n >>> 1));
        if (n % 2 == 0) {
            return d * d;
        }

        return d * d * x;
    }

    public static void main(String[] args) {
        Pow obj = new Pow();
        double x = 2;
        int n = 10;
        System.out.println("x: " + x + " ,n: " + n + " ,pow: " + obj.myPow(x, n));
    }































}
