package OfficialContests.HIAST16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
	static int n, arr[];
	static int dp[][];
	static final int offset = ((int) 1e4) + 5;

	public static int solve(int idx, int diff) {
		if (idx == n)
			return Math.abs(diff);

		if (dp[idx][diff + offset] != -1)
			return dp[idx][diff + offset];

		return dp[idx][diff + offset] = Math.max(
				Math.abs(diff),
				Math.min(solve(idx + 1, arr[idx] - diff),
						solve(idx + 1, diff - arr[idx])));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			dp = new int[105][offset * 2 + 10];
			for (int i = 0; i < 105; i++)
				Arrays.fill(dp[i], -1);

			sb.append(solve(0, 0)).append("\n");
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
