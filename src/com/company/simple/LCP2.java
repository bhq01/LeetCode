package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 10:37 上午
 */
public class LCP2 {
    public int[] fraction(int[] cont) {
        int n = cont.length - 1;
        int s = cont[n], t = 1;
        int tmp;
        for (int i = n - 1; i >= 0; i--) {
            tmp = t;
            t = s;
            s = tmp + s * cont[i];
        }
        return new int[]{s,t};
    }
}
