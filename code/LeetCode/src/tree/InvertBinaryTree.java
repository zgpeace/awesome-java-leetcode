package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//  https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode leftNode = invertTree(root.left);
    TreeNode rightNode = invertTree(root.right);

    root.left = rightNode;
    root.right = leftNode;

    return root;
  }

  public TreeNode invertTreeWithBFS(TreeNode root) {
    if (root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode leftNode;
    TreeNode currentNode;
    while (!queue.isEmpty()) {
      currentNode = queue.poll();
      leftNode = currentNode.left;
      currentNode.left = currentNode.right;
      currentNode.right = leftNode;

      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }

    }

    return root;
  }

}
