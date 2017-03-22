package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B765 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		boolean f = true;
		boolean[] passed = new boolean[26];
		char curr = 'a';
		for (int i = 0; i < s.length; i++) {
			if (s[i] != curr && !passed[s[i] - 'a'])
				f = false;
			if (s[i] == curr)
				curr++;
			passed[s[i] - 'a'] = true;
		}
		System.out.println(f ? "YES" : "NO");
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
