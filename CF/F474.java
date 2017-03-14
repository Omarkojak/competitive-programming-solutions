package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F474 {
	static final int inf = ((int) 1e9) + 100;

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int N = 1;
		while (N < n)
			N <<= 1;
		int[] arr = new int[N + 1];
		Arrays.fill(arr, inf);
		for (int i = 1; i <= n; i++) {
			arr[i] = in.nextInt();
		}

		SegmentTree st = new SegmentTree(arr);
		int q = in.nextInt();
		while (q-- > 0) {
			int i = in.nextInt();
			int j = in.nextInt();
			Trio t = st.query(i, j);
			int ans = j - i + 1;
			if (t != null && t.min == t.gcd)
				ans -= t.occ;
			// System.out.println(t.min + " " + t.gcd + " " + t.occ);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	static class Trio {
		int min, gcd, occ;

		Trio(int a, int b, int c) {
			min = a;
			gcd = b;
			occ = c;

		}
	}

	static class SegmentTree {
		int N;
		Trio[] sTree;
		int[] arr;

		SegmentTree(int[] in) {
			arr = in;
			N = in.length - 1;
			sTree = new Trio[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) {
			if (b == e) {
				if (arr[b] != inf)
					sTree[node] = new Trio(arr[b], arr[b], 1);
			} else {
				build(node << 1, b, (b + e) / 2);
				build((node << 1) + 1, (b + e) / 2 + 1, e);
				sTree[node] = merge(sTree[node << 1], sTree[(node << 1) + 1]);
			}
		}

		static Trio merge(Trio t1, Trio t2) {
			if (t1 == null && t2 == null)
				return null;
			if (t1 == null)
				return new Trio(t2.min, t2.gcd, t2.occ);
			if (t2 == null)
				return new Trio(t1.min, t1.gcd, t1.occ);
			int min = Math.min(t1.min, t2.min);
			int occ = 0;
			if (t1.min == min)
				occ += t1.occ;
			if (t2.min == min)
				occ += t2.occ;
			return new Trio(min, GCD(t1.gcd, t2.gcd), occ);
		}

		public Trio query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		public Trio query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return null;
			if (b >= i && e <= j)
				return sTree[node];
			Trio q1 = query(node << 1, b, (b + e) / 2, i, j);
			Trio q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			return merge(q1, q2);
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
