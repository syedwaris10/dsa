package com.tree;

public class FlattenBST {

    TreeNode prev = null;
    public TreeNode flattenBST(TreeNode root) {
        if (root == null) return null;

        flattenBST(root.left);
        flattenBST(root.right);

        root.left = null;
        root.right = prev;

        prev = root;

        return root;
    }


    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(8));

        TreeNode root = new TreeNode(5, left, right);

        FlattenBST flattenBST = new FlattenBST();
        flattenBST.flattenBST(root);
    }
}
