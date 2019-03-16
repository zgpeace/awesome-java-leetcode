package popular;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return subIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean subIsValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) return false;
        return subIsValidBST(root.left, minValue, root.val) && subIsValidBST(root.right, root.val, maxValue);
    }
}
