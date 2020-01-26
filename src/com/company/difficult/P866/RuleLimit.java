package com.company.difficult.P866;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 素数与回文规律
 *
 * @author bihongqing
 */
public class RuleLimit {

	public int primePalindrome(int N) {
		//  处理10以内（含10）
		if (N == 1 || N == 2)
			return 2;
		else if (N == 3)
			return 3;
		else if (N == 4 || N == 5)
			return 5;
		else if (N == 6 || N == 7)
			return 7;
		else if (N >= 8 && N <= 11) {
			return 11;
		}

		/**
		 * 获得回文基数n
		 */
		String str = String.valueOf(N);
		String substring = str.substring(0, (str.length() + 1) / 2);
		int n = Integer.parseInt(substring);

		int currentPalindrome = getPalindrome(substring, str.length() % 2 == 0);
		if (currentPalindrome < N) n++;

		int len = str.length();
		int count = 0;
		boolean isChanged;

		/**
		 * 求15000以内的素数
		 */
		List<Integer> primes = new ArrayList<>(Arrays.asList(3, 5, 7, 11));
		for (int i = 12;i < 15000; i++) {
			if (isPrime(i, primes)) primes.add(i);
		}
		primes.remove(0);

		do {
			do {
				if (len == 8) {
					return 100030001;
				}
				isChanged = false;
				/**
				 * 发生进位
				 */
				if (String.valueOf(n).length() > (len + 1) / 2) {
					isChanged = true;
					len = len + 1;
					/**
					 * 晋升为偶数位时，基数除以10
					 */
					if (len % 2 == 0) {
						n /= 10;
					}
				}

				int res = checkValidation(n, len);
				if (res > n) {
					isChanged = true;
					n = res;
				}
			} while (isChanged);

			currentPalindrome = getPalindrome(String.valueOf(n), len % 2 == 0);
			count++;
			n++;
		} while (!isPrime(currentPalindrome, primes));
		System.out.println("count: " + count);
		return currentPalindrome;

	}

	private int checkValidation(int n, int len) {

		String str = String.valueOf(n);
		char firstChar = str.charAt(0);

		int basePow = (int) Math.pow(10, (len - 1) >> 1);

		/**
		 * 处理首位不为1，3，7，9
		 */
		if (firstChar == '2') n = 3 * basePow + 1;
		else if (firstChar >= '4' && firstChar <= '6') n = 7 * basePow + 1;
		else if (firstChar == '8') n = 9 * basePow + 1;

		return n;
	}

	private boolean isPrime(int num, List<Integer> primes) {
		int sqrt = (int) Math.sqrt(num);
		boolean isPrime = true;
		for (int prime : primes) {
			if (prime > sqrt) break;
			if (num % prime == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	private int getPalindrome(String baseStr, boolean isEven) {
		String reverseBase = new StringBuffer(baseStr).reverse().toString();
		String str = isEven ? baseStr : baseStr.substring(0, baseStr.length() - 1);

		return Integer.parseInt(str + reverseBase);
	}

}