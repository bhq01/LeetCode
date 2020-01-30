package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/28 1:08 上午
 */
public class P1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (res[0] = 1; res[0] <= n / 2; res[0]++) {
            res[1] = n - res[0];
            if (String.valueOf(res[0]).indexOf('0') == -1
                    && String.valueOf(res[1]).indexOf('0') == -1)
                return res;
        }
        return res;
    }
}
