package com.company.difficult.P576;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 1:03 上午
 */
public class P576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) return 0;
        int[][][] pathGraph = new int[2][m][n];
        pathGraph[0][i][j] = 1;

        int mod = 1000000007;
        long res = getRes(m, n, pathGraph[0], 0, mod);
        int last = 0;

        for (int distance = 1; distance < N; distance++) {
            int rs = Math.max(i - distance, 0);
            int re = Math.min(i + distance, m - 1);
            int next = (last + 1) % 2;
            for (int row = rs; row <= re; row++) {
                int cdis = distance - Math.abs(row - i);
                int cs = Math.max(j - cdis, 0);
                int ce = Math.min(j + cdis, n - 1);
                for (int column = cs; column <= ce; column++) {
                    int value = 0;
                    if (row > 0) value = (value + pathGraph[last][row - 1][column]) % mod;
                    if (row < m - 1) value = (value + pathGraph[last][row + 1][column]) % mod;
                    if (column > 0) value = (value + pathGraph[last][row][column - 1]) % mod;
                    if (column < n - 1) value = (value + pathGraph[last][row][column + 1]) % mod;

                    pathGraph[next][row][column] = value;
                }
            }
            res = getRes(m, n, pathGraph[next], res, mod);
            last = next;
        }
        return (int)res;
    }

    private long getRes(int m, int n, int[][] ints, long res, int mod) {
        for (int tmp = 0; tmp < m; tmp++) {
            res = (res + ints[tmp][0]) % mod;
            res = (res + ints[tmp][n - 1]) % mod;
        }
        for (int tmp = 0; tmp < n; tmp++) {
            res = (res + ints[0][tmp]) % mod;
            res = (res + ints[m - 1][tmp]) % mod;
        }
        return res;
    }
}
