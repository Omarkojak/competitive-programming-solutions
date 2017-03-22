package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A549 {
	static boolean f1 = false;
	static boolean f2 = false;
	static boolean f3 = false;
	static boolean f4 = false;

	static void ev(char c) {
		if (c == 'f')
			f1 = true;
		if (c == 'a')
			f2 = true;
		if (c == 'c')
			f3 = true;
		if (c == 'e')
			f4 = true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] t = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			for (int j = 0; j < m; j++)
				t[i][j] = s.charAt(j);
		}
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				f1 = false;
				f2 = false;
				f3 = false;
				f4 = false;
				ev(t[i][j]);
				ev(t[i + 1][j]);
				ev(t[i][j + 1]);
				ev(t[i + 1][j + 1]);
				if (f1 && f2 && f3 && f4)
					res++;
			}
		}
		System.out.println(res);
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
