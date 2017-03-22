package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A725 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] s = in.nextLine().toCharArray();
		int[] prefix = new int[s.length + 1];
		int cnt = 0;
		for (int i = 1; i <= s.length; i++) {
			if (s[i - 1] == '<')
				prefix[i] = -1;
			else
				prefix[i] = 1;
			prefix[i] += prefix[i - 1];

		}
		int[] suffix = new int[s.length + 2];
		for (int i = s.length; i > 0; i--) {
			if (s[i - 1] == '<')
				suffix[i] = -1;
			else
				suffix[i] = 1;
			suffix[i] += suffix[i + 1];
		}

		for (int i = 1; i <= n; i++) {
			if (s[i - 1] == '<' && i + prefix[i] <= 0)
				cnt++;
			else if (s[i - 1] == '>' && i + suffix[i] > n)
				cnt++;

			// if(i + prefix[i] <= 0 || i + suffix[i] > n)
			// cnt++;
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
