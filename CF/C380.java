package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C380 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		int N = 1;
		int n = s.length();
		while (N < n)
			N <<= 1;
		Trio[] a = new Trio[N + 1];

		for (int i = 1; i <= s.length(); i++)
			a[i] = (s.charAt(i - 1) == '(') ? new Trio(1, 0, 0) : new Trio(0,
					1, 0);

		for (int i = 0; i < a.length; i++)
			if (a[i] == null)
				a[i] = new Trio(0, 0, 0);

		SegmentTree st = new SegmentTree(a);
		int q = in.nextInt();
		while (q-- > 0)
			sb.append(st.query(in.nextInt(), in.nextInt())).append("\n");

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

	static class Trio {
		int op;
		int clos;
		int ressofar;

		Trio(int a, int b, int c) {
			op = a;
			clos = b;
			ressofar = c;

		}
	}

	static class SegmentTree {
		int N;
		Trio Stree[];
		Trio[] arr;

		SegmentTree(Trio[] a) {
			arr = a;
			N = a.length - 1;
			Stree = new Trio[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) {
			if (b == e) {
				Stree[node] = new Trio(arr[b].op, arr[b].clos, arr[b].ressofar);
			} else {
				build((node << 1), b, (b + e) / 2);
				build((node << 1) + 1, (b + e) / 2 + 1, e);
				Trio left = Stree[node << 1];
				Trio right = Stree[(node << 1) + 1];
				int res = Math.min(left.op, right.clos);
				int open = left.op + right.op - res;
				int close = left.clos + right.clos - res;

				Stree[node] = new Trio(open, close, res * 2 + left.ressofar
						+ right.ressofar);
			}
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j).ressofar;
		}

		Trio query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return new Trio(0, 0, 0);

			if (b >= i && e <= j)
				return Stree[node];

			Trio left = query(node << 1, b, (b + e) / 2, i, j);
			Trio right = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			int res = Math.min(left.op, right.clos);
			int open = left.op + right.op - res;
			int close = left.clos + right.clos - res;

			return new Trio(open, close, res * 2 + left.ressofar
					+ right.ressofar);

		}

	}
}
