package OfficialContests.SamaraVIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	static int n;
	static item[] arr;
	static long[][][] dp;
	static final long inf = (long) 1e15;
	static int maxw;
	static int offset = 201;

	public static long solve(int taken, int idx, int w) {
		if (taken < 0)
			return -inf;
		if (w < -200)
			return -inf;
		if (idx == n) {
			if (w >= 0)
				return 0;
			else
				return -inf;
		}

		if (dp[taken][w + offset][idx] != -1)
			return dp[taken][w + offset][idx];

		long takeadd = arr[idx].p
				+ solve(taken - 1, idx + 1, w - arr[idx].w + arr[idx].d);
		long take = arr[idx].p + solve(taken, idx + 1, w - arr[idx].w);
		long leave = solve(taken, idx + 1, w);

		long max = Math.max(takeadd, Math.max(take, leave));

		return dp[taken][w + offset][idx] = max;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		maxw = in.nextInt();
		arr = new item[n];
		for (int i = 0; i < n; i++)
			arr[i] = new item(in.nextInt(), in.nextInt(), in.nextInt());
		dp = new long[3][920][n];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 920; j++)
				Arrays.fill(dp[i][j], -1);
		System.out.println(solve(2, 0, maxw));

	}

	static class item {
		int p, w, d;

		item(int a, int b, int c) {
			p = a;
			w = b;
			d = c;
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
	}
}