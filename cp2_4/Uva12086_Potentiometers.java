package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva12086_Potentiometers {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int c = 1;
		while (n != 0) {
			if (c > 1)
				sb.append("\n");
			sb.append("Case " + c++ + ":\n");
			FenwickTree ft = new FenwickTree(n);
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = in.nextInt();
				ft.point_update(i, a[i]);
			}
			while (true) {
				StringTokenizer ns = new StringTokenizer(in.nextLine());
				String s = ns.nextToken();
				if (s.equals("END"))
					break;
				int x1 = Integer.parseInt(ns.nextToken());
				int x2 = Integer.parseInt(ns.nextToken());
				if (s.equals("S")) {
					ft.point_update(x1, x2 - a[x1]);
					a[x1] = x2;
				} else
					sb.append(ft.rsq(x1, x2)).append("\n");
			}
			n = in.nextInt();
		}
		System.out.print(sb);
	}

	static class FenwickTree {
		int n;
		int[] ft;

		FenwickTree(int size) {
			n = size;
			ft = new int[n + 1];
		}

		int rsq(int b) // O(log n)
		{
			int sum = 0;
			while (b > 0) {
				sum += ft[b];
				b -= b & -b;
			} // min?
			return sum;
		}

		int rsq(int a, int b) {
			return rsq(b) - rsq(a - 1);
		}

		void point_update(int k, int val) // O(log n), update = increment
		{
			while (k <= n) {
				ft[k] += val;
				k += k & -k;
			} // min?
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
