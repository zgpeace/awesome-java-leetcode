package array;

// https://leetcode.com/problems/rotate-image/
public class RotateImage {

  /**
   * Given input matrix =
   * [
   *   [1,2,3],
   *   [4,5,6],
   *   [7,8,9]
   * ],
   *
   * rotate the input matrix in-place such that it becomes:
   * [
   *   [7,4,1],
   *   [8,5,2],
   *   [9,6,3]
   * ]
   */
  public void rotate(int[][] matrix) {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    // check edge
    if (matrix == null || matrix.length <= 1) {
      return;
    }

    // step 1 > reverse up to down: i < len 2;  row[i] <-> row[len - i -1]

    /*  7,8,9
        4,5,6
        1,2,3
    */
    int len = matrix.length;
    for (int row = 0; row < len / 2; row++) {
      int[] temp = matrix[row];
      int downIndex = len - 1 - row;
      matrix[row]= matrix[downIndex];
      matrix[downIndex] = temp;
    }

    // step 2 > swap the symmetry: row[0,len - 1], col[row, len - 1]

    /*  7,4,1
        8,5,2
        9,6,3
    */
    for (int row = 0; row < len; row++) {
      for (int col = row + 1; col < len; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }

  }

  public void rotateWithFourPoint(int[][] matrix) {
    if (matrix == null || matrix.length <= 1) {
      return;
    }
    int len = matrix.length;
    for (int row = 0; row < len / 2; row++) {
      for (int col = row; col < len - 1 - row; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[len - 1 - col][row];
        matrix[len - 1 - col][row] = matrix[len - 1 - row][len - 1 - col];
        matrix[len - 1 - row][len - 1 - col] = matrix[col][len - 1 - row];
        matrix[col][len - 1 - row] = temp;
      }
    }
  }
}
