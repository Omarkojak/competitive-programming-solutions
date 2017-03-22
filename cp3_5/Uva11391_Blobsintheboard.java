package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11391_Blobsintheboard {
	static int r, c;
	static int n;
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 };
	static int[][] dp;

	static boolean valid(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	static int ones(int x) {
		int res = 0;
		while (x > 0) {
			if (x % 2 != 0)
				res++;
			x /= 2;
		}
		return res;
	}

	static int solve(int msk, int jumps) {
		int rem = ones(msk);
		if (jumps == n - 1)
			if (rem == 1)
				return 1;
			else
				return 0;

		if (dp[msk][jumps] != -1)
			return dp[msk][jumps];

		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int rep = 1 << (i * 4 + j);
				if ((rep & msk) != 0) {
					for (int k = 0; k < 8; k++) {
						int xn1 = i + dx[k];
						int yn1 = j + dy[k];
						if (valid(xn1, yn1)) {
							int there1 = 1 << (xn1 * 4 + yn1);
							if ((there1 & msk) == 0) {
								continue;
							}

							int xn2 = i + 2 * dx[k];
							int yn2 = j + 2 * dy[k];
							if (valid(xn2, yn2)) {
								int there2 = 1 << (xn2 * 4 + yn2);
								if ((there2 & msk) != 0)
									continue;
								cnt += solve(msk ^ there2 ^ there1 ^ rep,
										jumps + 1);
							}

						}
					}
				}
			}
		}
		return dp[msk][jumps] = cnt;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int cse = 1;
		dp = new int[(1 << (4 * 4 + 4))][17];
		for (int i = 0; i < (1 << (4 * 4 + 4)); i++)
			Arrays.fill(dp[i], -1);

		while (t-- > 0) {
			r = in.nextInt();
			c = in.nextInt();
			n = in.nextInt();

			int rep = 0;
			for (int i = 0; i < n; i++) {
				int x = in.nextInt() - 1;
				int y = in.nextInt() - 1;
				rep |= (1 << (x * 4 + y));
			}
			System.out.printf("Case %d: %d\n", cse++, solve(rep, 0));
		}

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
