package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class F630 {

	public static BigInteger permutate(long x, int times) {
		BigInteger res = new BigInteger("1");
		while (times-- > 0) {
			res = res.multiply(new BigInteger(x + ""));
			x--;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		BigInteger fac5 = new BigInteger(120l + "");
		BigInteger fac6 = new BigInteger(720l + "");
		BigInteger fac7 = new BigInteger(5040l + "");
		BigInteger res1 = permutate(n, 5).divide(fac5);
		BigInteger res2 = permutate(n, 6).divide(fac6);
		BigInteger res3 = permutate(n, 7).divide(fac7);
		BigInteger out = res1.add(res2);
		out = out.add(res3);
		System.out.println(out);

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
