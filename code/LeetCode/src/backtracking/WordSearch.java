package backtracking;

// https://leetcode.com/problems/word-search/
public class WordSearch {

  public static void main(String[] args) {
    WordSearch obj = new WordSearch();
    char[][] board = {{'A','B','C','E'},
                      {'S','F','C','S'},
                      {'A','D','E','E'}};
    //String word = "ABCCED";
    //String word = "SEE";
    String word = "ABCB";
    boolean result = obj.exist(board, word);
    System.out.println("result > " + result);
  }

  public boolean exist(char[][] board, String word) {
    // check edge
    if (word == null || word.length() == 0) {
      return true;
    }
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }
    // used boolean
    boolean[][] used = new boolean[board.length][board[0].length];

    // dfs
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (dfs(board, word, used, row, col, 0)) {
          return true;
        }
      }
    }


    return false;
  }

  private boolean dfs(char[][] board, String word, boolean[][] used, int row, int col, int wordIndex) {
    if (word == null || wordIndex == word.length()) {
      return true;
    }
    char currentChar = word.charAt(wordIndex);
    if (row < 0 || col < 0
        || row >= board.length || col >= board[row].length
        || currentChar != board[row][col] || used[row][col])
    {
      return false;
    }
    // mark use
    used[row][col] = true;
    boolean result = dfs(board, word, used, row + 1, col, wordIndex + 1)
        || dfs(board, word, used, row - 1, col, wordIndex + 1)
        || dfs(board, word, used, row, col + 1, wordIndex + 1)
        || dfs(board, word, used, row, col - 1, wordIndex + 1);

    // mark not use
    used[row][col] = false;

    return result;
  }
}
