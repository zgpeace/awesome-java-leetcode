import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    /*
    Pascal's Triangle II
    Description
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

    Note that the row index starts from 0.

    img In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 3
    Output: [1,3,3,1]
    Follow up:

    Could you optimize your algorithm to use only O(k) extra space?

    Tags: Array
     */

    /*
    思路
    题意是指定输出帕斯卡尔三角形的某一行，模拟即可，
    观察规律：
    1、每行的个数为rowIndex + 1, 比如 rowIndex = 0, num = 1
    2、下一行比上一行多一个数，比如 f(n + 1) - f(n) = 1
    3、每行的首尾都是1，所以只要计算1 ~ Max - 1。
    4、O(k)的空间只能用一维数组，为了不污染前面的数据，所以送从后面算起即可
    优化后的代码如下所示。
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }

        return list;
    }

















































}
