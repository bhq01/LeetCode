package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/28 1:19 上午
 */
public class P336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;
        if (n == 0) return res;

        List<List<Integer>> index = new ArrayList<>();
        for (int i = 0; i < 26; i++) index.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if ("".equals(words[i])) for (int j = 0; j < 26; j++) index.get(j).add(i);
            else
                index.get(words[i].charAt(words[i].length() - 1) - 'a').add(i);
        }

        List<Integer> list;

        for (int i = 0; i < n; i++) {
            if ("".equals(words[i])) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (isPalindrome(words[i] + words[j])) {
                        list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                }

            } else {
                for (int j : index.get(words[i].charAt(0) - 'a')) {
                    if (i == j) continue;
                    if (isPalindrome(words[i] + words[j])) {
                        list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}
