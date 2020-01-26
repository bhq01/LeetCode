package com.company;

import com.company.difficult.P866.RuleLimit;

public class Main {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(new RuleLimit().primePalindrome(10786570));
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
}