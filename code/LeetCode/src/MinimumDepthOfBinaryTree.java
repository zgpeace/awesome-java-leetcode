import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {
    /*
    Minimum Depth of Binary Tree
    Description
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its minimum depth = 2.

    Tags: Tree, Depth-first Search, Breadth-first Search
     */

    /*
    思路 0
    题意是查找二叉树的最小深度，也就是找到从根结点到叶子节点的最小深度，最容易想到的当然是深搜，
    如果节点的左右深度都不是 0 的话，说明该节点含有左右子树，所以它的最小高度就是 1 加上其左右子树高度较小者，
    否则如果左子树为空或者右子树为空或者两者都为空，那么就是 1 加上非空子树高度。
     */

    public int minDepthWithDeepFirst(TreeNode root) {
        return helperForDeepFirst(root);
    }

    public int helperForDeepFirst(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftInt = helperForDeepFirst(node.left);
        int rightInt = helperForDeepFirst(node.right);
        if (leftInt != 0 && rightInt != 0) {
            return 1 + Math.min(leftInt, rightInt);
        }
        return 1 + leftInt + rightInt;
    }

    /*
    思路 1
    第二种思路就是利用宽搜了，搜索到该层有叶子节点，那就返回该层宽度即可。
     */
    public int minDepthWithBreadthFirst(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int minDepth = 1;
        while (list.size() != 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pop();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }

                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }

            }

            minDepth++;
        }

        return minDepth;
    }























}
