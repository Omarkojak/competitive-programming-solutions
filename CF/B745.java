package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B745 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] grid = new char[n][m];
		int mnx = Integer.MAX_VALUE, mny = Integer.MAX_VALUE;
		int mxx = Integer.MIN_VALUE, mxy = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			grid[i] = in.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'X') {
					mnx = Math.min(mnx, i);
					mny = Math.min(mny, j);

					mxx = Math.max(mxx, i);
					mxy = Math.max(mxy, j);

				}
			}
		}
		boolean f = true;
		for (int i = mnx; i <= mxx; i++)
			for (int j = mny; j <= mxy; j++)
				if (grid[i][j] != 'X')
					f = false;
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
