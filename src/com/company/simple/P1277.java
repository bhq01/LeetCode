package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 11:38 下午
 */
public class P1277 {
    /**
     * 算法的核心在于利用周围节点的计算结果
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n];
        int sum = 0;
        int width;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) f[j] = 0;
                if (j == 0) width = 0;
                else width = Math.min(f[j - 1], f[j]);
                f[j] = width + matrix[i - width][j - width];
                sum += f[j];
            }
        return sum;
    }
}
