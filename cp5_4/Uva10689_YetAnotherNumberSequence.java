package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Uva10689_YetAnotherNumberSequence {
	static BigInteger[] fib = new BigInteger[15001];

	static void fibonacci() {
		fib[0] = BigInteger.valueOf(0);
		fib[1] = BigInteger.valueOf(1);
		for (int i = 2; i <= 15000; i++)
			fib[i] = fib[i - 1].add(fib[i - 2]);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		fibonacci();
		int per[] = { 60, 300, 1500, 15000 };
		int mod[] = { 10, 100, 1000, 10000 };
		int t = in.nextInt();
		while (t-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt() - 1;
			BigInteger res = fib[(n - 1) % per[m]].multiply(BigInteger
					.valueOf(a % mod[m]));
			res = res.add(fib[n % per[m]].multiply(BigInteger.valueOf(b
					% mod[m])));
			sb.append(res.mod(BigInteger.valueOf(mod[m]))).append("\n");
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
