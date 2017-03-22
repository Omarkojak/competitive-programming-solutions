package cp5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva11489_IntegerGame {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), cse = 1;
		while (t-- > 0) {
			char[] s = in.nextLine().toCharArray();
			int cnt[] = new int[10];
			int sum = 0;
			for (int i = 0; i < s.length; i++) {
				cnt[s[i] - '0']++;
				sum += s[i] - '0';
			}
			boolean f = false;
			for (int i = 0; i <= 9; i++)
				if (cnt[i] > 0 && (sum - i) % 3 == 0) {
					cnt[i]--;
					f = true;
					break;
				}
			int multiples = cnt[3] + cnt[6] + cnt[9];
			out.printf("Case %d: %s\n", cse++, (!f || multiples % 2 == 1) ? "T"
					: "S");
		}
		out.flush();
		out.close();
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
