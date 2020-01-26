package com.company.simple;

public class Problem420 {
	public int strongPasswordChecker(String s) {
		int n1 = 0, n2 = 0, a = 0, b = 0, len = s.length();
		s = s + '~';

		int haveUpper = 1, haveLower = 1, haveNumber = 1;
		char last = ' ';
		int num = 1;
		for (char ch : s.toCharArray()) {
			if (Character.isLowerCase(ch))
				haveLower = 0;
			else if (Character.isUpperCase(ch))
				haveUpper = 0;
			else if (Character.isDigit(ch))
				haveNumber = 0;

			if (last != ' ') {
				if (ch == last)
					num++;
				else {
					if (num >= 3) {
						if (num % 3 == 0)
							a++;
						else if (num % 3 == 1)
							b++;
						n2 += num / 3;
					}
					num = 1;
				}
			}
			last = ch;
		}
		n1 += (haveLower + haveUpper + haveNumber);

		if (len < 6)
			return Math.max(6 - len, n1);
		if (len > 20) {
			int ecn = len - 20;
			if (ecn <= a)
				return Math.max(ecn + n1, n2);
			else if (ecn <= a + 2 * b)
				return Math.max(n1, n2 - a - (ecn - a) / 2) + ecn;
			else
				return ecn + Math.max(n1, n2 - a - b - (ecn - a - 2 * b) / 3);
		}

		return Math.max(n2, n1);
	}
}
