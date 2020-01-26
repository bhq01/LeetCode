package com.company.simple;

import java.util.HashMap;
import java.util.Map;

public class Problem1025 {
    Map<Integer, Boolean> map = new HashMap<>();
    public boolean divisorGame(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        for (int submultiple = N/2; submultiple >= 1; submultiple--) {
            if (N % submultiple == 0 && !divisorGame(N-submultiple)) {
                map.put(N, true);
                return true;
            }
        }
        map.put(N, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("N=2, res=" + new Problem1025().divisorGame(2));
        System.out.println("N=3, res=" + new Problem1025().divisorGame(3));
        System.out.println("N=4, res=" + new Problem1025().divisorGame(4));
        System.out.println("N=5, res=" + new Problem1025().divisorGame(5));
        long start = System.currentTimeMillis();
        System.out.println("N=1000, res=" + new Problem1025().divisorGame(1000));
        System.out.println("time:" + (System.currentTimeMillis() - start));

    }
}
