package adhocs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10035_PrimaryArithmetic {

	public static String comp(String s, int l) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++)
			sb.append("0");
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			String s1 = in.next();
			String s2 = in.next();
			if (s1.equals("0") && s2.equals("0"))
				break;
			int l1 = s1.length();
			int l2 = s2.length();

			if (l2 > l1)
				s1 = comp(s1, l2 - l1);
			else
				s2 = comp(s2, l1 - l2);

			int carrysofar = 0;
			int res = 0;
			for (int i = s1.length() - 1; i >= 0; i--) {
				int a1 = s1.charAt(i) - '0';
				int a2 = s2.charAt(i) - '0';
				if (carrysofar + a1 + a2 >= 10)
					res++;
				if (carrysofar + a1 + a2 >= 10)
					carrysofar = (carrysofar + a1 + a2) / 10;
				else
					carrysofar = 0;
			}
			if (res == 0)
				System.out.println("No carry operation.");

			if (res == 1)
				System.out.println("1 carry operation.");

			if (res > 1)
				System.out.printf("%d carry operations.\n", res);
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
