package popular;

import java.util.Arrays;
import java.util.List;

public class EightQueen {

    static int[] result = new int[8];
    static int count = 1;
    static int step = 1;
    public static void eightQueen(int row) {
        // row == 8, print & return
        if (row == 8) {
            //print
            printQueens(result);
            System.out.println("------"+ count++ +"------");
            return;
        }

        // for each column
        for (int column = 0; column < 8; column++) {

            if (isOK(row, column)) {
                result[row] = column;
                System.out.println("result[" + row + "] = " + column);
                eightQueen(row + 1);
            }
        }

    }

    public static boolean isOK(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;

        while (--row >= 0) {
            System.out.println("---step---" + step++);
            // vertical direction duplicate
            if (result[row] == column) {
                return false;
            }
            // left diagonal duplicate
            if (leftUp >= 0 && result[row] == leftUp) {
                return false;
            }
            // right diagonal duplicate
            if (rightUp < 8 && result[row] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        System.out.println("---step---" + step++);

        return true;
    }

    public static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //eightQueen(0);
        int[] arr = {1, 2, 3, 5};
    }
}
