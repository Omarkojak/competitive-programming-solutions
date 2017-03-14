package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva11352_CrazyKing {
	static int r, c, rb, cb;
	static char[][] grid;
	static boolean[][] attack;
	static int[] kx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] ky = { 0, 0, 1, -1, 1, -1, -1, 1 };
	static int[] zx = { 2, 2, -2, -2, -1, 1, -1, 1 };
	static int[] zy = { 1, -1, 1, -1, 2, 2, -2, -2 };
	static final int inf = (int) 1e8;

	public static int bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] dist = new int[r][c];
		for (int k = 0; k < r; k++)
			Arrays.fill(dist[k], inf);
		q.add(i);
		q.add(j);
		q.add(0);
		dist[i][j] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			int cost = q.poll();

			if (x == rb && y == cb)
				return dist[rb][cb];

			if (dist[x][y] < cost)
				continue;

			for (int k = 0; k < 8; k++) {
				int rnew = x + kx[k];
				int cnew = y + ky[k];
				if (valid(rnew, cnew) && dist[rnew][cnew] > cost + 1) {
					dist[rnew][cnew] = cost + 1;
					q.add(rnew);
					q.add(cnew);
					q.add(cost + 1);
				}
			}

		}
		return inf;

	}

	public static boolean valid(int x, int y) {
		if(x>=0 && x<r && y >=0 && y<c && grid[x][y] == 'B')
			return true;
		return x >= 0 && x < r && y >= 0 && y < c && !attack[x][y]
				&& grid[x][y] != 'Z';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			r = in.nextInt();
			c = in.nextInt();
			grid = new char[r][c];
			attack = new boolean[r][c];
			int ra = -1;
			int ca = -1;
			for (int i = 0; i < r; i++) {
				String s = in.nextLine();
				for (int j = 0; j < c; j++) {
					grid[i][j] = s.charAt(j);

					if (grid[i][j] == 'A') {
						ra = i;
						ca = j;
					}
					if (grid[i][j] == 'B') {
						rb = i;
						cb = j;
					}
					if (grid[i][j] == 'Z') {
						for (int k = 0; k < 8; k++) {
							int xnew = i + zx[k];
							int ynew = j + zy[k];
							if (xnew >= 0 && xnew < r && ynew >= 0 && ynew < c)
								attack[xnew][ynew] = true;
						}
					}
				}
			}
			int val = bfs(ra, ca);
			if(val == inf)
				out.println("King Peter, you can't go now!");
			else
				out.printf("Minimal possible length of a trip is %d\n", val);

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
