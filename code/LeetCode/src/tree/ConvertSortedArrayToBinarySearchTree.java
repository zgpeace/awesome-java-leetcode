package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedArrayToBinarySearchTree {
    // method 1: Recursive
    public TreeNode sortedArrayToBST(int[] nums) {
        // root == null
        if (nums == null || nums.length <= 0) {
            return null;
        }
        // recurcive select middle
        return selectMiddle(0, nums.length - 1, nums);
    }

    public TreeNode selectMiddle(int leftIndex, int rightIndex, int[] nums) {
        // leftIndex > rightIndex, break
        if (leftIndex > rightIndex) {
            return null;
        }
        int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = selectMiddle(leftIndex, midIndex - 1, nums);
        node.right = selectMiddle(midIndex + 1, rightIndex, nums);

        return node;
    }

    // method 2: Iterate
    public TreeNode sortedArrayToBSTWithIterate(int[] nums) {
        // root null
        if (nums == null || nums.length <= 0) {
            return null;
        }

        // queue for: root, left, right node
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        // root node
        TreeNode root = new TreeNode(0);
        nodeList.add(root);
        // queue for: leftIndex
        LinkedList<Integer> leftIndexList = new LinkedList<>();
        leftIndexList.add(0);
        // queue for: rightIndex
        LinkedList<Integer> rightIndexList = new LinkedList<>();
        rightIndexList.add(nums.length - 1);
        TreeNode node;

        // Iterate nodeLisk
        while (!nodeList.isEmpty()) {
            node = nodeList.removeFirst();
            // mid Index
            int leftIndex = leftIndexList.removeFirst();
            int rightIndex = rightIndexList.removeFirst();
            int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            node.val = nums[midIndex];

            // left node
            if (leftIndex < midIndex) {
                node.left = new TreeNode(0);
                nodeList.add(node.left);
                leftIndexList.add(leftIndex);
                rightIndexList.add(midIndex - 1);
            }

            // right node
            if (rightIndex > midIndex) {
                node.right = new TreeNode(0);
                nodeList.add(node.right);
                leftIndexList.add(midIndex + 1);
                rightIndexList.add(rightIndex);
            }
        }


        return root;
    }


}
