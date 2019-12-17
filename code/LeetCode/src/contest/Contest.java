package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Contest {

  public static void main(String[] args) {

    //test1();

    //test2();

    //test3();
    //help();

    int k = 8;
    int[] inputs = {7, 9, 8, 9};
    List<Integer> aList = new ArrayList<>();
    for (int i: inputs) {
      aList.add(i);
    }


  }

  static long count = 0;

  public static void help(int index, int k, List<Integer> aList, long[] result) {
    //Arrays.fill(result, 0);
    if (index == aList.size()) {
      long sum = 0;
      for (long l: result) {
        sum += l;
      }
      if (sum == k) {
        count++;
      }
      return;
    }

    result[index] = 0;
    help(index + 1, k, aList, result);
    result[index] = aList.get(index);
    //help(index + 1, k, aList, result);
  }



  public static void test3() {
    String s = "125";
    long result = Long.parseLong(s);
    int len = s.length();
    long[] longArray = new long[s.length()];
    for (int i = 1; i < s.length() - 1; i++) {
      Arrays.fill(longArray, 0);
      for (int j = 0; j < s.length(); j++) {

      }
    }
  }


  public static void test2() {
    long minX = 0;
    long minY = 0;
    int x = 1;
    int y = 2;

    if (x > minX && y > minY) {
      minX = x;
      minY = y;
    } else {
      double mulX = 1;
      double mulY = 1;
      if (x > 0) {
        mulX = Math.ceil(1.0 * minX / x);
      }
      if (y > 0) {
        mulY = Math.ceil(1.0 * minY / y);
      }
      long mulMax = (long) Math.max(mulX, mulY);
      minX = x * mulMax;
      minY = y * mulMax;
    }

    long result = minX + minY;
    System.out.print(result);
  }



}
