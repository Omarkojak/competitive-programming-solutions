package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int j = in.nextInt();
		long k = in.nextLong();
		int cnt = 0;
		for (int w = i; w <= j; w++) {
			if (Math.abs(w - rev(w)) % k == 0)
				cnt++;
		}
		System.out.println(cnt);
	}

	static int rev(int w) {
		StringBuilder sb = new StringBuilder();
		sb.append(w);
		sb.reverse();
		return Integer.parseInt(sb.toString());
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
