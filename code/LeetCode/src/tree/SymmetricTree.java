package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {

  public boolean isSymmetricWithRecursive(TreeNode root) {
    return isMirror(root, root);
  }

  public boolean isMirror(TreeNode leftN, TreeNode rightN) {
    if (leftN == null && rightN == null) {
      return true;
    }
    if (leftN == null || rightN == null) {
      return false;
    }
    return leftN.val == rightN.val
        && isMirror(leftN.left, rightN.right)
        && isMirror(leftN.right, rightN.left);
  }

  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode leftN = queue.poll();
      TreeNode rightN = queue.poll();
      if (leftN == null && rightN == null) {
        continue;
      }
      if (leftN == null || rightN == null) {
        return false;
      }
      if(leftN.val != rightN.val) {
        return false;
      }

      queue.add(leftN.left);
      queue.add(rightN.right);

      queue.add(leftN.right);
      queue.add(rightN.left);
    }

    return true;
  }
}
