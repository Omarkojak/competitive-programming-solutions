package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Uva11552FewestFlops {
	static char[] s;
	static int n, k;
	static int cnt[][];
	static int distinct[];
	static int dp[][];
	static final int inf = (int) 1e7;

	static int solve(int idx, int c) {
		if (idx == k)
			return 0;
		if (dp[idx][c] != -1)
			return dp[idx][c];
		int ret = inf, minus = cnt[idx][c] != 0 ? 1 : 0, chs = distinct[idx];
		for (int i = 0; i < 26; ++i)
			if (cnt[idx][i] != 0)
				ret = Math.min(ret, chs
						- (chs > 1 && i == c || chs == 1 && i != c ? 0 : minus)
						+ solve(idx + 1, i));
		return dp[idx][c] = ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int k1 = in.nextInt();
			s = in.next().toCharArray();
			n = s.length;
			k = n / k1;
			cnt = new int[k][27];
			distinct = new int[k];
			for (int i = 0; i < k; i++) {
				TreeSet<Character> ts = new TreeSet<>();
				for (int j = 0; j < k1; j++) {
					cnt[i][s[i * k1 + j] - 'a']++;
					ts.add(s[i * k1 + j]);
				}
				distinct[i] = ts.size();
			}
			dp = new int[k][27];
			for (int i = 0; i < k; i++)
				Arrays.fill(dp[i], -1);
			int min = solve(0, 26);
			sb.append((min == inf) ? s.length : min).append("\n");

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
