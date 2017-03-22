package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva10261_FerryLoading {
	static int l, n;
	static ArrayList<Integer> as;
	static int[] sum;
	static TreeMap<Pair, Integer> dp;

	public static int solve(int idx, int p) {
		if (idx == n)
			return 0;
		int s = 0;
		if (idx != 0)
			s = sum[idx - 1] - p;

		Pair curr = new Pair(idx, p);
		if (dp.containsKey(curr))
			return dp.get(curr);

		int port = -1;
		if (p + as.get(idx) <= l)
			port = solve(idx + 1, p + as.get(idx));

		int star = -1;
		if (s + as.get(idx) <= l)
			star = solve(idx + 1, p);
		if (port == -1 && star == -1) {
			dp.put(curr, 0);
			return 0;
		}
		int max = Math.max(port, star) + 1;

		dp.put(curr, max);
		return max;
	}

	public static void print(int idx, int p) {
		if (idx == n)
			return;
		int s = 0;
		if (idx != 0)
			s = sum[idx - 1] - p;

		int port = -1;
		if (p + as.get(idx) <= l) {
			if (idx + 1 != n
					&& dp.containsKey(new Pair(idx + 1, p + as.get(idx))))
				port = dp.get(new Pair(idx + 1, p + as.get(idx)));
			else
				port = 0;
		}

		int star = -1;
		if (s + as.get(idx) <= l)
			if (idx + 1 != n && dp.containsKey(new Pair(idx + 1, p)))
				star = dp.get(new Pair(idx + 1, p));
			else
				star = 0;
		if (port == -1 && star == -1)
			return;

		if (dp.get(new Pair(idx, p)) == port + 1) {
			System.out.println("port");
			print(idx + 1, p + as.get(idx));
		} else {
			System.out.println("starboard");
			print(idx + 1, p);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			l = in.nextInt() * 100;
			as = new ArrayList<>();
			int curr = in.nextInt();
			while (curr != 0) {
				as.add(curr);
				curr = in.nextInt();
			}
			n = as.size();
			if (n != 0) {
				sum = new int[n];
				sum[0] = as.get(0);
				for (int i = 1; i < n; i++)
					sum[i] = sum[i - 1] + as.get(i);

				dp = new TreeMap<Pair, Integer>();
				int ans = solve(0, 0);
				System.out.println(ans);
				if (ans != 0)
					print(0, 0);
			} else {
				System.out.println(0);
			}
			if (t != 0)
				System.out.println();

		}
	}

	static class Pair implements Comparable<Pair> {
		int idx;
		int p;

		Pair(int a, int b) {
			idx = a;
			p = b;
		}

		public int compareTo(Pair o) {
			if (this.idx == o.idx && this.p == o.p)
				return 0;
			if (this.idx != o.idx)
				return this.idx - o.idx;

			return this.p - o.p;
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