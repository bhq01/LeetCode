package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 11:54 上午
 */
public class P240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (n==0) return false;
        return search(matrix, target, 0, 0, m - 1, n - 1);
    }

    private boolean search(int[][] matrix, int target, int s, int t, int m, int n) {
        if (s>m||t>n) return false;
        int i = s, j = t;
        while (i <= m && j <= n && matrix[i][j] < target) {
            i++;
            j++;
        }

        if (i <= m && j <= n) {
            if (matrix[i][j] == target) return true;
            else return search(matrix, target, i, t, m, j - 1)
                    || search(matrix, target, s, j, i - 1, n);
        } else if (i > m) {
            // 行出界
            return search(matrix, target, s, j, m, n);
        } else {
            // 列出界
            return search(matrix, target, i, t, m, n);
        }
    }

}
