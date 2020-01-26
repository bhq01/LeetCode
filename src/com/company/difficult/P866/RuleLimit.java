package com.company.difficult.P866;

/**
 * 素数与回文规律
 * 
 * @author bihongqing
 *
 */
public class RuleLimit {
	public int primePalindrome(int N) {
		/**
		 * 获得回文基数
		 */
		String str = String.valueOf(N);
		String substring = str.substring(0, (str.length()+1)/2);
		int n = Integer.parseInt(substring);
		new StringBuffer(substring)
		
		nextPalindrome(N);
		
		return 1;
	}
}
