package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    System.out.println("map coantins 0 > " + map.get(0) + " > validate bolean :" + map.containsKey(0));
  }

  public boolean isValidSudokuWithOneHashset(char[][] board) {
    HashSet<String> set = new HashSet<>();
    char item;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        item = board[i][j];
        if (item == '.') {
          continue;
        }
        if (!set.add(item + "row" + i)) {
          return false;
        }
        if (!set.add(item + "col" + j)) {
          return false;
        }
        if (!set.add(item + "block" + i/3 + "_" + j/3)) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean isValidSudokuWithHashset(char[][] board) {

    for (int i = 0; i < 9; i++) {
      HashSet<Character> rowSet = new HashSet<>();
      HashSet<Character> colSet = new HashSet<>();
      HashSet<Character> blockSet = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
          return false;
        }
        if (board[j][i] != '.' && !colSet.add(board[j][i])) {
          return false;
        }
        int row = 3 * (i / 3);
        int col = 3 * (i % 3);
        int rowIndex = row + j / 3;
        int colIndex = col + j % 3;
        if (board[rowIndex][colIndex] != '.' && !blockSet.add(board[rowIndex][colIndex])) {
          return false;
        }

      }
    }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    // init data
    Map<String, Map<Character, Integer>> containMap = new HashMap<>();
    String rowPre = "row_";
    String columnPre = "col_";
    String blockConnect = "_";
    // row & column map
    for (int i = 0; i < 9; i++) {
      // row key : row_index
      containMap.put(rowPre + i, new HashMap<Character, Integer>());
      // column key: clo_index
      containMap.put(columnPre + i, new HashMap<Character, Integer>());
    }
    // block map, key style: rowIndex_colIndex
    for (int i = 0; i < 3; i++) {
      for (int k = 0; k < 3; k++) {
        containMap.put(i + blockConnect + k, new HashMap<Character, Integer>());
      }
    }

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        if (board[r][c] == '.') {
          continue;
        }
        // row char
        if (containMap.get(rowPre + r).containsKey(board[r][c])) {
          return false;
        } else {
          containMap.get(rowPre + r).put(board[r][c], c);
        }
        // column char
        if (containMap.get(columnPre + c).containsKey(board[r][c])) {
          return false;
        } else {
          containMap.get(columnPre + c).put(board[r][c], r);
        }

        // block
        int blockRow = r / 3;
        int blockColumn = c / 3;
        String blockKey = blockRow+blockConnect+blockColumn;
        if (containMap.get(blockKey).containsKey(board[r][c])) {
          return false;
        } else {
          containMap.get(blockKey).put(board[r][c], c);
        }
      }

    }

    return true;
  }
}
