package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/26 7:08 下午
 */
public class P1323 {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        int i = str.indexOf('6');
        if (i==str.length()) return num;
        StringBuilder buffer = new StringBuilder(str);
        buffer.setCharAt(i, '9');
        return Integer.parseInt(buffer.toString());
    }
}
