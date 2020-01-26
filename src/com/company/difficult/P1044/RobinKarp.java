package com.company.difficult.P1044;

import java.util.HashSet;
import java.util.Set;

public class RobinKarp {
	private static final long P = (long) Math.pow(2, 32);
	private static final int R = 26;

	public String longestDupSubstring(String S) {
		int n = S.length();
		/**
		 * alpha convert to number
		 */
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = S.charAt(i) - 'a';
		}
		/**
		 * half-search
		 */
		int left = 1, right = n;
		while (left != right) {
			int L = (left + right) / 2;
			if (search(L, num) != -1)
				left = L + 1;
			else
				right = L;
		}
		int index = search(left - 1, num);

		return index != -1 ? S.substring(index, left + index - 1) : "";
	}

	private int search(int commonLen, int[] num) {
		long LM = 1;
		for (int i = 0; i < commonLen; i++)
			LM = LM * R % P;
		Set<Long> codeSet = new HashSet<>();

		/**
		 * initiate first code
		 */
		long oldCode = 0;
		for (int i = 0; i < commonLen; i++) {
			oldCode = (oldCode * R + num[i]) % P;
		}
		codeSet.add(oldCode);

		/**
		 * calculate hash and check if exist
		 */
		for (int i = 1; i <= num.length - commonLen; i++) {
			oldCode = (oldCode * R - num[i - 1] * LM % P + P) % P;
			oldCode = (oldCode + num[i + commonLen - 1]) % P;
			if (codeSet.contains(oldCode))
				return i;
			else
				codeSet.add(oldCode);
		}
		return -1;
	}
}
