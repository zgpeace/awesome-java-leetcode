package tree;

import common.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


    public boolean isBalancedWithDfsDepth(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    public int dfsDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfsDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = dfsDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
