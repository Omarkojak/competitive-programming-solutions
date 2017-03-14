package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B723 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		in.nextInt();
		char[] s = in.nextLine().toCharArray();
		int a1 = 0;
		int a2 = 0;

		StringBuilder sofar = new StringBuilder();
		boolean f = false;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(') {
				a1 = Math.max(a1, sofar.length());
				sofar = new StringBuilder();
				f = true;
				continue;
			}

			if (s[i] == ')') {
				f = false;
				if (sofar.length() != 0)
					a2++;
				sofar = new StringBuilder();
				continue;
			}

			if (s[i] == '_') {
				if (f) {
					if (sofar.length() != 0)
						a2++;
				}else
					a1 = Math.max(a1, sofar.length());
				sofar = new StringBuilder();
				continue;
			}
			sofar.append(s[i]);

		}
		
		a1 = Math.max(a1, sofar.length());
		
		System.out.println(a1 + " " + a2);

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
