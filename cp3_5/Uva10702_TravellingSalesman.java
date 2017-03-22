package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10702_TravellingSalesman {
	static long[][] profit, dp;
	static boolean[] exit;
	static int N;
	static final long inf = (long) 1e17;

	public static long solve(int node, int travels) {
		if (travels == 0)
			return exit[node] ? 0 : -inf;

		if (dp[node][travels] != -1)
			return dp[node][travels];

		long max = -inf;
		for (int i = 0; i < N; i++)
			max = Math.max(max, profit[node][i] + solve(i, travels - 1));
		return dp[node][travels] = max;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = in.nextInt();
			int start = in.nextInt() - 1;
			int exits = in.nextInt();
			int travels = in.nextInt();
			if (N == 0)
				break;
			profit = new long[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					profit[i][j] = in.nextLong();
			exit = new boolean[N];
			while (exits-- > 0) {
				exit[in.nextInt() - 1] = true;
			}
			dp = new long[105][1005];
			for (int i = 0; i < 105; i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(start, travels)).append("\n");

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
