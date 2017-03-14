package cp5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10404_BachetsGame {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = in.nextLine();
			if (s == null || s.length() == 0)
				break;
			StringTokenizer ns = new StringTokenizer(s);
			int n = Integer.parseInt(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			int[] arr = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = Integer.parseInt(ns.nextToken());

			boolean[] winning = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				boolean res = false;
				for (int j = 0; j < m; j++)
					if (i - arr[j] >= 0 && !winning[i - arr[j]]) {
						res = true;
						break;
					}
				winning[i] = res;
			}
			sb.append(winning[n] ? "Stan wins\n" : "Ollie wins\n");
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
	}

}
