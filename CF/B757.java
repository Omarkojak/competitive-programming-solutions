package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B757 {

	static int n;
	static TreeMap<Integer, Integer> mp;
	static int larg;

	public static int solve() {
		boolean vis[] = new boolean[larg + 1];
		int max = 0;

		for (int i = 2; i <= larg; i++) {
			if (!vis[i]) {
				int cnt = 0;
				if (mp.containsKey(i))
					cnt += mp.get(i);
				for (int j = i * 2; j <= larg; j += i) {
					vis[j] = true;
					if (mp.containsKey(j))
						cnt += mp.get(j);
				}
				max = Math.max(max, cnt);
			}
		}

		return Math.max(max, 1);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		mp = new TreeMap<>();
		larg = 0;
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int cn = 0;
			if (mp.containsKey(x))
				cn = mp.get(x);
			mp.put(x, cn + 1);
			larg = Math.max(larg, x);
		}
		System.out.println(solve());
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
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
