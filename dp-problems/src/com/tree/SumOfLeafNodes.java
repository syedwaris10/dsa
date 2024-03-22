package com.tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeafNodes {
    static int sum = 0;
    public static int sumOfLeafNodes(TreeNode root)
    {
        inorder(root);
        return sum;

    }
    private static void inorder(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        inorder(root.left);
        inorder(root.right);



    }

    public static void main(String[] args) {
        List<Boolean> l = new ArrayList<>();
        l.add(false);
        l.set(0, true);
//        TreeNode root = new TreeNode(45, null, null);
//        int ans = SumOfLeafNodes.sumOfLeafNodes(root);
//        System.out.println(ans);
    }
}
