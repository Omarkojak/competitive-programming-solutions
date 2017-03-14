package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C706 {
	static int n;
	static String[] s, rev;
	static int cost[];
	static long dp[][];
	static final long inf = (long) 1e18;

	public static long solve(int idx, int reversed) // rev 1-> true 0-> false
	{
		if (idx == n)
			return 0;
		if (dp[idx][reversed] != -1)
			return dp[idx][reversed];
		long min = inf;
		int a1 = s[idx].compareTo(s[idx - 1]);
		int a2 = rev[idx].compareTo(s[idx - 1]);
		if (reversed == 1) {
			a1 = s[idx].compareTo(rev[idx - 1]);
			a2 = rev[idx].compareTo(rev[idx - 1]);
		}
		if (a1 < 0 && a2 < 0)
			return dp[idx][reversed] = inf;

		if (a1 >= 0 && a2 >= 0)
			min = Math.min(cost[idx] + solve(idx + 1, 1), solve(idx + 1, 0));
		else {
			if (a1 < 0 && a2 >= 0)
				min = Math.min(min, cost[idx] + solve(idx + 1, 1));
			else {
				if (a1 >= 0 && a2 < 0)
					min = Math.min(min, solve(idx + 1, 0));
			}
		}
		return dp[idx][reversed] = min;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		cost = new int[n];
		s = new String[n];
		rev = new String[n];
		for (int i = 0; i < n; i++)
			cost[i] = in.nextInt();
		for (int i = 0; i < n; i++) {
			s[i] = in.nextLine();
			rev[i] = reverse(s[i]);
		}
		dp = new long[n][2];
		for (int i = 0; i < n; i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		// System.out.println("ba".compareTo("ac")); //1
		// System.out.println("ac".compareTo("ba")); //-1
		// System.out.println("aa".compareTo("aa")); //0
		 long min = Math.min(cost[0] + solve(1, 1), solve(1, 0));
		 System.out.println((min == inf)? -1:min);

	}

	static String reverse(String k) {
		StringBuilder sb = new StringBuilder(k);
		sb.reverse();
		return sb.toString();
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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
