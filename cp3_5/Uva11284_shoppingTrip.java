package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11284_shoppingTrip {
	static int n, p;
	static double[][] dist;
	static double[][] dp;
	static double[] savedval;
	static int[] dvdstore;
	static final double inf = 1e9;
	static final double nonvis = -999999999;
	static final double EPS = 1e-9;

	static double solve(int city, int msk) {
		if (msk == (1 << p) - 1)
			return -dist[city][0];

		if (dp[city][msk] != nonvis) {
			return dp[city][msk];
		}

		double max = -dist[city][0];
		for (int i = 0; i < n; i++)
			if (dvdstore[i] != -1 && (msk & (1 << dvdstore[i])) == 0)
				max = Math.max(
						max,
						savedval[i] - dist[city][i]
								+ solve(i, msk | (1 << dvdstore[i])));
		return dp[city][msk] = max;
	}

	static void floyd() {
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			in.nextLine();
			n = in.nextInt() + 1;
			dist = new double[n][n];
			dvdstore = new int[n];
			Arrays.fill(dvdstore, -1);
			savedval = new double[n];

			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], inf);
				dist[i][i] = 0;
			}
			int m = in.nextInt();
			while (m-- > 0) {
				int u = in.nextInt();
				int v = in.nextInt();
				double c = Math.min(in.nextDouble(), dist[u][v]);
				dist[u][v] = c;
				dist[v][u] = c;
			}
			floyd();

			p = in.nextInt();
			for (int i = 0; i < p; i++) {
				int store = in.nextInt();
				double val = in.nextDouble();
				savedval[store] = val;
				dvdstore[store] = i;
			}
			dp = new double[n][1 << p];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], nonvis);
			double max = solve(0, 0);
			if (max < EPS)
				sb.append("Don't leave the house\n");
			else
				sb.append("Daniel can save $")
						.append(new DecimalFormat("0.00").format(max))
						.append("\n");

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
