package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakingTheRecords {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() - 1;
		int cnt1 = 0, cnt2 = 0;
		int a = in.nextInt();
		int min = a, max = a;
		while (n-- > 0) {
			int x = in.nextInt();
			if (x < min) {
				cnt1++;
				min = x;
			}
			if (x > max) {
				cnt2++;
				max = x;
			}

		}
		System.out.println(cnt2 + " " + cnt1);
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
