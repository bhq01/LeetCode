package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/26 6:42 下午
 */
public class P5319 {
    public int removePalindromeSub(String s) {
        int len = s.length();
        if (len == 0) return 0;
        for (int i = 0; i < len /2; i++) {
            if (s.charAt(i) != s.charAt(len-1-i)) return 2;
        }
        return 1;
    }
}
