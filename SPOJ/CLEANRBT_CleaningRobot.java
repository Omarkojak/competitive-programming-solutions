package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CLEANRBT_CleaningRobot {
	static char[][] grid;
	static int r, c, dirty, rx, ry;
	static ArrayList<Integer> dplaces; // i = r / i+1 = c / for the dirty places
	static int[][][] dist, dp;
	static final int inf = (int) 1e8;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int solve(int x, int y, int msk) {
		if (Integer.bitCount(msk) == dirty)
			return 0;
		
		if(dp[x][y][msk] != -1)
			return dp[x][y][msk];
		
		int min = inf;
		for (int i = 0, j = 0; i < dirty; i++, j += 2) {
			if((msk & (1<<i)) == 0)
				min = Math.min(min, dist[i][x][y] + solve(dplaces.get(j), dplaces.get(j+1), (msk | 1<<i)));
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
			for (int k = 0; k < 4; k++) {
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
		return i >= 0 && i < r && j >= 0 && j < c && grid[i][j] != 'x';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			c = in.nextInt();
			r = in.nextInt();
			if (r == 0 && c == 0)
				break;
			grid = new char[r][c];
			dplaces = new ArrayList<>();
			dirty = 0;
			for (int i = 0; i < r; i++) {
				String s = in.nextLine();
				for (int j = 0; j < c; j++) {
					grid[i][j] = s.charAt(j);
					if (grid[i][j] == 'o') {
						rx = i;
						ry = j;
					}
					if (grid[i][j] == '*') {
						dplaces.add(i);
						dplaces.add(j);
						dirty++;
					}
				}
			}
			
			dist = new int[dirty][r][c];
			for (int i = 0, j = 0; j < dirty; i += 2, j++)
				dist[j] = dijkstra(dplaces.get(i), dplaces.get(i + 1));
			
			dp = new int [r][c][(1<<dirty) + 1];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					Arrays.fill(dp[i][j], -1);
		
			
			int val = solve(rx, ry, 0);
			if(val != inf)
				sb.append(val).append("\n");
			else
				sb.append(-1).append("\n");
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
