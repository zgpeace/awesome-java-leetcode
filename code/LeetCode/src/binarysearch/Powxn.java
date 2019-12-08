package binarysearch;

public class Powxn {

  public static void main(String[] args) {
    Powxn obj = new Powxn();
    System.out.println("Input:2.000, -2147483648 >>  " + obj.myPow(2.000, -2147483648) );
    System.out.println("Input:2.000, -2 >>  " + obj.myPow(2.000, -2) );
    System.out.println("Input:2.000, 10 >>  " + obj.myPow(2.000, 10) );
    System.out.println("Input:2.1, 3 >> " + obj.myPow(2.1, 3) );

    System.out.println("=========================");

    System.out.println("Input:2.000, -2147483648 >>  " + obj.myPowWithIterate(2.000, -2147483648) );
    System.out.println("Input:2.000, -2 >>  " + obj.myPowWithIterate(2.000, -2) );
    System.out.println("Input:2.000, 10 >>  " + obj.myPowWithIterate(2.000, 10) );
    System.out.println("Input:2.1, 3 >> " + obj.myPowWithIterate(2.1, 3) );
  }

  public double myPow(double x, int n) {
    if (n < 0) {
      // consider -n overflow
      return 1/x * myPow(1/x, -(n + 1));
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }

    int halfN = n >> 1;
    return (n%2 == 0) ? myPow(x * x, halfN) : myPow( x * x, halfN) * x;
  }


  public double myPowWithIterate(double x, int n) {
    double result = 1;
    if (n < 0) {
      // consider -n overflow
      x = 1/x;
      n = -(n + 1);
      result = x;
    }

    while (n != 0) {
      if (n % 2 == 1) {
        result *= x;
        if (n == 1) {
          break;
        }
      }

      x = x * x;
      n = n >> 1;
    }

    return result;
  }
}
