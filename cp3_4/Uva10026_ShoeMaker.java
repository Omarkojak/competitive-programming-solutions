package cp3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10026_ShoeMaker {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			ratio[] a = new ratio[n];
			for (int i = 0; i < n; i++) {
				double n1 = in.nextInt() * 1.0;
				double n2 = in.nextInt() * 1.0;
				a[i] = new ratio(i + 1, n2 / n1);
			}
			Arrays.sort(a);
			for (int i = 0; i < n; i++) {
				System.out.print(a[i].num);
				if (i + 1 != n)
					System.out.print(" ");
			}
			System.out.println();

			if (t != 0)
				System.out.println();
		}

	}

	static class ratio implements Comparable<ratio> {
		double r;
		int num;

		ratio(int a, double b) {
			num = a;
			r = b;
		}

		public int compareTo(ratio o) {
			if (r > o.r)
				return -1;
			if (o.r > r)
				return 1;

			return num - o.num;

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
