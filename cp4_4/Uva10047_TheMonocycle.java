package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10047_TheMonocycle {
	static int r, c;
	static char[][] grid;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static final int inf = (int) 1e9;

	public static int dijkstra(int begx, int begy, int endx, int endy) {
		int[][][][] dist = new int[4][5][r][c];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < r; k++)
					Arrays.fill(dist[i][j][k], inf);
		dist[0][0][begx][begy] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(begx, begy, 0, 0, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.x == endx && curr.y == endy && curr.color == 0)
				return curr.cost;
			if (dist[curr.dir][curr.color][curr.x][curr.y] < curr.cost)
				continue;

			int nxtcol = (curr.color + 1) % 5;
			for (int i = 0; i < 4; i++) {
				int cost = calc(i, curr.dir);
				int xnew = curr.x + dx[i];
				int ynew = curr.y + dy[i];
				if(valid(xnew, ynew))
					if(dist[i][nxtcol][xnew][ynew] > curr.cost + cost + 1)
						pq.add(new Edge(xnew, ynew, i, nxtcol, (dist[i][nxtcol][xnew][ynew] = curr.cost + cost + 1)));
			}

		}

		return inf;
	}

	public static boolean valid(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c && grid[i][j] != '#';
	}

	public static int calc(int d1, int d2) {
		int ret = Math.abs(d1 - d2);
		ret = Math.min(ret, Math.min(d1, d2) + 4 - Math.max(d1, d2));
		return ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		while (true) {
			r = in.nextInt();
			c = in.nextInt();
			if (r == 0 && c == 0)
				break;
			if (cse > 1)
				out.println();

			grid = new char[r][c];
			int begx = -1, begy = -1, endx = -1, endy = -1;
			for (int i = 0; i < r; i++) {
				String s = in.nextLine();
				for (int j = 0; j < c; j++) {
					grid[i][j] = s.charAt(j);
					if (grid[i][j] == 'S') {
						begx = i;
						begy = j;
					}

					if (grid[i][j] == 'T') {
						endx = i;
						endy = j;
					}

				}
			}
			int val = dijkstra(begx, begy, endx, endy);
			out.printf("Case #%d\n", cse++);

			if (val == inf)
				out.println("destination not reachable");
			else
				out.printf("minimum time = %d sec\n", val);

		}
		out.flush();
		out.close();

	}

	static class Edge implements Comparable<Edge> {
		int x, y, cost, dir, color;

		Edge(int a, int b, int d, int col, int c) {
			x = a;
			y = b;
			dir = d;
			cost = c;
			color = col;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
			if (dir != e.dir)
				return dir;
			if (x != e.x)
				return x - e.x;
			if (y != e.y)
				return y - e.y;
			return color - e.color;
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}

}
