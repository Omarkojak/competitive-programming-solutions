package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C761 {
	static int[][] closest; // digit - char - symbol
	static final int inf = (int) 1e9;
	static int n;
	static int dp[][][][];

	public static int solve(int idx, int d, int sy, int c) {
		if (idx == n) {
			if (d == 1 && sy == 1 && c == 1)
				return 0;
			else
				return inf;
		}
		if (dp[d][sy][c][idx] != -1)
			return dp[d][sy][c][idx];
		int min = inf;
		if (closest[0][idx] != inf)
			min = Math.min(min, closest[0][idx] + solve(idx + 1, 1, sy, c));

		if (closest[1][idx] != inf)
			min = Math.min(min, closest[1][idx] + solve(idx + 1, d, sy, 1));

		if (closest[2][idx] != inf)
			min = Math.min(min, closest[2][idx] + solve(idx + 1, d, 1, c));

		return dp[d][sy][c][idx] = min;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		closest = new int[3][n];
		dp = new int[2][2][2][n];

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					Arrays.fill(dp[i][j][k], -1);

		for (int i = 0; i < n; i++) {
			int d = inf;
			int c = inf;
			int sym = inf;

			char[] s = in.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				int val = Math.min(j, m - j);
				if (isdigit(s[j])) {
					d = Math.min(d, val);
				} else {
					if (issymb(s[j]))
						sym = Math.min(sym, val);
					else
						c = Math.min(c, val);
				}
			}
			closest[0][i] = d;
			closest[1][i] = c;
			closest[2][i] = sym;
		}
		System.out.println(solve(0, 0, 0, 0));

	}

	static boolean isdigit(char c) {
		if (c - '0' <= 9 && c - '0' >= 0)
			return true;
		return false;
	}

	static boolean issymb(char c) {
		if (c == '#' || c == '*' || c == '&')
			return true;
		return false;
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
	}

}
