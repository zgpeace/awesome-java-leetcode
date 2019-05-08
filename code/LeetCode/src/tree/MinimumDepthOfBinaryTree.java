package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//  https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {

  // Breath First Search by iterate
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int result = 0;
    int currentLength;
    boolean breakFlag;
    TreeNode currentNode;
    while (!queue.isEmpty()) {
      result++;
      currentLength = queue.size();
      breakFlag = false;
      for (int i = 0; i < currentLength; i++) {
        currentNode = queue.poll();
        if (currentNode.left == null && currentNode.right == null) {
          breakFlag = true;
          break;
        }
        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }
      if (breakFlag) {
        break;
      }
    }

    return result;
  }

  // Depth First Search
  public int minDepthDSF(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = minDepth(root.left);
    if (root.right == null) {
      return leftDepth + 1;
    }
    int rightDepth = minDepth(root.right);
    if (root.left == null) {
      return rightDepth + 1;
    }

    return Math.min(leftDepth, rightDepth) + 1;

  }



}
