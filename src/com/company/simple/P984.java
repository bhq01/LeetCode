package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 11:22 上午
 */
public class P984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        boolean compare = A>=B;
        /**
         * 特殊处理多出来的1或2个
         */
        if (A >2*B ) {
            if (A==1) return "a";
            res.append("aa");
            A-=2;
        } else if (B>2*A) {
            if (B==1) return "b";
            res.append("bb");
            B-=2;
        }

        int t = Math.abs(A - B), s = Math.min(A, B) - t;
        if (compare) {
            for (int i = 0; i < t; i++) {
                res.append("baa");
            }
            for (int i = 0; i < s; i++) {
                res.append("ba");
            }
        } else {
            for (int i = 0; i < t; i++) {
                res.append("abb");
            }
            for (int i = 0; i < s; i++) {
                res.append("ab");
            }
        }
        return res.toString();
    }

}
