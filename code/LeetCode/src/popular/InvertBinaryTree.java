package popular;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x; }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sb.append(current.val).append(", ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        sb.append("]");

        return sb.toString();
    }
}

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTreeWithBreadthSearchFirst(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp =current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return root;
    }

    public static TreeNode initData() {
        int[] data = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = new TreeNode(4);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < data.length; ) {
            TreeNode currentRoot = queue.poll();
            TreeNode left = new TreeNode(data[i]);
            currentRoot.left = left;
            queue.add(currentRoot.left);
            if (i + 1 < data.length) {
                TreeNode right = new TreeNode(data[++i]);
                currentRoot.right = right;
                queue.add(currentRoot.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = initData();
        System.out.println("Input: " + root.toString());
        InvertBinaryTree obj = new InvertBinaryTree();
        obj.invertTree(root);
        System.out.println("Output: " + root.toString());
        obj.invertTreeWithBreadthSearchFirst(root);
        System.out.println("Output back: " + root.toString());
    }

}
