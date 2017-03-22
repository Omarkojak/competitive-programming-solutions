package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10482_TheCandymanCan {
	static int[][][] dp;
	static int[] candies, acc;
	static int n;

	static int solve(int idx, int x, int y) {
		int z = acc[idx] - (x + y);
		if (idx == n)
			return max(x, y, z) - min(x, y, z);

		if (dp[idx][x][y] != -1)
			return dp[idx][x][y];

		int op1 = solve(idx + 1, x + candies[idx], y);
		int op2 = solve(idx + 1, x, y + candies[idx]);
		int op3 = solve(idx + 1, x, y);
		return dp[idx][x][y] = min(op1, op2, op3);

	}

	static int max(int x, int y, int z) {
		return Math.max(x, Math.max(y, z));
	}

	static int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			candies = new int[n];
			acc = new int[n + 1];
			for (int i = 0; i < n; i++) {
				candies[i] = in.nextInt();
				if (i != 0)
					acc[i] = acc[i - 1] + candies[i - 1];
			}
			acc[n] = acc[n - 1] + candies[n - 1];
			dp = new int[n][650][650];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 650; j++)
					Arrays.fill(dp[i][j], -1);
			out.printf("Case %d: %d\n", cse++, solve(0, 0, 0));
		}
		out.flush();
		out.close();

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
