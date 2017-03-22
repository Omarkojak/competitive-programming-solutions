package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
	static int twos[], threes[], n, m, arr[][];
	static final int inf = (int) 1e9;

	static void fill() {
		twos = new int[(int) 1e3 + 5];
		threes = new int[(int) 1e3 + 5];
		for (int i = 1; i < twos.length; i++) {
			int num = i;
			while (num % 2 == 0) {
				twos[i]++;
				num >>= 1;
			}
			while (num % 3 == 0) {
				threes[i]++;
				num /= 3;
			}
		}
	}

	public static int solve() {
		int[][][] dp = new int[n][m][1500];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				Arrays.fill(dp[i][j], -inf);

		dp[0][0][threes[arr[0][0]]] = twos[arr[0][0]];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					continue;
				for (int k = threes[arr[i][j]]; k < 1500; k++) {
					int max = -inf;
					if (i > 0)
						max = Math.max(max, dp[i - 1][j][k - threes[arr[i][j]]]
								+ twos[arr[i][j]]);

					if (j > 0)
						max = Math.max(max, dp[i][j - 1][k - threes[arr[i][j]]]
								+ twos[arr[i][j]]);

					dp[i][j][k] = max;
				}
			}

		int max = Integer.MIN_VALUE;
		for (int k = 0; k < 1500; k++)
			max = Math.max(max, Math.min(k, dp[n - 1][m - 1][k]));
		return max;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		fill();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			arr = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					arr[i][j] = in.nextInt();

			sb.append(solve()).append("\n");

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
