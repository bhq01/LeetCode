package com.company;

import com.company.simple.P240;

public class Main {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(new P240().searchMatrix(new int[][]{{1}, {3}, {5}}, 5));
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
}