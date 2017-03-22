package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10739_StringToPalindrome {
	static char[] s;
	static int n;
	static final int inf = (int) 1e5;
	static int[][] dp;

	public static int solve(int idx, int end) {
		if (idx == end || idx == end + 1 || idx == n)
			return 0;
		if (idx > end)
			return inf;
		if (dp[idx][end] != -1)
			return dp[idx][end];
		int ans = inf;
		if (s[idx] == s[end])
			ans = solve(idx + 1, end - 1);
		else
			ans = 1 + Math.min(solve(idx, end - 1),
					Math.min(solve(idx + 1, end - 1), solve(idx + 1, end)));

		return dp[idx][end] = ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int cse = 1;
		while (t-- > 0) {
			s = in.nextLine().toCharArray();
			n = s.length;
			dp = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			out.printf("Case %d: %d\n", cse++, solve(0, n - 1));
		}
		out.flush();
		out.close();

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
