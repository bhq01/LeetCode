package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/28 12:27 上午
 */
public class P1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int max, res, newValue;
        int[] data = new int[n];
        int j;
        for (int i = 0; i < n; i++) {
            max = A[i];
            res = max;
            if (i > 0) res += data[i - 1];
            j = 1;
            while (j < K && i - j >= 0) {
                if (A[i - j] > max) max = A[i - j];
                j++;
                if (i - j + 1 == 0) newValue = max * j;
                else newValue = max * j + data[i - j];
                if (newValue>res) {
                    res = newValue;
                }
            }
            data[i] = res;
        }
        return data[n-1];
    }
}
