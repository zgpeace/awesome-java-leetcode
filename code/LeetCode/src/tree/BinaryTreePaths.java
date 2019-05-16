package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<String> list = new ArrayList<>();
    dfs("", root, list);

    return list;
  }

  private void dfs(String s, TreeNode root, List<String> list) {
    s += Integer.toString(root.val);

    if (root.left == null && root.right == null) {
      list.add(s);
    }
    s += "->";
    if (root.left != null) {
      dfs(s, root.left, list);
    }
    if (root.right != null) {
      dfs(s, root.right, list);
    }
  }

  public List<String> binaryTreePathsWithStack(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Stack<TreeNode> stack = new Stack<>();
    Stack<String> pathStack = new Stack<>();
    stack.push(root);
    TreeNode current;
    List<String> list = new ArrayList<>();
    String s = "";
    pathStack.push(s);
    while (!stack.isEmpty()) {
      current = stack.pop();
      s = pathStack.pop();
      s += Integer.toString(current.val);
      if (current.left == null && current.right == null) {
        list.add(s);
      }
      s += "->";
      if (current.left != null) {
        stack.push(current.left);
        pathStack.push(s);
      }
      if (current.right != null) {
        stack.push(current.right);
        pathStack.push(s);
      }
    }

    return list;
  }
}
