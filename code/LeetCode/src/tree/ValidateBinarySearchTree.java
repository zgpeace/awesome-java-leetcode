package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isValidBSTWithLowerAndUpper(root, null, null);
  }

  public boolean isValidBSTWithLowerAndUpper(TreeNode root, Integer lower, Integer upper) {
    if (root == null) {
      return true;
    }
    if (lower != null && root.val <= lower) {
      return false;
    }
    if (upper != null && root.val >= upper) {
      return false;
    }


    return isValidBSTWithLowerAndUpper(root.left, lower, root.val) && isValidBSTWithLowerAndUpper(root.right, root.val, upper);
  }

  public boolean isValidBSTWithIterate(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    Queue<Integer> valleyQueue = new LinkedList<>();
    valleyQueue.add(null);
    Queue<Integer> peakQueue = new LinkedList<>();
    peakQueue.add(null);
    TreeNode current;
    Integer valley;
    Integer peak;
    while (!queue.isEmpty()) {
      current = queue.poll();
      valley = valleyQueue.poll();
      peak = peakQueue.poll();
      if (valley != null && current.val <= valley) {
        return false;
      }
      if (peak != null && current.val >= peak) {
        return false;
      }

      if (current.left != null) {
        queue.add(current.left);
        valleyQueue.add(valley);
        peakQueue.add(current.val);
      }

      if (current.right != null) {
        queue.add(current.right);
        valleyQueue.add(current.val);
        peakQueue.add(peak);
      }

    }

    return true;
  }
}
