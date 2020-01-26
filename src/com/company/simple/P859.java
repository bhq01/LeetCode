package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/26 6:22 下午
 */
public class P859 {

    public boolean buddyStrings(String A, String B) {
        int len = A.length();
        if (len != B.length()) {
            return false;
        }
        int diff = 0;
        char a = ' ',b=' ';
        for (int i = 0;i < len;i++) {
            char ch1 = A.charAt(i);
            char ch2 = B.charAt(i);
            if (ch1 == ch2) continue;
            if (diff>=2) return false;
            if (diff == 0) {
                diff++;
                a = ch1;
                b = ch2;
                continue;
            }
            if (diff == 1) {
                diff ++;
                if (a!=ch2 || b!=ch1)
                    return false;
            }
        }



        if (diff != 0 ) {
            return diff==2;
        }
        if (A.length()>26) return true;

        int[] num = new int[26];
        for (int i = 0;i < len;i++) {
            if (num[A.charAt(i)-'a']>0)
                return true;
            num[A.charAt(i)-'a'] =1;
        }
        return false;
    }

}
