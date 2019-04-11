package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class TreeLevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // root == null
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        // queue LinkedList for breadth search
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode;
        while (!queue.isEmpty()) {
            // current length
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            // iterate each depth
            for (int i = 0; i < length; i++) {
                currentNode = queue.pop();
                list.add(currentNode.val);

                // add tail data in queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // insert data in 0 position
            resultList.add(0, list);
        }

        // return result list
        return resultList;
    }

    public List<List<Integer>> levelOrderBottomWithRecursive(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        depthSearchFirst(0, root, resultList);

        return resultList;
    }

    public void depthSearchFirst(int level, TreeNode node, List<List<Integer>> resultList) {
            // null
            if (node == null) {
                return;
            }
            // create item List<Integer> when size <= level
            if (resultList.size() <= level) {
                // warning: must add new item at first place. Because the left node will execute first.
                resultList.add(0, new ArrayList<Integer>());
            }
            // left node
            depthSearchFirst(level + 1, node.left, resultList);
            // right node
            depthSearchFirst( level + 1, node.right, resultList);
            // add item Integer
            resultList.get(resultList.size() - level - 1).add(node.val);
    }


}
