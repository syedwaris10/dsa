package com.tree;

public class FloorinBST {
    static int ans = 0;
    public static int floorInBST(TreeNode root, int X) {
        if (root == null) return X;
        FloorinBST.ans = X;
        inorder(root, X);
        return ans;
    }

    private static void inorder(TreeNode root, int X) {
        if (root == null) return;


        if (root.val <= X && ans <= root.val) {
            ans = root.val;
        }
        inorder(root.left, X);
        inorder(root.right, X);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, new TreeNode(2), new TreeNode(7, null, null));
        TreeNode right = new TreeNode(16, null, new TreeNode(20));
        TreeNode root = new TreeNode(10, left, right);

        int ans = FloorinBST.floorInBST(root, 16);
        System.out.println(ans);
    }
}
