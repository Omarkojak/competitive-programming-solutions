package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva11407_Squares {
	static ArrayList<Integer> sqrs;
	static int dp[];
	static final int inf = (int) 1e7;

	static int solve(int n, int i) {
		if (n == 0)
			return 0;
		if (n < 0 || i == 100)
			return inf;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = Math.min(1 + solve(n - sqrs.get(i), i), solve(n, i + 1));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		sqrs = new ArrayList<>();
		for (int i = 1; i <= 100; i++)
			sqrs.add(i * i);
		/*
		 * dp = new int [10005]; Arrays.fill(dp, -1); while(t-->0) {
		 * sb.append(solve(in.nextInt(), 0)).append("\n"); }
		 */

		dp = new int[10005];
		for (int i = 1; i <= 10000; i++) {
			int min = inf;
			for (int x : sqrs)
				if (x <= i)
					min = Math.min(min, 1 + dp[i - x]);
			dp[i] = min;
		}
		while (t-- > 0)
			sb.append(dp[in.nextInt()]).append("\n");

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
