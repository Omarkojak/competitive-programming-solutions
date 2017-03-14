package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B716 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int n = s.length;
		boolean valid = false;
		int idx = -1;
		TreeSet<Character> letters = new TreeSet<>();
		for (int i = 0; i <= n - 26; i++) {
			TreeSet<Character> ts = new TreeSet<>();
			boolean ok = true;
			int marks = 0;
			for (int j = i, k = 0; k < 26; j++, k++) {
				if (ts.contains(s[j])) {
					ok = false;
					break;
				}
				if (s[j] == '?')
					marks++;
				else
					ts.add(s[j]);
			}
			if (ok && ts.size() + marks == 26 && !valid) {
				valid = true;
				idx = i;
				letters.addAll(ts);
			}
		}
		if (!valid) {
			System.out.println(-1);
			return;
		}
		char c = 'A';
		for (int i = idx, j = 0; j < 26; j++, i++) {
			if (s[i] == '?') {
				while (letters.contains(c))
					c += 1;
				s[i] = c;
				c += 1;
			}
		}
		for(int i=0;i<n;i++)
			if(s[i] == '?')
				s[i] = 'A';
		for (char k : s)
			System.out.print(k);
		System.out.println();
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
