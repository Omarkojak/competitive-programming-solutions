package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B639 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int h = in.nextInt();
		StringBuilder sb = new StringBuilder();

		if (n == 2) {
			if (d == 1 && h == 1)
				System.out.println("1 2");
			else
				System.out.println(-1);
			return;
		}
		if (d > 2 * h) {
			System.out.println(-1);
			return;
		}
		int nodes = 1;
		for (int i = 0; i < h; i++)
			sb.append(nodes + " " + ++nodes).append("\n");

		if (d > h) {
			sb.append(1 + " " + ++nodes).append("\n");
			for (int i = 0; i < d - h - 1 && nodes < n; i++)
				sb.append(nodes + " " + ++nodes).append("\n");
		}
		if (nodes > n) {
			System.out.println(-1);
			return;
		}
		while (nodes < n) {
			// sb.append("1").append("\n");
			sb.append(2 + " " + ++nodes).append("\n");
		}
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
}
