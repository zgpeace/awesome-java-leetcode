public class DiameterOfBinaryTree {
    /*
    Diameter of Binary Tree
    Description
    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example: Given a binary tree

              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.

    Tags: Tree
     */

    /*
    思路
    题意是让你算出二叉树中最远的两个节点的距离，分别计算左右子树的最大高度，
    然后不断迭代出其和的最大值就是最终结果。
     */

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);

        return max;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftInt = helper(node.left);
        int rightInt = helper(node.right);
        int distance = leftInt + rightInt;
        if (distance > max) {
            max = distance;
        }
        return 1 + Math.max(leftInt, rightInt);
    }













































}
