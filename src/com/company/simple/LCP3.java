package com.company.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 6:21 下午
 */
public class LCP3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int s = 0, t = 0;
        long constant = (long) Math.pow(10, 9);
        Set<Long> paths = new HashSet<>();
        paths.add(0L);

        for (char ch : command.toCharArray()) {
            if ('U' == ch) t++;
            else s++;
            paths.add(s * constant + t);
        }

        int steps = Math.min(x / s, y / t);
        long location = (x-s*steps) * constant + y-t*steps;
        if (!paths.contains(location)) return false;

        for (int[] p : obstacles) {
            if (p[0]>x||p[1]>y) continue;
            steps = Math.min(p[0] / s, p[1] / t);
            location = (p[0]-s*steps) * constant + p[1]-t*steps;
            if (paths.contains(location)) return false;
        }
        return true;

    }

}
