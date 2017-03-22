package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D617 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		if (x1 == x2 && x2 == x3) {
			System.out.println(1);
			return;
		}
		if (y1 == y2 && y2 == y3) {
			System.out.println(1);
			return;
		}
		if (x1 == x2) {
			if (y3 < Math.max(y1, y2) && y3 > Math.min(y1, y2))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}
		if (x2 == x3) {
			if (y1 < Math.max(y2, y3) && y1 > Math.min(y2, y3))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}
		if (x1 == x3) {
			if (y2 < Math.max(y1, y3) && y2 > Math.min(y1, y3))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}

		if (y1 == y2) {
			if (x3 > Math.min(x1, x2) && x3 < Math.max(x1, x2))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}
		if (y2 == y3) {
			if (x1 > Math.min(x3, x2) && x1 < Math.max(x3, x2))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}
		if (y1 == y3) {
			if (x2 > Math.min(x1, x3) && x2 < Math.max(x1, x3))
				System.out.println(3);
			else
				System.out.println(2);
			return;
		}
		System.out.println(3);

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
