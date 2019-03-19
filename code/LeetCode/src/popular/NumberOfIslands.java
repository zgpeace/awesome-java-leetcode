package popular;

import java.util.Arrays;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int rowLen = grid.length;
        int columnLen = grid[0].length;
        boolean[][] visitArray = new boolean[rowLen][columnLen];
        for (int row = 0; row < rowLen; row++) {
            for (int column = 0; column < columnLen; column++) {
                if (grid[row][column] == '1' && visitArray[row][column] == false) {
                    markConnectIsland(grid, visitArray, row, column);
                    count++;
                }
            }
        }

        return count;
    }

    private void markConnectIsland(char[][] grid, boolean[][] visitArray, int row, int column) {
        if (row < 0 || row >= grid.length) return;
        if (column < 0 || column >= grid[0].length) return;
        if (grid[row][column] != '1' || visitArray[row][column]) return;

        visitArray[row][column] = true;

        markConnectIsland(grid, visitArray, row + 1, column);
        markConnectIsland(grid, visitArray, row - 1, column);
        markConnectIsland(grid, visitArray, row, column + 1);
        markConnectIsland(grid, visitArray, row, column - 1);
    }

    public static void main(String[] args) {
        //char[][] grid = {
        //                    {'1', '1', '1', '1', '0'},
        //                    {'1', '1', '0', '1', '0'},
        //                    {'1', '1', '0', '0', '0'},
        //                    {'0', '0', '0', '0', '0'}
        //                };

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int count = new NumberOfIslands().numIslands(grid);
        System.out.println("input: " + Arrays.toString(grid) + "\nOutput:" + count );
    }
}
