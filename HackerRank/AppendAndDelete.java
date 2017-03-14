package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppendAndDelete {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		char[] t = in.nextLine().toCharArray();
		int k = in.nextInt();
		if (s.length >= t.length) {
			char[] temp = new char[t.length];
			for (int i = 0; i < t.length; i++)
				temp[i] = s[i];
			k -= s.length - t.length;
			s = temp;
			if (k / 2 < s.length && k % 2 != 0) {
				System.out.println("No");
				return;
			}
			int i = s.length - k / 2;
			i = Math.max(i, 0);
			for (int j = i; j < s.length; j++)
				s[j] = t[j];
		} else {
			boolean f = false;
			int i = s.length - 1;
			if (t.length - s.length == k) {
				i = s.length;
				f = true;
			} else {
				while (i >= 0) {
					if (s.length - i + t.length - i == k) {
						f = true;
						break;
					}
					i--;
				}
			}
			if (!f) {
				System.out.println("No");
				return;
			}
			char[] temp = new char[t.length];
			for (int j = 0; j < t.length; j++) {
				if (j < i)
					temp[j] = s[j];
				else
					temp[j] = t[j];
			}
			s = temp;
		}
		if (compare(s, t))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static boolean compare(char[] s1, char[] s2) {
		for (int i = 0; i < s1.length; i++)
			if (s1[i] != s2[i])
				return false;
		return true;
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
