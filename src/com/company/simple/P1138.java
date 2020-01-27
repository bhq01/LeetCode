package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 10:59 上午
 */
public class P1138 {
    public String alphabetBoardPath(String target) {
        int s = 0, t = 0;
        StringBuilder res = new StringBuilder();
        int tmp, s1, t1;
        char last = ' ';
        for (char ch : target.toCharArray()) {
            tmp = ch - 'a';
            s1 = tmp / 5;
            t1 = tmp % 5;
            if (last !='z') {
                if (t1 < t)
                    while (t1 < t--) res.append('L');
                else while (t1 > t++) res.append('R');
            }
            if (s1 < s)
                while (s1 < s--) res.append('U');
            else while (s1 > s++) res.append('D');
            if (last =='z') {
                if (t1 < t)
                    while (t1 < t--) res.append('L');
                else while (t1 > t++) res.append('R');
            }
            res.append('!');
            s = s1;
            t = t1;
            last = ch;
        }
        return res.toString();
    }
}
