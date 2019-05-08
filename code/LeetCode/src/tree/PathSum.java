package tree;

import common.TreeNode;

//  https://leetcode.com/problems/path-sum/
public class PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    // valid root is leaf
    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }
    sum -= root.val;
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}
