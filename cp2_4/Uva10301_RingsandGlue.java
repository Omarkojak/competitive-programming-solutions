package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10301_RingsandGlue {
	static final double EPS = 1e-9;

	public static boolean intersect(Circle c1, Circle c2) {

		double LHS = ((c1.x - c2.x) * (c1.x - c2.x))
				+ ((c1.y - c2.y) * (c1.y - c2.y));
		double d = Math.sqrt(LHS);
		return (d < (c1.r + c2.r + EPS)) && (d + EPS > Math.abs((c1.r - c2.r)));

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n != -1) {
			Circle[] circles = new Circle[n];
			for (int i = 0; i < n; i++)
				circles[i] = new Circle(in.nextDouble(), in.nextDouble(),
						in.nextDouble());
			int[] checked = new int[n];
			int color = 1;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (j == i)
						continue;
					if (intersect(circles[i], circles[j]))
						if (checked[i] == 0 && checked[j] == 0) {
							checked[i] = checked[j] = color++;
						} else {
							if (checked[i] == 0 || checked[j] == 0) {
								int r = Math.max(checked[i], checked[j]);
								checked[i] = checked[j] = r;
							} else {
								for (int k = 0; k < n; k++)
									if (checked[k] == checked[j])
										checked[k] = checked[i];
							}
						}
				}
			int[] c = new int[n + 5];
			for (int i = 0; i < n; i++)
				c[checked[i]]++;

			int max = 0;
			for (int i = 1; i < n; i++)
				max = Math.max(max, c[i]);
			if ((max == 0 || max == 1) && n != 0) {
				System.out.printf("The largest component contains %d ring.\n",
						1);
			} else {
				System.out.printf("The largest component contains %d rings.\n",
						max);
			}
			
			n = in.nextInt();
		}
	}

	static class Circle {
		double x;
		double y;
		double r;

		Circle(double a, double b, double c) {
			x = a;
			y = b;
			r = c;
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
