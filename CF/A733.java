package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A733 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int last = 0;
		int max = 0;
		for (int i = 1; i <= s.length; i++) {
			if (s[i - 1] == 'A' || s[i - 1] == 'O' || s[i - 1] == 'E' || s[i - 1] == 'I'
					|| s[i - 1] == 'U' || s[i - 1] == 'Y') {
				max = Math.max(max, i - last);
				last = i;
			}
		}
		max = Math.max(max, s.length + 1 - last);
		System.out.println(max);
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
