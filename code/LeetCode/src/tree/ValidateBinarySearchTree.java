package tree;

import common.TreeNode;

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
}
