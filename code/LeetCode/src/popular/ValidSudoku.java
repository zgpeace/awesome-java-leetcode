package popular;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> visitSet = new HashSet<>(81);
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char data = board[row][column];
                if (data == '.') {
                    continue;
                }
                if (!visitSet.add(data + " row " + row)) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " row " + row);
                    return false;
                }
                if (!visitSet.add(data + " column " + column)) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " column " + column);
                    return false;
                }
                if (!visitSet.add(data + " cube " + row/3 + '-' + column/3) ) {
                    System.out.println("duplicate board[" + row + "][" + column + "]" + " ;data: " + data+ " cube " + row/3 + '-' + column/3);
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku obj = new ValidSudoku();
        System.out.println("Output 1: " + obj.isValidSudoku(board1));
        System.out.println("Output 2: " + obj.isValidSudoku(board2));

    }
}
