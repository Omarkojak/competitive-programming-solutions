package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11906_KnightInAWarGrid {
	static boolean water[][];
	static boolean vis[][];
	static boolean check[][];
	static int m, n, r, c, odd, even;

	static void dfs(int x, int y) {
		int[] movesr = { n, n, -n, -n, m, -m, m, -m };
		int[] movesc = { m, -m, m, -m, n, n, -n, -n };
		int cnt = 0;
		vis[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int xn = x + movesr[i];
			int yn = y + movesc[i];
			if (valid(xn, yn) && !check[xn][yn]) {
				cnt++;
				check[xn][yn] = true;
			}
		}
		for (int i = 0; i < 8; i++) {
			int xn = x + movesr[i];
			int yn = y + movesc[i];
			if (valid(xn, yn))
				check[xn][yn] = false;
		}

		if (x == 0 && y == 0 && cnt == 0)
			even++;
		else if (cnt > 0) {
			if (cnt % 2 == 0)
				even++;
			else
				odd++;
		}

		for (int i = 0; i < 8; i++) {
			int xn = x + movesr[i];
			int yn = y + movesc[i];
			if (valid(xn, yn) && !vis[xn][yn])
				dfs(xn, yn);
		}
	}

	static boolean valid(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c && !water[x][y];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int cse = 1;
		while (t-- > 0) {
			r = in.nextInt();
			c = in.nextInt();
			n = in.nextInt();
			m = in.nextInt();
			even = 0;
			odd = 0;
			water = new boolean[r][c];
			vis = new boolean[r][c];
			check = new boolean[r][c];
			int w = in.nextInt();
			while (w-- > 0)
				water[in.nextInt()][in.nextInt()] = true;
			dfs(0, 0);

			System.out.printf("Case %d: %d %d\n", cse++, even, odd);
		}
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
