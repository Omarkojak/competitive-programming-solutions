package DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva12532_IntervalProduct {

	public static char tochar(int num) {
		if (num == 0)
			return '0';
		if (num < 0)
			return '-';
		return '+';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		while (s != null) {
			StringTokenizer ns = new StringTokenizer(s);
			int n = Integer.parseInt(ns.nextToken());
			int k = Integer.parseInt(ns.nextToken());
			int N = 1;
			while (N < n)
				N <<= 1;
			int[] a = new int[N + 1];
			Arrays.fill(a, 1);
			for (int i = 1; i <= n; i++)
				a[i] = in.nextInt();
			SegmentTree st = new SegmentTree(a);
			while (k-- > 0) {
				char c = in.next().charAt(0);
				int x1 = in.nextInt();
				int x2 = in.nextInt();
				if (c == 'C')
					st.update_point(x1, x2);
				else
					sb.append(tochar(st.query(x1, x2)));
			}
			sb.append("\n");
			s = in.nextLine();
		}
		System.out.print(sb);

	}

	static class SegmentTree {
		int N;
		int[] array, sTree;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new int[N << 1];
			build(1, 1, N);
		}

		int val(int x) {
			if (x == 0)
				return 0;
			if (x > 0)
				return 1;
			return -1;
		}

		void build(int node, int b, int e) {
			if (b == e)
				sTree[node] = val(array[b]);
			else {
				build(node << 1, b, (b + e) / 2);
				build((node << 1) + 1, (b + e) / 2 + 1, e);
				sTree[node] = sTree[node << 1] * sTree[(node << 1) + 1];
			}
		}

		void update_point(int index, int val) {
			index += N - 1;
			sTree[index] = val(val);
			while (index > 1) {
				index >>= 1;
				sTree[index] = sTree[index << 1] * sTree[(index << 1) + 1];
			}
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		int query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return 1;
			if (b >= i && e <= j)
				return sTree[node];
			int q1 = query(node << 1, b, (b + e) / 2, i, j);
			int q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			return q1 * q2;

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
