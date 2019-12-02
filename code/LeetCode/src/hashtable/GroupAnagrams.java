package hashtable;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] inputs = {"eat","tea","tan","ate","nat","bat"};
    GroupAnagrams obj = new GroupAnagrams();
    obj.groupAnagrams(inputs);
  }

  public List<List<String>> groupAnagramsWithCharCount(String[] strs) {
    // edge check
    if (strs == null || strs.length == 0) {
      return null;
    }
    Map<String, List<String>> map = new HashMap<>();
    int[] charCountArray = new int[26];
    // build map
    for (String s: strs) {
      Arrays.fill(charCountArray, 0);
      for (char c: s.toCharArray()) {
        charCountArray[(c - 'a')]++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i: charCountArray) {
        sb.append('#');
        sb.append(i);
      }

      String sortItem = sb.toString();
      if (!map.containsKey(sortItem)) {
        map.put(sortItem, new ArrayList<String>());
      }

      map.get(sortItem).add(s);
    }

    return new ArrayList<>(map.values());

  }


  private String sort(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public List<List<String>> groupAnagramsWithMap(String[] strs) {
    // edge check
    if (strs == null || strs.length == 0) {
      return null;
    }
    Map<String, List<String>> map = new HashMap<>();
    // build map
    for (String s: strs) {
      String sortItem = sort(s);
      if (!map.containsKey(sortItem)) {
        map.put(sortItem, new ArrayList<String>());
      }

      map.get(sortItem).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    for (String s: strs) {
      String sortString = sort(s);
      boolean isSame = false;
      for (List<String> list: result) {
        String item = list.get(0);
        if (sortString.length() == item.length() && sort(item).equals(sortString)) {
          list.add(s);
          isSame = true;
          break;
        }
      }

      if (isSame == false) {
        result.add(new ArrayList<>(Arrays.asList(s)));
      }

    }

    return result;
  }
}
