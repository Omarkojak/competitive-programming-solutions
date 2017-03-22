package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10690_ExpressionAgain {
	static int n, m;
	static int[] arr;
	static boolean dp[][];

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (in.ready()) {
			String s = in.nextLine();
			if (s.isEmpty())
				continue;
			StringTokenizer ns = new StringTokenizer(s);
			n = Integer.parseInt(ns.nextToken());
			m = Integer.parseInt(ns.nextToken());
			arr = new int[n + m + 1];
			int sum = 0;
			for (int i = 1; i <= n + m; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
				arr[i] += 50;
			}
			dp = new boolean[110][10000 + 150];
			dp[0][0] = true;
			for (int i = 1; i <= n + m; i++)
				for (int j = Math.min(i, n); j >= 1; j--)
					for (int k = 0; k <= 10000; k++)
						if (dp[j - 1][k])
							dp[j][k + arr[i]] = true;
			int max = -5000;
			int min = 5000;
			for (int i = 0; i <= 10000; i++)
				if (dp[n][i]) {
					int tmp = i - 50 * n;
					max = Math.max(max, tmp * (sum - tmp));
					min = Math.min(min, tmp * (sum - tmp));
				}
			sb.append(max + " " + min).append("\n");
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
