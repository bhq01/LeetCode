package com.company.simple;

import java.util.Arrays;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/26 6:52 下午
 */
public class P5155 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return arr;
        Point[] list = new Point[arr.length];
        for (int i = 0; i < arr.length; i++) {
            list[i] = new Point(arr[i], i);
        }
        Arrays.sort(list);
        int order = 1;
        arr[list[0].id]=1;
        for (int i = 1; i < arr.length; i++) {
            if (list[i].data == list[i-1].data)
                arr[list[i].id] = order;
            else arr[list[i].id] = ++order;
        }
        return arr;
    }
    static class Point implements Comparable<Point> {
        int data;
        int id;

        public Point(int data, int id) {
            this.data = data;
            this.id = id;
        }

        @Override
        public int compareTo(Point o) {
            return data - o.data;
        }
    }
}
