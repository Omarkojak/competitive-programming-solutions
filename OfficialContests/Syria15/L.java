package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class L {
	static boolean isPrime[];

	public static void sieve(int max) {
		isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				if (1l * i * i <= max)
					for (int j = i * i; j < max + 1; j += i) {
						isPrime[(int) j] = false;
					}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int limit = ((int) 1e5) + 5;
		sieve(limit);
		int[] prefix = new int[limit];
		for (int i = 1; i < limit; i++) {
			if (isPrime[Integer.bitCount(i)])
				prefix[i] = 1;
			prefix[i] += prefix[i - 1];
		}
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(ns.nextToken());
			int r = Integer.parseInt(ns.nextToken());
			int cnt = prefix[r];
			if (l != 0)
				cnt -= prefix[l - 1];

			sb.append(cnt).append("\n");
		}
		System.out.print(sb);

	}

}
