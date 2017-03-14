package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A716 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int last = 0, cnt = 1;
		int n = in.nextInt();
		int c = in.nextInt();
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			if (i != 0) {
				if (Math.abs(x - last) > c)
					cnt = 1;
				else
					cnt++;
			}
			last = x;

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
