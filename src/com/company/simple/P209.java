package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/27 1:48 下午
 */
public class P209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        long sum = nums[0];
        int n = 1, max = Integer.MAX_VALUE, tail = 0;

        for (int num : nums) {
            while (tail + 1 < len && sum < s) {
                tail++;
                sum += nums[tail];
                n++;
            }
            if (sum >= s && n < max) {
                max = n;
                if (n==1) break;
            }
            if (sum < s) break;

            n--;
            sum -= num;
        }
        return max == Integer.MAX_VALUE ? 0 : max;

    }
}
