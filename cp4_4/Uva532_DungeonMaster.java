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

public class Uva532_DungeonMaster {
	static int l, r, c, le, re, ce;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static char[][][] grid;
	static final int inf = (int) 1e8;

	public static int bfs(int x, int y, int z) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][][] dist = new int[l][r][c];
		for (int i = 0; i < l; i++)
			for (int j = 0; j < r; j++)
				Arrays.fill(dist[i][j], inf);
		q.add(x);
		q.add(y);
		q.add(z);
		q.add(0);
		dist[z][x][y] = 0;
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			int k = q.poll();
			int cost = q.poll();

			if (dist[k][i][j] < cost)
				continue;
			if (le == k && re == i && ce == j)
				return dist[k][i][j];

			for (int w = 0; w < 6; w++) {
				int inew = i + dx[w];
				int jnew = j + dy[w];
				int knew = k + dz[w];
				if (valid(inew, jnew, knew)
						&& dist[knew][inew][jnew] > cost + 1) {
					dist[knew][inew][jnew] = cost + 1;
					q.add(inew);
					q.add(jnew);
					q.add(knew);
					q.add(cost + 1);
				}
			}

		}
		return inf;
	}

	public static boolean valid(int x, int y, int z) {
		return x >= 0 && x < r && y >= 0 && y < c && z >= 0 && z < l
				&& grid[z][x][y] != '#';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			l = in.nextInt();
			r = in.nextInt();
			c = in.nextInt();
			if (l == 0 && r == 0 && c == 0)
				break;
			grid = new char[l][r][c];
			int ls = -1, rs = -1, cs = -1;
			for (int k = 0; k < l; k++) {
				for (int i = 0; i < r; i++) {
					String s = in.nextLine();
					for (int j = 0; j < c; j++) {
						grid[k][i][j] = s.charAt(j);
						if (grid[k][i][j] == 'S') {
							ls = k;
							rs = i;
							cs = j;
						}

						if (grid[k][i][j] == 'E') {
							le = k;
							re = i;
							ce = j;
						}
					}
				}
				in.nextLine();
			}
			int val = bfs(rs, cs, ls);
			if(val == inf)
				out.println("Trapped!");
			else
				out.printf("Escaped in %d minute(s).\n", val);

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
