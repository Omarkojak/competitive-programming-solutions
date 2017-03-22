package OfficialContests.GCPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

	static long mulmod(long a, long b, long c) {
		long x = 0, y = a % c;
		while (b > 0) {
			if (b % 2 == 1)
				x = (x + y) % c;
			y = (y * 2) % c;
			b /= 2;
		}
		return x % c;
	}

	static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	static long pollard_rho(long n) {
		int i = 0, k = 2;
		long x = 3, y = 3;
		while (true) {
			i++;
			x = (mulmod(x, x, n) + n - 1) % n;
			long d = GCD(Math.abs(y - x), n);
			if (d != 1 && d != n)
				return d;
			if (i == k) {
				y = x;
				k *= 2;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long ans = pollard_rho(N);
		if (ans > N / ans)
			ans = N / ans;
		System.out.println(ans);
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

	}
}
