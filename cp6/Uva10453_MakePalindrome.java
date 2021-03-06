package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva10453_MakePalindrome {
	static char[] s;
	static int n;
	static int inf = (int) 1e6;
	static int dp[][];
	static StringBuilder sb;
	static Stack<Character> st;

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
			ans = 1 + Math.min(solve(idx + 1, end), solve(idx, end - 1));
		return dp[idx][end] = ans;
	}

	public static void print(int idx, int end) {
		if (idx > end)
			return;
		if (idx == end) {
			sb.append(s[idx]);
			return;
		}
		if (s[idx] == s[end]) {
			sb.append(s[idx]);
			st.add(s[idx]);
			print(idx + 1, end - 1);
			return;
		}
		int opt = solve(idx, end);
		if (opt == 1 + solve(idx + 1, end)) {
			sb.append(s[idx]);
			st.add(s[idx]);
			print(idx + 1, end);
		} else {
			sb.append(s[end]);
			st.add(s[end]);
			print(idx, end - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sb = new StringBuilder();
		// int t = 6;
		while (in.ready()) {
			String k = in.nextLine();
			s = k.toCharArray();
			n = s.length;
			dp = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			st = new Stack<>();
			sb.append(solve(0, n - 1) + " ");
			print(0, n - 1);
			while (!st.isEmpty())
				sb.append(st.pop());
			sb.append("\n");

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
