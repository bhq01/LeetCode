package com.company.difficult.LCP5;

import java.util.ArrayList;
import java.util.List;

public class ProblemLcp5 {
	public int[] bonus(int n, int[][] leadership, int[][] operations) {
		System.out.println(0);
		long time = System.currentTimeMillis();

		Node[] nodes = new Node[n + 1];
		for (int i = 0; i < n + 1; i++)
			nodes[i] = new Node();

		Node son, parent;
		for (int[] arr : leadership) {
			son = nodes[arr[1]];
			parent = nodes[arr[0]];

			son.parent = parent;
			parent.sons.add(son);
		}

		System.out.println(System.currentTimeMillis() - time);

		List<Long> result = new ArrayList<>();
		Node tmp;
		for (int[] operation : operations) {
			tmp = nodes[operation[1]];
			switch (operation[0]) {
			case 1:
				setParentCoin(tmp, operation[2]);
				break;
			case 2:
				long coins = getSonCoin(tmp, operation[2]);
				tmp.sum += coins;
				setParentCoin(tmp.parent, coins);
				break;
			case 3:
				result.add(nodes[operation[1]].sum);
				break;
			}
		}
		System.out.println(System.currentTimeMillis() - time);
		int[] a = new int[result.size()];
		int index = 0;
		for (Long element : result)
			a[index++] = (int) (element % 1000000007);
		System.out.println(System.currentTimeMillis() - time);
		return a;
	}

	private void setParentCoin(Node tmp, long i) {
		while (tmp != null) {
			tmp.sum += i;
			tmp = tmp.parent;
		}
	}

	private long getSonCoin(Node tmp, int i) {
		long sum = 0;
		for (Node son : tmp.sons) {
			long sonCoins = getSonCoin(son, i);
			son.sum += sonCoins;
			sum += sonCoins;
		}
		return sum + i;
	}

	static class Node {
		Node parent;
		List<Node> sons = new ArrayList<>();
		long sum;
	}
}
