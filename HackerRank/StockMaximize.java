package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StockMaximize {
	static int n;
	static long[] a;
	static long[][] dp;
	static final long inf = (long) 1e15;

	static long solve(int idx, int num) {
		if (idx == n)
			return 0;

		if (dp[idx][num] != inf)
			return dp[idx][num];

		long leave = solve(idx + 1, num);
		long buy = solve(idx + 1, num + 1) - a[idx];
		long sell = -inf;
		for (int i = 1; i <= num; i++)
			sell = Math.max(sell, solve(idx + 1, num - i) + a[idx] * (long) i);
		return dp[idx][num] = Math.max(sell, Math.max(buy, leave));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = in.nextInt();
			a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();

			long max = -inf;
			long[] mx = new long[n];
			for (int i = n - 1; i >= 0; i--)
				mx[i] = max = Math.max(max, a[i]);

			long ans = 0;
			for (int i = 0; i < n; i++)
				ans += mx[i] - a[i];
			sb.append(ans + "\n");
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
