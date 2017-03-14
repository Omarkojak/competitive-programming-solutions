package OfficialContests.NEERC15_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {
	static long[] time, dp;
	static int n, range;
	static final long inf = (long) 1e18;

	public static long solve(int idx) {
		if (idx == n)
			return 0;

		if (dp[idx] != -1)
			return dp[idx];

		long min = inf;
		for (int i = 1; i <= range && idx + i <= n; i++)
			min = Math.min(min, solve(idx + i) + time[idx + i] + i);

		return dp[idx] = min;
	}


	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// Scanner in = new Scanner(new File("journey.in"));
		// PrintWriter out = new PrintWriter("journey.out");
		n = in.nextInt();
		long T = in.nextLong();
		time = new long[n + 1];
		int[] price = new int[n];
		for (int i = 1; i < n; i++)
			price[i] = in.nextInt();

		for (int i = 2; i <= n - 1; i++)
			time[i] = in.nextLong();

		int low = 1, high = n - 1;
		int ans = 0;

		while (low <= high) {
			int mid = (low + high) >> 1;
			range = mid;
			dp = new long[n + 5];
			Arrays.fill(dp, -1);
			if (solve(1) <= T) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		long res = Long.MAX_VALUE;
		for (int i = ans; i < n; i++)
			res = Math.min(res, price[i]);
		out.println(res);
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(File f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
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
