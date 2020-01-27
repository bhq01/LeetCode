package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 2:18 下午
 */
public class P191 {
    public int hammingWeight(int n) {
        int res = 0;
        if (n<0) {
            n= Integer.MAX_VALUE+n+1;
            res ++;
        }
        while (n>0) {
            res+=(n%2);
            n=n>>1;
        }
        return res;
    }
}
