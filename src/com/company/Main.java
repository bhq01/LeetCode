package com.company;

import com.company.difficult.P576.P576;

public class Main {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(new P576().findPaths(8,50,23,5,26));
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
}