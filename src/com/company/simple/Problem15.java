package com.company.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem15 {
	public List<List<Integer>> threeSum(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int element : nums) {
			Integer count = countMap.get(element);
			if (count != null)
				countMap.put(element, count + 1);
			else
				countMap.put(element, 1);
		}

		int b;
		for (int c : countMap.keySet()) {
			if (c >= 0)
				continue;
			for (int a : countMap.keySet()) {
				b = -a - c;
				if (a <= 0 || b < c || b > a)
					continue;

				Integer count = countMap.get(b);
				if (count == null || (b == c || b == a) && (count < 2))
					continue;

				result.add(Arrays.asList(c, b, a));
			}
		}

		Integer zeroCount = countMap.get(0);
		if (zeroCount != null && zeroCount >= 3)
			result.add(Arrays.asList(0, 0, 0));

		return result;
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, List<Integer>> countMap = new HashMap<>(nums.length);
        List<Integer> count;
		int element;
		for (int i = 0; i < nums.length; i++) {
			element = nums[i];
			count = countMap.get(element);
			if (count != null) {
				count.set(0, count.get(0) + 1);
				count.add(i);
				countMap.put(element, count);
			} else {
				countMap.put(element, new ArrayList<>(Arrays.asList(1, i)));
			}
		}
		int b;
		for (int a : countMap.keySet()) {
			b = target - a;
			count = countMap.get(b);
			if (count == null)
				continue;
			if (a == b && count.get(0) >= 2) {
				return new int[] {count.get(1),count.get(2)};
			}
			return new int[] {countMap.get(a).get(1), count.get(1)};
		}
		throw new RuntimeException("");
	}
}
