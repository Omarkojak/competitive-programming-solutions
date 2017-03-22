package cp5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva847_AMultiplicationGame {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = in.nextLine();
			if (s == null || s.length() == 0)
				break;

			long n = Long.parseLong(s);
			long p = 1;
			int id = 0;
			while (p < n) {
				if (id == 0)
					p *= 9;
				else
					p *= 2;
				id ^= 1;
			}
			sb.append(id == 1 ? "Stan wins.\n" : "Ollie wins.\n");
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
	}
}
