package OfficialContests.HIAST16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {
	static ArrayList<Edge> adjList[];
	static final int inf = (int) 1e9;
	static int n;

	public static Pair dijkstra(int x, int y) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Pair[] dist = new Pair[n];
		for (int i = 0; i < n; i++)
			dist[i] = new Pair(inf, inf);

		dist[x] = new Pair(0, 0);
		pq.add(new Edge(x, 0, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (curr.node == y)
				return dist[y];

			if (dist[curr.node].tw < curr.tw)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.tw > 0) {
					if (dist[e.node].tw > e.tw + curr.tw
							|| (dist[e.node].tw == e.tw + curr.tw && dist[e.node].tc > curr.tc)) {
						dist[e.node].tw = e.tw + curr.tw;
						dist[e.node].tc = curr.tc;
						pq.add(new Edge(e.node, dist[e.node].tw,
								dist[e.node].tc));
					}
				}

				if (e.tc > 0) {
					if (dist[e.node].tw > curr.tw
							|| (dist[e.node].tw == curr.tw && dist[e.node].tc > curr.tc
									+ e.tc)) {
						dist[e.node].tw = curr.tw;
						dist[e.node].tc = curr.tc + e.tc;
						pq.add(new Edge(e.node, dist[e.node].tw,
								dist[e.node].tc));
					}

				}
			}

		}
		return new Pair(inf, inf);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			int m = in.nextInt();
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				int cost = in.nextInt();
				int k = in.nextInt();
				if (k == 1) {
					adjList[u].add(new Edge(v, cost, 0));
					adjList[v].add(new Edge(u, cost, 0));
				} else {
					adjList[u].add(new Edge(v, 0, cost));
					adjList[v].add(new Edge(u, 0, cost));
				}
			}
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			Pair res = dijkstra(x, y);
			if(res.tc == inf || res.tw == inf)
				sb.append("-1\n");
			else
				sb.append(res.tw + " " + (res.tc + res.tw)).append("\n");
		}
		System.out.print(sb);
	}

	static class Pair {
		int tw, tc;

		Pair(int a, int b) {
			tw = a;
			tc = b;
		}
	}

	static class Edge implements Comparable<Edge> {
		int node, tw, tc;

		Edge(int a, int b, int c) {
			node = a;
			tw = b;
			tc = c;
		}

		public int compareTo(Edge o) {
			if (tw != o.tw)
				return tw - o.tw;
			if (tc != o.tc)
				return tc - o.tc;
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
	}
}
