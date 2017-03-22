package cp5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva12469_Stones {
	static Boolean[][] dp;

	static boolean solve(int rem, int cnt) {
		if (rem == 0 || cnt == 0)
			return false;
		if (dp[rem][cnt] != null)
			return dp[rem][cnt];
		boolean op1 = cnt * 2 >= rem - cnt ? false : !solve(rem - cnt, cnt * 2);
		boolean op2 = solve(rem, cnt - 1);
		return dp[rem][cnt] = op1 || op2;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		dp = new Boolean[1005][1005];
		int n;
		while ((n = in.nextInt()) != 0) {
			sb.append(solve(n, n - 1) ? "Alicia\n" : "Roberto\n");
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
