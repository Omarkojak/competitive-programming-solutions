package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C467 {
	static int n, m;
	static long[] sum, dp[];
	static final long inf = (long) 1e18;

	public static long solve(int idx, int rem) {
		if (idx > n || (idx == n && rem != 0))
			return -inf;
		if (rem == 0)
			return 0;

		if(dp[idx][rem] != -1)
			return dp[idx][rem];
		
		long s = 0;
		if (idx + m <= n)
			s = sum[idx + m - 1] - (idx > 0 ? sum[idx - 1] : 0);
		long take = s + solve(idx + m, rem - 1);
		long leave = solve(idx + 1, rem);

		return dp[idx][rem] = Math.max(take, leave);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int k = in.nextInt();
		long arr[] = new long[n];
		sum = new long[n];
		for (int i = 0; i < n; i++) {
			sum[i] += arr[i] = in.nextLong();
			if (i > 0)
				sum[i] += sum[i - 1];
		}
		dp = new long[n + 5][k + 5];
		for(int i=0;i<n+5;i++)
			Arrays.fill(dp[i], -1);
		System.out.println(solve(0, k));

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
