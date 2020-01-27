package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 2:36 下午
 */
public class P1123 {
    private TreeNode node;
    private int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        calculateDepth(root, 0);
        return node;
    }

    private int calculateDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;
        int left = calculateDepth(root.left, depth+1);
        int right = calculateDepth(root.right, depth+1);
        if (left == right && left >= maxDepth) {
            maxDepth = left;
            node = root;
        }
        return Math.max(left, right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
