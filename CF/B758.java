package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B758 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int n = s.length;
		int cntr = 0, cntb = 0, cnty = 0, cntg = 0;
		char[] symbols = new char[4];
		for (int i = 0; i < n; i++)
			if (s[i] != '!')
				symbols[i % 4] = s[i];

		TreeSet<Character> ts = new TreeSet<>();
		ts.add('B');
		ts.add('G');
		ts.add('R');
		ts.add('Y');

		for (int i = 0; i < 4; i++)
			ts.remove(symbols[i]);

		for (int i = 0; i < 4; i++)
			if (symbols[i] == ' ')
				symbols[i] = ts.pollFirst();

		for (int i = 0; i < n; i++) {
			if (s[i] == '!')
				switch (symbols[i % 4]) {
				case 'R':
					cntr++;
					break;
				case 'G':
					cntg++;
					break;
				case 'B':
					cntb++;
					break;
				case 'Y':
					cnty++;
				}
		}
		System.out.println(cntr + " " + cntb + " " + cnty + " " + cntg);

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
