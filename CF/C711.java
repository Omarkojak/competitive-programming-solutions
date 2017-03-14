package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C711 {
	static int n, m, k;
	static int trees[];
	static long cost[][];
	static final long inf = (long) 1e17;
	static long dp[][][];

	public static long solve(int idx, int last, int seg) {
		if (seg > k)
			return inf;

		if (idx == n) {
			if (seg + 1 == k)
				return 0;
			else
				return inf;
		}

		if (dp[idx][last][seg] != -1)
			return dp[idx][last][seg];

		if (trees[idx] != 0) {
			if (last == trees[idx])
				return dp[idx][last][seg] = solve(idx + 1, last, seg);
			else
				return dp[idx][last][seg] = solve(idx + 1, trees[idx], seg + 1);
		}
		long min = inf;
		for (int i = 1; i <= m; i++) {
			if (i == last)
				min = Math.min(min, cost[idx][i] + solve(idx + 1, last, seg));
			else
				min = Math.min(min, cost[idx][i] + solve(idx + 1, i, seg + 1));
		}
		return dp[idx][last][seg] = min;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		trees = new int[n];
		for (int i = 0; i < n; i++)
			trees[i] = in.nextInt();
		cost = new long[n][m + 1];
		for (int i = 0; i < n; i++)
			for (int j = 1; j <= m; j++)
				cost[i][j] = in.nextLong();

		dp = new long[n][m + 5][k + 5];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m + 5; j++)
				Arrays.fill(dp[i][j], -1);

		long min = inf;
		if (trees[0] == 0) {
			for (int i = 1; i <= m; i++)
				min = Math.min(min, cost[0][i] + solve(1, i, 0));
		} else
			min = solve(1, trees[0], 0);

		System.out.println((min == inf) ? -1 : min);
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
