package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C431 {
	static int d, k;
	static long dp[][];
	static final int MAX = 105;
	static final long MOD = (long) 1e9 + 7;

	public static long solve(int w, int max) {
		if (w < 0)
			return 0;
		if (w == 0 && max >= d)
			return 1;

		if (dp[w][max] != -1)
			return dp[w][max];

		long ret = 0;
		for (int i = 1; i <= k; i++)
			ret = (ret + (solve(w - i, Math.max(max, i)) % MOD)) % MOD;

		return dp[w][max] = ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		k = in.nextInt();
		d = in.nextInt();

		dp = new long[MAX][MAX];
		for (int i = 0; i < MAX; i++)
			Arrays.fill(dp[i], -1);

		System.out.println(solve(n, 0));

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
