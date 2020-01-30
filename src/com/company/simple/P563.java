package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/28 12:08 上午
 */
public class P563 {
    private int res = 0;
    /**
     * 后序遍历
     */
    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }

    private int sum(TreeNode root) {
        if (root==null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        res+=Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
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
