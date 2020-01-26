package com.company.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020-01-22 11:34
 */
public class Problem862 {

    public int shortestSubarray1(int[] A, int K) {
        final int length = A.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                sum[j] += A[i + j - 1];
                if (sum[j] >= K) return i;
            }
        }
        return -1;
    }

    public int shortestSubarray(int[] A, int K) {
        final int length = A.length;
        long[] sum = new long[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        Deque<Integer> deque = new LinkedList<>();
        int ans = length + 1;
        for (int i = 0; i <= length; i++) {
            while (!deque.isEmpty() && sum[i] <= sum[deque.getLast()])
                deque.removeLast();
            while (!deque.isEmpty() && sum[i] - sum[deque.getFirst()] >= K)
                ans = Math.min(ans, i - deque.removeFirst());
            deque.addLast(i);
        }
        return ans == (length + 1) ? -1 : ans;
    }
}
