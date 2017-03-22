package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva1240_ICPCTeamStrategy {
	static int n, a0[], a1[], a2[];
	static int[][][] dp;

	public static int solve(int last, int msk, int sum) {
		if (Integer.bitCount(msk) == n)
			return 0;

		if (dp[last + 1][sum][msk] != -1)
			return dp[last + 1][sum][msk];

		int ans = 0;
		for (int i = 0; i < n; i++)
			if (((1 << i) & msk) == 0) {
				if (last != 0)
					if (sum + a0[i] <= 280)
						ans = Math.max(ans,
								1 + solve(0, msk | (1 << i), sum + a0[i]));
				if (last != 1)
					if (sum + a1[i] <= 280)
						ans = Math.max(ans,
								1 + solve(1, msk | (1 << i), sum + a1[i]));
				if (last != 2)
					if (sum + a2[i] <= 280)
						ans = Math.max(ans,
								1 + solve(2, msk | (1 << i), sum + a2[i]));
			}
		return dp[last + 1][sum][msk] = ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			a0 = new int[n];
			for (int i = 0; i < n; i++)
				a0[i] = in.nextInt();

			a1 = new int[n];
			for (int i = 0; i < n; i++)
				a1[i] = in.nextInt();

			a2 = new int[n];
			for (int i = 0; i < n; i++)
				a2[i] = in.nextInt();
			dp = new int[4][300][(1 << n) + 5];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 300; j++)
					Arrays.fill(dp[i][j], -1);
			sb.append(solve(-1, 0, 0)).append("\n");
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
