package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NHAY {
	static ArrayList<Integer> as;

	static void match(String s1, String s2) {
		StringBuilder sb = new StringBuilder(s1);
		sb.append("#");
		sb.append(s2);
		char[] s = sb.toString().toCharArray();
		int n = s.length, pi[] = new int[n];
		for (int i = 1, j = 0; i < n; ++i) {
			while (j > 0 && s[i] != s[j])
				j = pi[j - 1];
			if (s[i] == s[j])
				++j;
			pi[i] = j;
		}

		for (int i = s1.length() + 1; i < n; i++) {
			if (pi[i] == s1.length()) {
				int start = i - (s1.length() - 1);
				as.add(start - (s1.length() + 1));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = in.nextLine();
			if (s == null || s.length() == 0)
				break;
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			as = new ArrayList<>();
			match(s1, s2);
			for (int k : as)
				sb.append(k).append("\n");
			if (as.size() == 0)
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}

}
