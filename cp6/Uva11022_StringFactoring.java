package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11022_StringFactoring {
	static char[] s;
	static int dp[][];

	public static int solve(int i, int j) {
		if (i > j)
			return 0;
		if (i == j)
			return 1;
		if (dp[i][j] != -1)
			return dp[i][j];
		int min = j - i + 1;
		for (int k = i; k <= j; k++) {
			for (int l = 1; l < k - i + 1 || l == k - i + 1 && k != j; l++)
				if (can(i, k, l))
					min = Math.min(min, solve(i, i + l - 1) + solve(k + 1, j));
		}
		return dp[i][j] = min;
	}

	public static boolean can(int i, int j, int l) {
		if ((j - i + 1) % l != 0)
			return false;
		for (int k = 0, b = i; i <= j; i++, k = (k + 1) % l)
			if (s[i] != s[b + k])
				return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String t = in.nextLine();
			if (t.equals("*"))
				break;
			s = t.toCharArray();
			dp = new int[100][100];
			for (int i = 0; i < 100; i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(0, s.length - 1)).append("\n");
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
