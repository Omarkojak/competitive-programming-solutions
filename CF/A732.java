package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A732 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int k = in.nextInt();
		int cnt = 1;
		while (true) {

			if ((cnt * n) % 10 == 0 || (cnt * n - k) % 10 == 0)
				break;

			cnt++;
		}
		System.out.println(cnt);

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
