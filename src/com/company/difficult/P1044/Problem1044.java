package com.company.difficult.P1044;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1044 {
	public String longestDupSubstring(String S) {
		/**
		 * initiation
		 */
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			List<Integer> list = map.get(ch);
			if (list == null) {
				map.put(ch, new ArrayList<Integer>(Arrays.asList(i)));
			} else
				map.get(ch).add(i);
		}

		StringBuilder res = new StringBuilder();
		String maxRes = "";
		/**
		 * do loop for every char
		 */
		for (int a = 0; a < S.length(); a++) {
			List<Integer> list = map.get(S.charAt(a));
			if (list.size() < 2)
				continue;
			for (int j = 1; j < list.size(); j++) {
				int b = list.get(j);
				if (b <= a)
					continue;
				/**
				 * calculate common string length
				 */
				int a1 = a;
				res.append(S.charAt(a1));
				while ((b + 1) < S.length() && S.charAt(++a1) == S.charAt(++b)) {
					res.append(S.charAt(a1));
				}
				if (res.length() > maxRes.length()) {
					maxRes = res.toString();
				}
				res.delete(0, res.length());
			}

		}

		return maxRes;
	}
}
