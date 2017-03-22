package OfficialContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fegalqualf1_A_Balance {

	public static int ev(char c1, char c2) {
		if (c1 == '(') {
			if (c2 == ')')
				return 0;
			else
				return 1;

		}
		if (c1 == '[') {
			if (c2 == ']')
				return 0;
			else
				return 1;
		}
		if (c1 == ')') {
			if (c2 == ')')
				return 0;
			else
				return 2;

		}
		if (c1 == ']') {
			if (c2 == ']')
				return 0;
			else
				return 2;

		}
		return 0;

	}

	public static int solve(String s) {
		if (s.length() % 2 != 0)
			return -1;

		int i = (s.length() / 2) - 1;
		int j = i + 1;
		int res1 = 0;
		while (i >= 0) {
			res1 += ev(s.charAt(i), s.charAt(j));
			i--;
			j++;
		}
		StringBuilder sb = new StringBuilder(s);
		int l = s.length() / 2;
		if (l != 1) {
			int res2 = solve(sb.substring(0, l));
			int res3 = solve(sb.substring(l, s.length()));

			if (res2 == -1)
				return res1;
			int res4 = res2 + res3;
			return Math.min(res4, res1);
		}
		return res1;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.nextLine();
			if (s.length() == 0)
				System.out.println(0);
			else
				System.out.println(solve(s));
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
