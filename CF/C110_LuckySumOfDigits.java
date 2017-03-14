package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C110_LuckySumOfDigits {
	static int dp[];
	static final int inf = (int) 1e8;
	static StringBuilder sb;

	public static int solve(int n) {
		if (n < 0)
			return inf;
		if (n == 0)
			return 0;

		if (dp[n] != -1)
			return dp[n];
		
		int four = solve(n - 4);
		int seven = solve(n - 7);
		return dp[n] = Math.min(four, seven) + 1;
	}

	public static void print(int n) {
		if (n == 0) 
			return;
		
		if (solve(n) == solve(n - 4) + 1) {
			sb.append(4);
			print(n - 4);
			return;
		}
		sb.append(7);
		print(n - 7);

		
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sb = new StringBuilder();
		int n = in.nextInt();
		dp = new int[n + 5];
		Arrays.fill(dp, -1);
		int val = solve(n);
		if (val >= inf)
			sb.append(-1);
		else
			print(n);
		System.out.println(sb);
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
