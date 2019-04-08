import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {
    /*
    Same Tree
    Description
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

    Example 1:

    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]

    Output: false
    Example 3:

    Input:     1         1
              / \       / \
             2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false
    Tags: Tree, Depth-first Search
     */

    /*
    思路
    题意是比较两棵二叉树是否相同，那么我们就深搜比较各个节点即可。
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    public static boolean checkTreeNode(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }

        return true;
    }

    public static boolean isSameTreeWithIterate(TreeNode p, TreeNode q) {
        if (!checkTreeNode(p, q)) {
            return false;
        }
        Deque<TreeNode> dequeP = new ArrayDeque<>();
        Deque<TreeNode> dequeQ = new ArrayDeque<>();
        if (p != null) {
            dequeP.push(p);
            dequeQ.push(q);
        }
        TreeNode firstP;
        TreeNode firstQ;
        while (!dequeP.isEmpty()) {
            firstP = dequeP.removeFirst();
            firstQ = dequeQ.removeFirst();
            if (!checkTreeNode(firstP, firstQ)) {
                return false;
            }
            if (!checkTreeNode(firstP.left, firstQ.left)) {
                return false;
            }
            if (firstP.left != null) {
                dequeP.push(firstP.left);
                dequeQ.push(firstQ.left);
            }
            if (!checkTreeNode(firstP.right, firstQ.right)) {
                return false;
            }
            if (firstP.right != null) {
                dequeP.push(firstP.right);
                dequeQ.push(firstQ.right);
            }
        }

        return true;
    }














































}
