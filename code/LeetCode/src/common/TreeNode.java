package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() { }
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }

    @Override
    public String toString() {
        if (this == null) {
            return "null";
        }

        String result = "";
        List<String> row = null;
        List<List<String>> list = new ArrayList<List<String>>();

        LinkedList<TreeNode> rowNode = new LinkedList<>();
        rowNode.add(this);
        while (!rowNode.isEmpty()) {
            int rowSize = rowNode.size();
            row = new ArrayList<String>();

            int rowCount = rowSize;
            int nullCount = 0;
            while (rowSize > 0) {
                TreeNode current = rowNode.pop();
                if (current == null) {
                    row.add("null");
                    nullCount++;
                } else {
                    row.add(Integer.toString(current.val));
                }

                if (current == null || current.left == null) {
                    rowNode.add(null);
                } else {
                    rowNode.add(current.left);
                }
                if (current == null || current.right == null) {
                    rowNode.add(null);
                } else {
                    rowNode.add(current.right);
                }

                rowSize--;
            }

            if (nullCount == rowCount) {
                break;
            }

            list.add(row);
        }

        // print data
        String blank = "    ";
        for (int i = 0; i < list.size(); i ++) {
            for (int j = i; j < list.size(); j++) {
                // print blank
                System.out.print(blank);
            }
            List<String> rowList = list.get(i);
            for (int k = 0; k < rowList.size(); k++) {
                System.out.print(rowList.get(k));
                System.out.print(blank);
            }

            System.out.println();
        }


        //return Arrays.toString(list.toArray());

        return super.toString();
    }
}
