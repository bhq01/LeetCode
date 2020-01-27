package com.company.difficult.P745;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 3:37 下午
 */
class WordFilter {
    private String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].startsWith(prefix) && words[i].endsWith(suffix))
                return i;
        }
        return -1;
    }
}