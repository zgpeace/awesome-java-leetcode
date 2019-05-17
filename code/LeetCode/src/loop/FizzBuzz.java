package loop;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        list.add("FizzBuzz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else {
        list.add(Integer.toString(i));
      }
    }

    return list;
  }

  public List<String> fizzBuzzWithPlus(int n) {
    List<String> list = new ArrayList<>();
    int fizz = 0;
    int buzz = 0;
    for (int i = 1; i <= n; i++) {
      fizz++;
      buzz++;
      if (fizz == 3 && buzz == 5) {
        list.add("FizzBuzz");
        fizz = 0;
        buzz = 0;
      } else if (fizz == 3) {
        list.add("Fizz");
        fizz = 0;
      } else if (buzz == 5) {
        list.add("Buzz");
        buzz = 0;
      } else {
        list.add(Integer.toString(i));
      }
    }

    return list;
  }
}
