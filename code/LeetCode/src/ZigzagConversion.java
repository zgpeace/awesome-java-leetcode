public class ZigzagConversion {
    /*
    ZigZag Conversion
    Description
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
    Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"
    Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    Tags: String
     */

    /*
    思路 0
    题意是让你把字符串按波浪形排好，然后返回横向读取的字符串。

    听不懂的话，看下面的表示应该就明白了：

    0                           2n-2                        4n-4
    1                    2n-3   2n-1                 4n-5   4n-3
    2              2n-4         2n               4n-6       .
    .           .               .             .             .
    .       n+1                 .          3n-1             .
    n-2   n                     3n-4   3n-2                 5n-6
    n-1                         3n-3                        5n-5
    那么我们可以根据上面找规律，可以看到波峰和波谷是单顶点的，它们周期是 2 * (n - 1)，单独处理即可；
    中间的部分每个周期会出现两次，规律很好找，留给读者自己想象，不懂的可以结合以下代码。
     */

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        int cycleInt = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        //first row
        for (int i = 0; i < length; i += cycleInt) {
            sb.append(chars[i]);
        }

        //middle rows
        for (int i = 1; i < numRows - 1; i++) {
            int step = i * 2;
            for (int j = i; j < length; j += step) {
                sb.append(chars[j]);
                step = cycleInt - step;
            }
        }

        //last row
        for (int i = numRows - 1; i < length; i += cycleInt) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    /*
    思路 1
    另外一种思路就是开辟相应行数的 StringBuilder 对象，
    然后模拟波浪生成的样子分别插入到相应的 StringBuilder 对象，比较直白简单，具体代码如下。
     */
    public String convertWithRowSubBuilder(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int length = s.length();
        int cycle = 2 * (numRows - 1);
        char[] chars = s.toCharArray();
        StringBuilder[] rowSb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rowSb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < length) {
            for (int j = 0; j < numRows && i < length; ++j) {
                rowSb[j].append(chars[i++]);
            }
            for (int j = numRows - 2; j >= 1  && i < length; --j) {
                rowSb[j].append(chars[i++]);
            }
            
        }
        for (int j = 1; j < numRows; j++) {
            rowSb[0].append(rowSb[j]);
        }
        
        return rowSb[0].toString();
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int row = 3;
        ZigzagConversion obj = new ZigzagConversion();
        //PAHNAPLSIIGYIR
//        String output = obj.convert(input, row);
        String output = obj.convertWithRowSubBuilder(input, row);

        System.out.println("input: " + input + " , output: " + output);
    }









































}
