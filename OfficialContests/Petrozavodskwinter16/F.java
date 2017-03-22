package OfficialContests.Petrozavodskwinter16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
	static int n, k;
	static int[][] cost;
	static int[][] color;
	static int currmsk;
	static long dp[][];
	static final long inf = (long) 1e17;
	static StringBuilder sb;

	static long solve(int i, int j) {
		if (i == n - 1 && j == n - 1)
			return dp[i][j] = cost[i][j];

		if (dp[i][j] != -1)
			return dp[i][j];

		long res = inf;
		if (valid(i + 1, j))
			res = cost[i][j] + solve(i + 1, j);
		if (valid(i, j + 1))
			res = Math.min(res, cost[i][j] + solve(i, j + 1));
		return dp[i][j] = res;
	}

	static void print(int i, int j) {
		if (i == n - 1 && j == n - 1) {
			sb.append((i + 1) + " " + (j + 1)).append("\n");
			return;
		}
		sb.append((i + 1) + " " + (j + 1) + " ");
		if (valid(i + 1, j) && dp[i][j] == cost[i][j] + dp[i + 1][j]) {
			print(i + 1, j);
			return;
		}
		if (valid(i, j + 1) && dp[i][j] == cost[i][j] + dp[i][j + 1]) {
			print(i, j + 1);
			return;
		}

	}

	static boolean valid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n
				&& (((currmsk & (1 << color[r][c])) != 0));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sb = new StringBuilder();
		n = in.nextInt();
		k = in.nextInt();
		long Wlimit = in.nextLong();
		cost = new int[n][n];
		color = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				cost[i][j] = in.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				color[i][j] = in.nextInt() - 1;

		int bestmsk = -1;
		int mincolors = (int) 1e7;
		for (int i = 1; i < 1 << k; i++) {
			currmsk = i;
			if (Integer.bitCount(i) > mincolors)
				continue;
			dp = new long[n][n];
			for (int j = 0; j < n; j++)
				Arrays.fill(dp[j], -1);
			long res = inf;
			if ((currmsk & (1 << color[0][0])) != 0)
				res = solve(0, 0);
			if (res <= Wlimit) {
				int ones = Integer.bitCount(currmsk);
				if (ones < mincolors) {
					mincolors = ones;
					bestmsk = currmsk;
				}
			}
		}

		if (bestmsk == -1)
			sb.append("-1\n");
		else {
			sb.append(mincolors).append("\n");
			currmsk = bestmsk;
			dp = new long[n][n];
			for (int j = 0; j < n; j++)
				Arrays.fill(dp[j], -1);
			solve(0, 0);
			print(0, 0);
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

	}
}
