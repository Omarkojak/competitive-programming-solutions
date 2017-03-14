package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10721_BarCodes {
	static int n, m, k;
	static long[][][] dp;

	public static long solve(int idx, int diff, int bars) {
		if (diff > k || bars > m)
			return 0;
		if (idx == n)
			return (diff == k - 1) ? 1 : 0;

		if (dp[idx][diff][bars] != -1)
			return dp[idx][diff][bars];
		return dp[idx][diff][bars] = solve(idx + 1, diff, bars + 1)
				+ solve(idx + 1, diff + 1, 1);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
//		int t = 2;
		while (in.br.ready()) {
			n = in.nextInt(); // n bars
			k = in.nextInt(); // k regions
			m = in.nextInt(); // m units wide max.
			dp = new long[55][55][55];
			for (int i = 0; i < 55; i++)
				for (int j = 0; j < 55; j++)
					Arrays.fill(dp[i][j], -1);
			sb.append(solve(1, 0, 1)).append("\n");
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
