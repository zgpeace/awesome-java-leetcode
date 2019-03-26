package popular;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int columnLen = grid[0].length;
        int[][] sumGrid = new int[rowLen][columnLen];

        for (int row = 0; row < rowLen; row++) {
            for (int column = 0; column < columnLen; column++) {
                if (row == 0 && column == 0) {
                    // init first sum
                    sumGrid[0][0] = grid[0][0];
                } else if (row == 0 && column != 0) {
                   sumGrid[row][column] = grid[row][column] + sumGrid[row][column - 1];
                } else if (column == 0 && row != 0) {
                    sumGrid[row][column] = grid[row][column] + sumGrid[row - 1][column];
                } else {
                    sumGrid[row][column] = grid[row][column] + Math.min(sumGrid[row][column - 1], sumGrid[row - 1][column]);
                }
            }
        }

        return sumGrid[rowLen - 1][columnLen - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        MinimumPathSum obj = new MinimumPathSum();
        System.out.println("Output: " + obj.minPathSum(grid));
    }
}
