package com.company.simple;

public class Problem991 {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        for (;X<Y;X=X*2) {
            count++;
        }
        int k = count;
        int div = 2;
        int dis = X-Y;
        for (int i=0;i<k;i++) {
            count+=dis%div;
            dis/=2;
        }
        return count + dis;
    }

    public static void main(String[] args) {
        System.out.println(new Problem991().brokenCalc(1024, 1));
    }
}
