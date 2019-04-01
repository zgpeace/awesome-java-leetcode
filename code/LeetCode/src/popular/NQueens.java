package popular;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static int[] rowColumnArray;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        rowColumnArray = new int[n + 1];
        // from 0 to calculate
        recursiveQueeen(0, n, resultList);

        return resultList;
    }

    public static void recursiveQueeen(int row, int length, List<List<String>> resultList) {
        if (row == length) {
            // print
            resultList.add(addValidList(length));

            return;
        }

        for (int column = 0; column < length; column++) {
            if (isOK(row, column, length)) {
                rowColumnArray[row] = column;
                recursiveQueeen(row + 1, length, resultList);
            }
        }
    }

    public static boolean isOK(int row, int column, int length) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        while (--row >= 0) {
            if (rowColumnArray[row] == column) {
                return false;
            }
            if (leftUp >= 0 && rowColumnArray[row] == leftUp) {
                return false;
            }
            if (rightUp < length && rowColumnArray[row] == rightUp) {
                return false;
            }

            leftUp--;
            rightUp++;
        }

        return true;
    }

    public static List<String> addValidList(int length) {
        List<String> list = new ArrayList<>();
        StringBuilder sb;
        System.out.println();
        for (int row = 0; row < length; row++) {
            sb = new StringBuilder();
            for (int column = 0; column < length; column++) {
                if (rowColumnArray[row] == column) {
                    sb.append('Q');
                } else {

                    sb.append('.');
                }
            }
            list.add(sb.toString());
            System.out.println(sb.toString());
        }
        System.out.println();

        return list;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }

}
