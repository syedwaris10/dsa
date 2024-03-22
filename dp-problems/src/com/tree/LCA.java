package com.tree;

import java.util.*;

public class LCA {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> qu = new LinkedList<>();
        Map<TreeNode, TreeNode> pmap = new HashMap<>();
        qu.add(root);
        pmap.put(root, null);

        while (!pmap.containsKey(p) || !pmap.containsKey(q)) {
            TreeNode node = qu.remove();
            if (node.left != null) {
                pmap.put(node.left, node);
                qu.add(node.left);
            }
            if (node.right != null) {
                pmap.put(node.right, node);
                qu.add(node.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = pmap.get(p);
        }

        while (!set.contains(q)) {
            q = pmap.get(q);
        }
        return q;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left != null && root.right != null) {
                printSuccessorOfBST(root.right);
                TreeNode succ = list.get(0);
                root.val = succ.val;
                succ = null;
                return root;
            }

            if (root.left == null) return root.right;
            else return root.left;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public void printSuccessorOfBST(TreeNode root) {
        if (root == null) return;
        printSuccessorOfBST(root.left);
        list.add(root);
        printSuccessorOfBST(root.right);
    }

    public TreeNode getSucc(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root;

        return getSucc(root.left);
    }


    public List<Integer> kDistance(TreeNode root, TreeNode target, int k) {

        if (root == null) return new ArrayList<>();

        Map<TreeNode, TreeNode> map = new HashMap(); //parent
        Queue<TreeNode> q = new LinkedList<>();
        map.put(root, null);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                q.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                map.put(node.right, node);
            }
        }

        q.clear();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty() && k >= 0) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.remove();
                if (visited.contains(node)) {
                    size--;
                    continue;
                }

                visited.add(node);
                if (k == 0) {
                    ans.add(node.val);
                }
                if (map.get(node) != null) {
                    q.add(map.get(node));
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                size--;
            }

            k--;
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, new TreeNode(2), new TreeNode(7, null, null));
        TreeNode right = new TreeNode(16, null, new TreeNode(20));
        TreeNode root = new TreeNode(10, left, right);

        LCA lca = new LCA();
        //root = lca.deleteNode(root, 3);
        //System.out.println(root);


//        TreeNode node = lca.lca(root, root.left, root);
//        System.out.println(node.val);

        //lca.kDistance(root, left, 2);

        TreeNode node = lca.getSucc(root.left.right);
        System.out.println(node.val);
    }
}
