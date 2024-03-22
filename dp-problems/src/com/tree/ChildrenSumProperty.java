package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {
    public static int isSumProperty(TreeNode root)
    {
        if (root == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                TreeNode node = q.poll();
                int left = 0;
                int right = 0;

                if (node.left == null && node.right == null) {
                    continue;
                }

                if (node.left != null) {
                    q.add(node.left);
                    left = node.left.val;
                }

                if (node.right != null) {
                    q.add(node.right);
                    right = node.right.val;
                }

                if (node.val != left + right) {
                    return 0;
                }

                size--;
            }
        }

        return 1;

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(10);
        TreeNode root = new TreeNode(10, left, null);

        int ans = ChildrenSumProperty.isSumProperty(root);
        System.out.println(ans);
    }
}
