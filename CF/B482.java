package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B482 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		constraint[] constraints = new constraint[m];
		int[][] ones = new int[n + 2][32];
		for (int i = 0; i < m; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int q = in.nextInt();
			constraints[i] = new constraint(l, r, q);
			int pos = 0;
			while (q > 0) {
				if (q % 2 == 1) {
					ones[l][pos]++;
					ones[r + 1][pos]--;
				}
				++pos;
				q >>= 1;
			}
		}
		int N = 1;
		while (N < n)
			N <<= 1;

		int[] a = new int[N + 1];
		for (int j = 0; j < 32; j++) {
			int sum = 0;
			for (int i = 1; i < n + 2; i++) {
				sum += ones[i][j];
				if (sum > 0) {
					a[i] += 1 << j;
				}
			}
		}
		for (int i = n + 1; i <= N; i++)
			a[i] = a[i - 1];
		boolean flag = true;
		SegmentTree st = new SegmentTree(a);
		for (constraint c : constraints) {
			if (st.query(c.l, c.r) != c.q)
				flag = false;
		}
		if (flag) {
			out.println("YES");
			for (int i = 1; i <= n; i++)
				out.print(a[i] + " ");
		} else
			out.println("NO");
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int sTree[];
		int[] arr;
		int N;

		SegmentTree(int[] a) {
			arr = a;
			N = a.length - 1;
			sTree = new int[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) {
			if (b == e) {
				sTree[node] = arr[b];
			} else {
				int mid = (b + e) >> 1;
				build(node << 1, b, mid);
				build((node << 1) | 1, mid + 1, e);
				sTree[node] = sTree[node << 1] & sTree[(node << 1) | 1];
			}
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		int query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return -1;
			if (b >= i && e <= j)
				return sTree[node];

			int mid = (b + e) >> 1;
			int q1 = query(node << 1, b, mid, i, j);
			int q2 = query((node << 1) | 1, mid + 1, e, i, j);
			if (q1 == -1)
				return q2;
			if (q2 == -1)
				return q1;

			return q1 & q2;
		}

	}

	static class constraint {
		int l;
		int r;
		int q;

		constraint(int a, int b, int c) {
			l = a;
			r = b;
			q = c;
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
