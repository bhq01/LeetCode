package com.company.algorithm;

public class RabinKarp {
	/**
	 * P为大素数
	 */
	public static final int P = 2 ^ 32 - 1;

	/**
	 * 滚动hash的基数
	 */
	public static final int R = 256;

	public int search(String txt, String ptn) {
		int N = txt.length();
		int M = ptn.length();
		if (M > N)
			return -1;

		long txtHash = hash(txt, 0, M - 1); // 计算文本串txt[0...M-1]的hash值
		long ptnHash = hash(ptn, 0, M - 1); // 计算模式串的hash值
		// 首先做一次匹配
		if (ptnHash == txtHash)
			return 0;

		// 计算R^(M-1)%P,后续公式递推求值用到
		long RM = 1;
		for (int i = 1; i <= M - 1; i++) {
			RM = (RM * R) % P;
		}

		// 从文本的第1个字符开始查找
		for (int i = 0; i < N - M; i++) {
			// 根据递推公式，计算文本串hash值
			txtHash = (txtHash + P - RM * txt.charAt(i) % P) % P;
			txtHash = (txtHash * R + txt.charAt(i + M)) % P;

			if (txtHash == ptnHash)
				return i;
		}
		return -1;
	}

	private long hash(String txt, int i, int j) {
		long value = 0;
		for (int index = i; index <= j; index++) {
			value = (value * R % P + txt.charAt(index)) % P;
		}
		return value;
	}

	public static final void main(String[] args) {
		System.out.println(new RabinKarp().search("abcdef", "abcf"));
	}
}
