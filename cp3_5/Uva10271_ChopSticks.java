package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10271_ChopSticks {
	static int[] arr;
	static int n;
	static final long inf = (long) 1e18;
	static long[][] dp;

	public static long sqr(int a, int b) {
		return (b - a) * (b - a);
	}

	public static long solve(int idx, int rem) {
		if (rem == 0)
			return 0;
		if (idx >= n - 1 || 3 * rem > n - idx)
			return inf;

		if (dp[idx][rem] != -1)
			return dp[idx][rem];

		long take = sqr(arr[idx], arr[idx + 1]) + solve(idx + 2, rem - 1);
		long leave = solve(idx + 1, rem);
		return dp[idx][rem] = Math.min(take, leave);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int k = in.nextInt() + 8;
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			dp = new long[n][k + 2];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(0, k)).append("\n");

		}
		System.out.print(sb);
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
