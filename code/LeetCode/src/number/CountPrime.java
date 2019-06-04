package number;

import java.util.ArrayList;
import java.util.List;

public class CountPrime {
  public static int countPrimes(int n) {
    List<Integer> list = new ArrayList<>();
    if (n > 2) {
      list.add(2);
    }
    for (int i = 3; i < n; i++) {
      for (int k: list) {
        if (i % k == 0) {
          break;
        }
        if (k > i / k) {
          list.add(i);
          break;
        }
      }
    }

    System.out.println(list);
    return list.size();
  }

  public int countPrimesWithBoolArray(int n) {
    if (n < 3) {
      return 0;
    }
    boolean[] array = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (array[i] == false) {
        count++;
        for (int k = 2; i * k < n; k++) {
          array[i * k] = true;
        }
      }
    }

    return count;
  }

  public int countPrimesWithReduseEven(int n){
    if (n < 3) {
      return 0;
    }
    boolean[] evenArray = new boolean[n];
    // Arrays.fill(evenArray, true); boolean[] are initialed as false by default
    int count = n / 2;
    for (int i = 3; i * i < n; i += 2) {
      if (evenArray[i]) {
        continue;
      }
      for(int k = i * i; k < n; k = k + i * 2) {
        if (evenArray[k] == false) {
          evenArray[k] = true;
          count--;
        }
      }
    }

    return count;
  }
}
