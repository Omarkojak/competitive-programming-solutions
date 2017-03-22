package OfficialContests.BAPC2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class J {
	static int n, m, p1, p2, V;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] grid;
	static int dist1[], dist2[], dist3[];
	static ArrayList<Edge>[] adjList;
	static final int inf = (int) 1e8;

	static void dijkstramulti() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist1 = new int[V];
		Arrays.fill(dist1, inf);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
					if (grid[i][j] != '*') {
						int node = conv(i, j);
						dist1[node] = 0;
						if (grid[i][j] == '#')
							dist1[node]++;
						pq.add(new Edge(node, dist1[node]));
					}

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist1[curr.node] > curr.c)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.c + curr.c < dist1[e.node]) {
					dist1[e.node] = e.c + curr.c;
					pq.add(new Edge(e.node, dist1[e.node]));
				}
			}
		}
	}

	static void dijkstra1(int source) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0));
		dist2 = new int[V];
		Arrays.fill(dist2, inf);
		dist2[source] = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist2[curr.node] > curr.c)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.c + curr.c < dist2[e.node]) {
					dist2[e.node] = e.c + curr.c;
					pq.add(new Edge(e.node, dist2[e.node]));
				}
			}

		}
	}

	static void dijkstra2(int source) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0));
		dist3 = new int[V];
		Arrays.fill(dist3, inf);
		dist3[source] = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist3[curr.node] > curr.c)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.c + curr.c < dist3[e.node]) {
					dist3[e.node] = e.c + curr.c;
					pq.add(new Edge(e.node, dist3[e.node]));
				}
			}

		}
	}

	public static int conv(int i, int j) {
		return i * m + j;
	}

	public static boolean valid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '*';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			grid = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < m; j++)
					grid[i][j] = s.charAt(j);
			}
			V = m * n;
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			p1 = -1;
			p2 = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == '*')
						continue;
					if (grid[i][j] == '$') {
						if (p1 == -1)
							p1 = conv(i, j);
						else
							p2 = conv(i, j);
					}

					for (int k = 0; k < 4; k++) {
						if (valid(i + dx[k], j + dy[k])) {
							int u = conv(i, j);
							int v = conv(i + dx[k], j + dy[k]);
							int cost = 0;
							if (grid[i + dx[k]][j + dy[k]] == '#')
								cost++;

							adjList[u].add(new Edge(v, cost));
						}
					}
				}
			}
			dijkstramulti();
			dijkstra1(p1);
			dijkstra2(p2);
			int min = inf;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == '*')
						continue;
					int node = conv(i, j);
					int cost = dist2[node] + dist3[node] + dist1[node]
							- ((grid[i][j] == '#') ? 2 : 0);// 2 because the cost at dist1[node] will contain dist from p1 and from p2
															// and from the outside part
					min = Math.min(min, cost);
				}
			}
			sb.append(min).append("\n");

		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node, c;

		Edge(int a, int b) {
			node = a;
			c = b;
		}

		public int compareTo(Edge o) {
			if (c != o.c)
				return c - o.c;
			return node - o.node;
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
