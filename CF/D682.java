package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D682 {
	static int n, m, k;
	static char[] s, t;
	static final short inf = (short) 1005;
	static short dp[][][][];

	public static short solve(int i, int j, int c, int pref) { // pref -> 1 true   0-> false
		if (c == k)
			return 0;
		if (i == n || j == m)
			if (pref == 0 || (pref == 1 && c < k - 1))
				return -inf;
			else
				return 0;

		if (dp[pref][c][i][j] != -1)
			return dp[pref][c][i][j];

		short ans = -inf;

		if (s[i] == t[j]) {
			ans = solve(i + 1, j + 1, c, 1);
			ans += 1;
		}
		if (pref == 0)
			ans = (short) Math.max(ans,
					Math.max(solve(i + 1, j, c, 0), solve(i, j + 1, c, 0)));
		else
			ans = (short) Math.max(ans, solve(i, j, c + 1, 0));

		return dp[pref][c][i][j] = ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		s = in.next().toCharArray();
		t = in.next().toCharArray();
		dp = new short[2][k][n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				for (int w = 0; w < k; w++) {
					dp[0][w][i][j] = -1;
					dp[1][w][i][j] = -1;
				}
		System.out.println(solve(0, 0, 0, 0));

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
