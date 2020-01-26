package com.company.difficult.LCP5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCP5_2 {
	public int[] bonus(int n, int[][] leadership, int[][] operations) {
		// Initiation
		Node[] nodes = new Node[n + 1];
		for (int i = 0; i < n + 1; i++)
			nodes[i] = new Node(i);

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
		Map<Integer, Long> sums = new HashMap<>();
		boolean sumOk = false;
		Node tmp;
		for (int[] operation : operations) {
			tmp = nodes[operation[1]];
			switch (operation[0]) {
			case 1:
				tmp.coin1 += operation[2];
				sumOk = false;
				break;
			case 2:
				tmp.coin2 += operation[2];
				sumOk = false;
				break;
			case 3:
				if (!sumOk) {
					sums.clear();
					sumOk = true;
				}
				calculateTree(tmp, getParentCode(tmp), sums);
				result.add(sums.get(operation[1]));
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

	private long calculateTree(Node root, long parentCoin, Map<Integer, Long> sums) {
		long sum = 0;

		for (Node son : root.sons) {
			if (sums.containsKey(son.id))
				sum += sums.get(son.id);
			else
				sum += calculateTree(son, parentCoin + root.coin2, sums);
		}

		sum += root.coin1 + root.coin2 + parentCoin;

		sums.put(root.id, sum);

		return sum;
	}

	static class Node {
		Node parent;
		List<Node> sons = new ArrayList<>();
		long coin1, coin2;
		int id;

		public Node(int id) {
			this.id = id;
		}
	}
}
