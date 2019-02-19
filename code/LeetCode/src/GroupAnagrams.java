import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /*
    Group Anagrams
    Description
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
    Tags: Hash Table, String
     */

    /*
    思路
    题意是给你一组字符串，让你把其中同位异构字符串分组，同位异构字符串就是组成字符串的字符都相同，
    但是字符放的位置可以不同。既然要分组，那么关键就是如何确定他们是同位异构字符串呢，想到的自然就是对其排序，
    排序之后他们就都是同一个字符串了，就可以归为一类了，代码如下所示。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<List<String>> resultList = new ArrayList<>();
        int i = 0;
        for (String item: strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String sortItem = String.valueOf(chars);
            if (!map.containsKey(sortItem)) {
                map.put(sortItem, i++);
                ArrayList<String> subList = new ArrayList<>();
                subList.add(item);
                resultList.add(subList);
            } else {
                resultList.get(map.get(sortItem)).add(item);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = obj.groupAnagrams(input);
        System.out.println("input: " + Arrays.toString(input));
    }




































}
