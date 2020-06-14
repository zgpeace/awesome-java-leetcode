package tree;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class ConvertBSTToGreaterTree {

  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      sum += root.val;
      root.val = sum;
      convertBST(root.left);
    }

    return root;
  }

  public static void main(String[] args) {
    //TreeNode left1 = new TreeNode(2);
    //TreeNode right1 = new TreeNode(13);
    //
    //TreeNode root = new TreeNode(5, left1, right1);

    TreeNode left1 = new TreeNode(1);
    TreeNode right1 = new TreeNode(3);

    TreeNode rootLeft = new TreeNode(2, left1, right1);

    TreeNode left2 = new TreeNode(6);
    TreeNode right2 = new TreeNode(15);

    TreeNode rootRight = new TreeNode(13, left2, right2);

    TreeNode root = new TreeNode(5, rootLeft, rootRight);

    root.toString();
    ConvertBSTToGreaterTree obj = new ConvertBSTToGreaterTree();
    TreeNode result = obj.convertBST(root);
    result.toString();
  }
}
