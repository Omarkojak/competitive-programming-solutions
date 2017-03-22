package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva11953_Battleships {
	static char[][] maze;
	static boolean[][] vis;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static boolean found;

	public static boolean valid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n && maze[r][c] != '.';
	}

	public static void ff(int r, int c) {
		vis[r][c] = true;
		maze[r][c] = '.';
		for (int i = 0; i < 4; i++) {
			int rn = r + dx[i];
			int cn = c + dy[i];
			if (valid(rn, cn) && !vis[rn][cn])
				ff(rn, cn);
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int cnt = 1;
		while (t-- > 0) {
			n = in.nextInt();
			maze = new char[n][n];
			vis = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String k = in.next();
				for (int j = 0; j < n; j++)
					maze[i][j] = k.charAt(j);
			}
			int res = 0;
			found = false;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (maze[i][j] == 'x') {
						res++;
						ff(i, j);
					}
			out.printf("Case %d: %d\n", cnt++, res);

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
