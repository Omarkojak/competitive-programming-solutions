package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11475ExtendToPalindrome {

	public static int longestSuffixPalindrome(char[] s) {
		int n = s.length * 2 + 1;
		char[] t = new char[n];
		for (int i = 0; i < s.length; i++)
			t[s.length - i - 1] = t[s.length + i + 1] = s[i];
		int[] pi = new int[n];
		for (int i = 1, j = 0; i < n; ++i) {
			while (j > 0 && t[i] != t[j])
				j = pi[j - 1];
			if (t[i] == t[j])
				j++;
			pi[i] = j;
		}
		return pi[n - 1];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (in.ready()) {
			char[] s = in.nextLine().toCharArray();

			int end = s.length - longestSuffixPalindrome(s);
			sb.append(s);
			while (end-- > 0)
				sb.append(s[end]);

			sb.append("\n");
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
