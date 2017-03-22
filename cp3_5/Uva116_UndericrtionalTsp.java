package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva116_UndericrtionalTsp {
	static int rows;
	static int cols;
	static int[][] map;
	static int[][] dp;
	static String[][] path;
	static boolean[][] visited;

	public static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	public static boolean notsim(int a1, int a2, int a3) {
		return a1 != a2 && a2 != a3 && a1 != a3;
	}

	public static int evaluate(int r, int c) {

		if (c == cols)
			return 0;

		if (r < 0)
			r = rows - 1;

		if (r == rows)
			r = 0;

		if (visited[r][c])
			return dp[r][c];

		visited[r][c] = true;

		int dr1 = map[r][c] + evaluate(r + 1, c + 1);
		int dr2 = map[r][c] + evaluate(r, c + 1);
		int dr3 = map[r][c] + evaluate(r - 1, c + 1);

		dp[r][c] = min(dr1, dr2, dr3);
		if (c + 1 != cols) {
			if (r == 0) {
				if (dp[r][c] == dr2)
					path[r][c] += (r + 1) + " " + path[r][c + 1];
				else {
					if (dp[r][c] == dr1) {
						int w = (r + 1 == rows) ? 0 : r + 1;
						path[r][c] += w + 1 + " " + path[w][c + 1];
					} else {
						int w = ((r - 1) < 0) ? rows - 1 : (r - 1);
						path[r][c] += (w + 1) + " " + path[w][c + 1];
					}
				}
			} else {
				if (r == rows - 1) {
					if (dp[r][c] == dr1) {
						int w = (r + 1 == rows) ? 0 : r + 1;
						path[r][c] += w + 1 + " " + path[w][c + 1];
					} else {
						if (dp[r][c] == dr3) {
							int w = ((r - 1) < 0) ? rows - 1 : (r - 1);
							path[r][c] += (w + 1) + " " + path[w][c + 1];
						} else {
							path[r][c] += (r + 1) + " " + path[r][c + 1];
						}
					}
				} else {
					if (dp[r][c] == dr3) {
						int w = ((r - 1) < 0) ? rows - 1 : (r - 1);
						path[r][c] += (w + 1) + " " + path[w][c + 1];
					} else {
						if (dp[r][c] == dr2)
							path[r][c] += (r + 1) + " " + path[r][c + 1];
						else {
							int w = (r + 1 == rows) ? 0 : r + 1;
							path[r][c] += w + 1 + " " + path[w][c + 1];
						}
					}
				}
			}
		}

		return dp[r][c];
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		String s, result;
		String line = in.nextLine();
		while (line != null && line.length() != 0) {
			s = "";
			result = "";
			StringTokenizer ns = new StringTokenizer(line);

			rows = Integer.parseInt(ns.nextToken());
			// out.println(rows);
			cols = Integer.parseInt(ns.nextToken());
			// out.println(cols);
			visited = new boolean[rows][cols];
			dp = new int[rows][cols];
			map = new int[rows][cols];
			path = new String[rows][cols];

			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++) {
					map[i][j] = in.nextInt();
					path[i][j] = "";
				}
			int min = evaluate(0, 0);
			result = "1 " + path[0][0];
			for (int i = 1; i < rows; i++) {
				int x = evaluate(i, 0);
				if (x < min) {
					min = x;
					result = (i + 1) + " " + path[i][0];
				}

			}
			s = result.substring(0, result.length() - 1);
			System.out.println(s);
			System.out.println(min);
			line = in.nextLine();
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
