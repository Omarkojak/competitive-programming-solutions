package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva164_StringComputer {
	static char[] s, t;
	static int n, m;
	static final int inf = 10000;
	static int[][] dp;
	static StringBuilder sb;

	public static int solve(int i, int j) {
		if (i == n || j == m)
			return m - j + n - i;
		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = inf;
		if (s[i] == t[j])
			ans = solve(i + 1, j + 1);
		else
			ans = 1 + Math.min(solve(i + 1, j + 1),
					Math.min(solve(i + 1, j), solve(i, j + 1)));
		return dp[i][j] = ans;
	}

	public static void print(int i, int j) {
		if (j == m) {
			while (i < n)
				sb.append(String.format("D%c%02d", s[i++], j + 1));

			return;
		}
		if (i >= n) {
			while (j < m)
				sb.append(String.format("I%c%02d", t[j++], j));
			return;
		}
		if (s[i] == t[j]) {
			print(i + 1, j + 1);
			return;
		}

		int opt = solve(i, j);
		if (solve(i + 1, j + 1) + 1 == opt) {
			sb.append(String.format("C%c%02d", t[j], j + 1));
			print(i + 1, j + 1);
		} else if (solve(i + 1, j) + 1 == opt) {
			sb.append(String.format("D%c%02d", s[i], j + 1));
			print(i + 1, j);

		} else {
			sb.append(String.format("I%c%02d", t[j], j + 1));
			print(i, j + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sb = new StringBuilder();
		while (true) {
			String s1 = in.next();
			if (s1.equals("#"))
				break;
			s = s1.toCharArray();
			t = in.next().toCharArray();
			n = s.length;
			m = t.length;
			dp = new int[n][m];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);

			// System.out.println(solve(0,0));
			solve(0, 0);
			print(0, 0);
			// System.out.println(sb);
			sb.append("E\n");
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
