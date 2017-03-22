package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A757 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0;
		char[] s = in.nextLine().toCharArray();
		for (char c : s) {
			if (c == 'B')
				a1++;
			if (c == 'u')
				a2++; // 2
			if (c == 'l')
				a3++;
			if (c == 'b')
				a4++;
			if (c == 'a')
				a5++;// 2
			if (c == 's')
				a6++;
			if (c == 'r')
				a7++;

		}
		int mn1 = Math.min(a1, a2 / 2);
		int mn2 = Math.min(a3, a4);
		int mn3 = Math.min(a5 / 2, a6);
		System.out.println(Math.min(Math.min(mn1, mn2), Math.min(mn3, a7)));
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
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
