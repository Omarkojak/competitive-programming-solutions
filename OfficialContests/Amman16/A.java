package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	static final long MOD = (long) 1e9 + 7;
	static int n, m, arr1[], arr2[];
	static long[][] dp1, dp2;

	public static long solve1(int idx, int w) {
		if (w == 0)
			return 1;
		if (idx == n || w < 0)
			return 0;
		if (dp1[idx][w] != -1)
			return dp1[idx][w];

		long take = solve1(idx + 1, w - arr1[idx]);
		long leave = solve1(idx + 1, w);
		return dp1[idx][w] = (take + leave) % MOD;
	}

	public static long solve2(int idx, int w) {
		if (w == 0)
			return 1;
		if (idx == m || w < 0)
			return 0;
		if (dp2[idx][w] != -1)
			return dp2[idx][w];

		long take = solve2(idx + 1, w - arr2[idx]);
		long leave = solve2(idx + 1, w);
		return dp2[idx][w] = (take + leave) % MOD;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			int k = in.nextInt();
			int total = in.nextInt();
			arr1 = new int[n];
			arr2 = new int[m];
			for (int i = 0; i < n; i++)
				arr1[i] = in.nextInt();
			for (int i = 0; i < m; i++)
				arr2[i] = in.nextInt();

			dp1 = new long[n + 2][15001];
			for (int i = 0; i < n + 2; i++)
				Arrays.fill(dp1[i], -1);

			dp2 = new long[m + 2][15001];
			for (int i = 0; i < m + 2; i++)
				Arrays.fill(dp2[i], -1);

			long ans = 0;
			for (int first = 0; first <= total; first++) {
				int second = total - first;
				if (Math.abs(second - first) <= k) {
					ans += ((solve1(0, first) * solve2(0, second)) % MOD);
					ans %= MOD;
				}
			}
			sb.append(ans).append("\n");

		}
		System.out.print(sb);
	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer ns;

		Scanner(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return bf.readLine();
		}

	}

}
