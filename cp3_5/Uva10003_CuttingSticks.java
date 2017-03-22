package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10003_CuttingSticks {
	static int[] a;
	static int[][] memo;

	static int cut(int left, int right) {
		if (left == right - 1)
			return 0;

		if (memo[left][right] != -1)
			return memo[left][right];

		int min = -1;
		for (int i = left + 1; i < right; i++)
			if (min == -1)
				min = cut(left, i) + cut(i, right);
			else
				min = Math.min(min, cut(left, i) + cut(i, right));

		return memo[left][right] = min + (a[right] - a[left]);

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int l = in.nextInt();
		while (l != 0) {
			int n = in.nextInt();
			a = new int[n + 2];
			for (int i = 1; i <= n; i++)
				a[i] = in.nextInt();
			a[0] = 0;
			a[n + 1] = l;
			memo = new int[n + 5][n + 5];
			for (int i = 0; i < n + 5; i++)
				Arrays.fill(memo[i], -1);

			sb.append("The minimum cutting is " + cut(0, n + 1)).append(".\n");
			l = in.nextInt();
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
