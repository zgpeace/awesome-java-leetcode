import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    /*
    Binary Tree Level Order Traversal II
    Description
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:

    [
      [15,7],
      [9,20],
      [3]
    ]
    Tags: Tree, Breadth-first Search
     */

    /*
    思路 0
    题意是从下往上按层遍历二叉树，每一层是从左到右，按层遍历，很明显，
    宽搜第一时间符合，因为是从下往上，所以插入的时候每次插到链表头即可。
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                subList.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }

            list.add(0, subList);
        }

        return list;
    }

    /*
    思路 1
    另一种思路就是深搜，深搜的时候同时记录深度，然后在相应的层插入节点值即可。
     */
    public List<List<Integer>> levelOrderBottomWithDeepestFirst(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helperWithDeepestFirst(list, root, 0);

        return list;
    }

    public  void helperWithDeepestFirst(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        helperWithDeepestFirst(list, root.left, level + 1);
        helperWithDeepestFirst(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);

    }



































}
