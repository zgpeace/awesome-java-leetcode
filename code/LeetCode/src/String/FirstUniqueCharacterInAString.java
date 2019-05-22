package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    // order map<char, index>
    HashMap<Character, Integer> map = new HashMap<>();
    int n = s.length();
    // iterate s
    for (int i = 0; i < n; i++) {
      Character c = s.charAt(i);
      // if no repeat is 1; else count++
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (int j = 0; j < n; j++) {
      // if no repeat is 1
      if (map.get(s.charAt(j)) == 1) {
        return j;
      }
    }

    return -1;
  }
}
