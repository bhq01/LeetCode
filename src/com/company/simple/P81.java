package com.company.simple;

/**
 * @Author labu@xiaohongshu.com
 * @create 2020/1/26 7:48 下午
 */
public class P81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int start = 0, end = nums.length - 1;

        if (target == nums[start] || target == nums[end]) return true;

        do {
            int mid = (start + end) / 2;
            /**
             * 出现相等时，需要进行去重
             */
            if (nums[mid] == nums[start]) {
                while (start < end && nums[start] == nums[start + 1]) start++;
                if (start < mid) end = mid;
                continue;
            }
            if (target == nums[mid]) return true;
            boolean a = target > nums[start];
            boolean c = target > nums[mid];
            boolean b = target > nums[end];

            if (!a && b) return false;

            if (nums[mid] > nums[start]) {
                if (a && !c) return searchHalf(nums, start, mid, target);
                else start = mid;
            } else {
                if (!b && c) return searchHalf(nums, mid, end, target);
                else end = mid;
            }
        } while (start < end - 1);

        return searchHalf(nums, start, end, target);
    }

    private boolean searchHalf(int[] nums, int start, int end, int target) {
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) start = mid;
            else end = mid;
        }
        return false;
    }
}
