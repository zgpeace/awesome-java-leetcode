import java.util.LinkedList;

public class SymmetricTree {
    /*
    Symmetric Tree
    Description
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:

        1
       / \
      2   2
       \   \
       3    3
    Note:

    Bonus points if you could solve it both recursively and iteratively.

    Tags: Tree, Depth-first Search, Breadth-first Search
     */

    /*
    思路 0
    题意是判断一棵二叉树是否左右对称，首先想到的是深搜，比较根结点的左右两棵子树是否对称，
    如果左右子树的值相同，那么再分别对左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点做比较即可。
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetricHelper(root.left, root.right);
    }

    public boolean symmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }

        return leftNode.val == rightNode.val && symmetricHelper(leftNode.left, rightNode.right) && symmetricHelper(leftNode.right, rightNode.left);

    }

    /*
    思路 1
    第二种思路就是宽搜了，宽搜肯定要用到队列，Java 中可用 LinkedList 替代，也是要做到左子树的左节点和右子树的右节点，
    左子树的右节点和右子树的左节点做比较即可。
     */
    public boolean isSymmetricWithBroadSearch(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        while (list.size() > 0) {
            leftNode = list.pop();
            rightNode = list.pop();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            list.add(leftNode.left);
            list.add(rightNode.right);

            list.add(leftNode.right);
            list.add(rightNode.left);
        }

        return true;
    }








































}
