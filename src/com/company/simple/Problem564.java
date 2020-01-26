package com.company.simple;

import java.util.Collections;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020-01-22 19:54
 */
public class Problem564 {

    public String nearestPalindromic(String n) {
        if (n.equals("1")) return "0";

        int half = n.length() / 2;
        int uphalf = (n.length() + 1) / 2;
        StringBuffer buffer = new StringBuffer(n.substring(0, uphalf));

        if (!new StringBuilder(n).reverse().toString().equals(n) && !n.matches("1[0]*")) {
            int value = Integer.parseInt(buffer.toString());
            String s = n.substring(0, half);
            long b = Long.parseLong(n);
            long a = Long.parseLong(s+buffer.reverse().toString());
            StringBuilder ss = new StringBuilder(String.valueOf(value - 1));
            long small = Long.parseLong(ss.substring(0, half) + ss.reverse());
            StringBuilder sb = new StringBuilder(String.valueOf(value + 1));
            long big = Long.parseLong(sb.substring(0,half) + sb.reverse());
            if (Math.abs(a-b)<=Math.abs(big-b) && Math.abs(a-b)<Math.abs(small-b))
                return String.valueOf(a);
            else if (Math.abs(a-b)>Math.abs(big-b) && Math.abs(big-b)<Math.abs(small-b))
                return String.valueOf(big);
            else return String.valueOf(small);

        } else if (buffer.toString().matches("1[0]*"))
            return String.join("", Collections.nCopies(n.length() - 1, "9"));

        else if (n.length() > 1 && n.matches("[9]+"))
            return '1' + String.join("", Collections.nCopies(n.length() - 1, "0")) + '1';
        else if (n.charAt((n.length() - 1) / 2) == '0')
            buffer = new StringBuffer(String.valueOf(Integer.parseInt(buffer.toString()) + 1));
        else
            buffer = new StringBuffer(String.valueOf(Integer.parseInt(buffer.toString()) - 1));


        if (n.length() % 2 == 0) return buffer.toString() + buffer.reverse();
        else return buffer.substring(0, buffer.length() - 1) + buffer.reverse();
    }
}
