package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020-01-22 22:15
 */
public class Problem665 {

    public boolean checkPossibility(int[] nums) {
        int chance = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < last) {
                if (chance > 0) {
                    chance--;
                    if (i >= 2) {
                        if (nums[i-2]<=nums[i])
                            last = nums[i];
                    } else
                        last = nums[i];
                } else return false;
            } else {
                last = nums[i];
            }
        }
        return true;
    }

}
