package com.company.difficult.LCP5;

import java.util.ArrayList;
import java.util.List;

public class LCP5 {
	public int[] bonus(int n, int[][] leadership, int[][] operations) {
		// Initiation
		Node[] nodes = new Node[n + 1];
		for (int i = 0; i < n + 1; i++)
			nodes[i] = new Node();

		// create tree
		Node son, parent;
		for (int[] arr : leadership) {
			son = nodes[arr[1]];
			parent = nodes[arr[0]];

			son.parent = parent;
			parent.sons.add(son);
		}

		// do operation
		List<Long> result = new ArrayList<>();
		Node tmp;
		for (int[] operation : operations) {
			tmp = nodes[operation[1]];
			switch (operation[0]) {
			case 1:
				tmp.coin1 += operation[2];
				break;
			case 2:
				tmp.coin2 += operation[2];
				break;
			case 3:
				result.add(calculateTree(tmp, getParentCode(tmp)));
				break;
			}
		}
		return result.stream().mapToInt(i -> (int) (i % 1000000007)).toArray();
	}

	private long getParentCode(Node tmp) {
		int parentCode = 0;
		while (tmp.parent != null) {
			tmp = tmp.parent;
			parentCode += tmp.coin2;
		}
		return parentCode;
	}

	private long calculateTree(Node root, long parentCoin) {
		long sum = 0;

		for (Node son : root.sons) {
			sum += calculateTree(son, parentCoin + root.coin2);
		}

		sum += root.coin1 + root.coin2 + parentCoin;

		return sum;
	}

	static class Node {
		Node parent;
		List<Node> sons = new ArrayList<>();
		long coin1, coin2;
	}
}
