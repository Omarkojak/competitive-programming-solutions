package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B644 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b = in.nextInt();
		StringBuilder sb = new StringBuilder();

		int mxtsofar = 0;
		int numorders = 0;
		int[] texp = new int[n];
		int idx = 0;
		int x = 0;
		int fofinished = -1;

		while (n-- > 0) {
			Order curr = new Order(in.nextInt(), in.nextInt());
			fofinished = texp[x];
			if (mxtsofar > curr.t && numorders == b) {
				if (fofinished <= curr.t) {
					mxtsofar += curr.d;
					numorders++;
					texp[idx++] = mxtsofar;
					sb.append(mxtsofar);
					x++;
				} else
					sb.append(-1);

			} else {

				mxtsofar += curr.d;
				numorders++;
				texp[idx++] = mxtsofar;
				sb.append(mxtsofar);

			}
			if (n != 0)
				sb.append(" ");
		}
		System.out.println(sb);
	}

	static class Order {
		int t, d;

		Order(int a, int b) {
			t = a;
			d = b;
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
