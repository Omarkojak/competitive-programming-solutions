package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11701_Cantor {
	static final int factor = (int) 1e6;
	static Boolean[] dp;

	static boolean hasOne(int x) {
		if (dp[x] != null)
			return dp[x];
		dp[x] = false;
		int y = x * 3;
		return dp[x] = (y / factor) == 1 || hasOne(y % factor);

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		dp = new Boolean[factor * 10];
		while (true) {
			String s = in.nextLine();
			if (s.equals("END"))
				break;
			if (s.length() == 1)
				sb.append("MEMBER").append("\n");
			else {
				s = s.substring(2);
				int x = 0;
				int i;
				for (i = 0; i < s.length(); i++)
					x = x * 10 + s.charAt(i) - '0';
				for (; i < 6; i++)
					x *= 10;
				sb.append(hasOne(x) ? "NON-MEMBER\n" : "MEMBER\n");
			}

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
