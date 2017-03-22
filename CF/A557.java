package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A557 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min1 = in.nextInt();
		int max1 = in.nextInt();
		int min2 = in.nextInt();
		int max2 = in.nextInt();
		int min3 = in.nextInt();
		in.nextInt();
		int res = min1 + min2 + min3;
		if (res == n) {
			System.out.println(min1 + " " + min2 + " " + min3);
			return;
		}
		int dif1 = max1 - min1;
		int dif2 = max2 - min2;
		if (res + dif1 >= n) {
			System.out.println((n - res + min1) + " " + min2 + " " + min3);
			return;
		}
		res += dif1;

		if (res + dif2 >= n) {
			System.out.println(max1 + " " + (n - res + min2) + " " + min3);
			return;
		}
		res += dif2;

		System.out.println(max1 + " " + max2 + " " + (n - res + min3));

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
