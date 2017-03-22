package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11003_Boxes {
	static int n;
	static int dp[][];
	static Box[] b;
	static final int inf = (int) 5000;

	public static int solve(int idx, int mnldfar) {
		if (idx == n)
			return 0;

		if (dp[idx][mnldfar] != -1)
			return dp[idx][mnldfar];
		int take = 0;
		if (b[idx].w <= mnldfar)
			take = solve(idx + 1, Math.min(mnldfar - b[idx].w, b[idx].l)) + 1;
		int leave = solve(idx + 1, mnldfar);
		return dp[idx][mnldfar] = Math.max(leave, take);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			b = new Box[n];
			for (int i = 0; i < n; i++)
				b[i] = new Box(in.nextInt(), in.nextInt());
			dp = new int[n + 5][5005];
			for (int i = 0; i < n + 5; i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(0, inf) + "\n");
			n = in.nextInt();
		}
		System.out.print(sb);
	}

	static class Box implements Comparable<Box> {
		int w;
		int l;

		Box(int a, int b) {
			w = a;
			l = b;
		}

		@Override
		public int compareTo(Box o) {
			if (this.l != o.l)
				return this.l - o.l;
			return this.w - o.w;
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
