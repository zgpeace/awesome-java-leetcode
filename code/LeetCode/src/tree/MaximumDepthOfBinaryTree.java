package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

  public int maxDepthWithDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepthWithDFS(root.left), maxDepthWithDFS(root.right)) + 1;
  }

  public int maxDepthWithBFS(TreeNode root) {
    int max = 0;
    if (root == null) {
      return max;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode current;
    while (!queue.isEmpty()) {
      max++;
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        current = queue.poll();
        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }
    }

    return max;
  }
}
