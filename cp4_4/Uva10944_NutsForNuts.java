package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10944_NutsForNuts {
	static int r, c, rx, ry, nuts;
	static ArrayList<Integer> pos;
	static final int inf = (int) 1e9;
	static int dp[][][], dist[][][];
	static int[][] distosource;
	static int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static int solve(int x, int y, int msk) {
		if (Integer.bitCount(msk) == nuts)
			return distosource[x][y];

		if (dp[x][y][msk] != -1)
			return dp[x][y][msk];

		int min = inf;
		for (int i = 0, j = 0; i < nuts; i++, j += 2)
			if ((msk & (1 << i)) == 0) {
				int newr = pos.get(j);
				int newc = pos.get(j + 1);
				min = Math.min(min,
						dist[i][x][y] + solve(newr, newc, (msk | (1 << i))));
			}

		return dp[x][y][msk] = min;
	}

	static int[][] dijkstra(int x, int y) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[][] dist = new int[r][c];
		for (int i = 0; i < r; i++)
			Arrays.fill(dist[i], inf);
		dist[x][y] = 0;
		pq.add(new Edge(x, y, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.r][curr.c] < curr.cost)
				continue;
			for (int k = 0; k < 8; k++) {
				int rnew = curr.r + dx[k];
				int cnew = curr.c + dy[k];
				if (valid(rnew, cnew)) {
					if (dist[rnew][cnew] > curr.cost + 1) {
						dist[rnew][cnew] = curr.cost + 1;
						pq.add(new Edge(rnew, cnew, dist[rnew][cnew]));
					}
				}
			}

		}
		return dist;
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (in.br.ready()) {
			r = in.nextInt();
			c = in.nextInt();
			pos = new ArrayList<Integer>();
			nuts = 0;
			for (int i = 0; i < r; i++) {
				String s = in.nextLine();
				for (int j = 0; j < c; j++) {
					char k = s.charAt(j);
					if (k == 'L') {
						rx = i;
						ry = j;
					}
					if (k == '#') {
						nuts++;
						pos.add(i);
						pos.add(j);
					}
				}
			}

			dist = new int[nuts][r][c];
			for (int i = 0, j = 0; i < nuts; i++, j += 2)
				dist[i] = dijkstra(pos.get(j), pos.get(j + 1));
			distosource = dijkstra(rx, ry);

			dp = new int[r][c][(1 << nuts) + 1];
			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					Arrays.fill(dp[i][j], -1);
			sb.append(solve(rx, ry, 0)).append("\n");

		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int r, c, cost;

		Edge(int a, int b, int d) {
			r = a;
			c = b;
			cost = d;
		}

		public int compareTo(Edge o) {
			if (cost != o.cost)
				return cost - o.cost;
			if (r != o.r)
				return r - o.r;

			return c - o.r;
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
	}
}
