package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class A762 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Long N = in.nextLong();
		int k = in.nextInt();
		long max = (long) Math.sqrt(N);
		Stack<Long> st = new Stack<Long>();
		long ans = -1;
		for (long i = 1; i <= max; i++) {
			if (N % i == 0) {
				long x = N / i;
				if (x > i)
					st.add(N / i);
				k--;
				if (k == 0) {
					ans = i;
					break;
				}
			}
		}
		if (ans == -1) {
			while (!st.isEmpty()) {
				long x = st.pop();
				k--;
				if (k == 0) {
					ans = x;
					break;
				}

			}
		}
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
