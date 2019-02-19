import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    /*
    Pascal's Triangle
    Description
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    img In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    Tags: Array
     */

    /*
    思路
    题意是给出行数，输出帕斯卡尔三角形，很简单的模拟，就不多说了。
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    subList.add(1);
                    continue;
                }

                List<Integer> preList = list.get(i - 1);
                subList.add(preList.get(j - 1) + preList.get(j));
            }

            list.add(subList);
        }

        return list;
    }



























}
