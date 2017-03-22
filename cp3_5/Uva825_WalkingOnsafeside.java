package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva825_WalkingOnsafeside {
	static int rows, cols;
	static boolean[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int inf = 1000000;

	public static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < rows && c < cols;

	}

	public static int evaluate(int r, int c) {
		if (!valid(r, c))
			return 0;

		if (visited[r][c])
			return dp[r][c];

		if (map[r][c])
			return 0;

		if (r == rows - 1 && c == cols - 1)
			return 1;

		visited[r][c] = true;

		int dr1 = evaluate(r - 1, c);
		int dr2 = evaluate(r, c + 1);
		int dr3 = evaluate(r + 1, c);

		return dp[r][c] = dr1 + dr2 + dr3;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int x, y, tokens;
		while (t-- > 0) {
			rows = in.nextInt();
			cols = in.nextInt();
			map = new boolean[rows][cols];
			dp = new int[rows][cols];
			visited = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				StringTokenizer ns = new StringTokenizer(in.nextLine());
				tokens = ns.countTokens();
				if (tokens > 1) {
					x = Integer.parseInt(ns.nextToken()) - 1;
					tokens--;
					for (int k = 0; k < tokens; k++) {
						y = Integer.parseInt(ns.nextToken()) - 1;
						map[x][y] = true;
					}
				}
			}
			if (t == 0)
				System.out.println(evaluate(0, 0));
			else
				System.out.println(evaluate(0, 0) + "\n");

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
