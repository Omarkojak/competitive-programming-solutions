package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva11693_SpeedyEscape {
	static int V;
	static ArrayList<Edge>[] adjList;
	static ArrayList<Integer> exits;
	static final double inf = 1e9;
	static final double EPS = 1e-15;

	public static double[] dijkstra(int source, double[] limit, double speed) {
		double dist[] = new double[V];
		Arrays.fill(dist, inf);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[source] = 0;
		pq.add(new Edge(source, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (dist[curr.node] + EPS < curr.cost)
				continue;

			for (Edge e : adjList[curr.node]) {
				double currt = curr.cost + e.cost / speed;
				if (dist[e.node] > currt + EPS && currt + EPS < limit[e.node]) {
					dist[e.node] = currt;
					pq.add(new Edge(e.node, currt));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			int m = in.nextInt();
			int e = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				double dis = (in.nextInt() * 1.0);
				adjList[u].add(new Edge(v, dis));
				adjList[v].add(new Edge(u, dis));
			}
			exits = new ArrayList<>();
			while (e-- > 0)
				exits.add(in.nextInt() - 1);
			int b = in.nextInt() - 1;
			int p = in.nextInt() - 1;
			double[] limit = new double[V];
			Arrays.fill(limit, inf);
			limit = dijkstra(p, limit, 160.0);

			double low = 0.0;
			double high = 1e7;
			double ans = inf;
			int cnt = 100;
			while (cnt-- > 0) {
				double mid = (low + high) / 2.0;
				double[] dist = dijkstra(b, limit, mid);
				boolean flag = false;
				for (int u : exits)
					if (dist[u] + EPS < inf)
						flag = true;
				if (flag)
					ans = high = mid;
				else
					low = mid;
			}

			if (ans == inf)
				sb.append("IMPOSSIBLE").append("\n");
			else
				sb.append(ans).append("\n");

		}

		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node;
		double cost;

		Edge(int a, double b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			if (Math.abs(cost - e.cost) > EPS)
				return cost > e.cost ? 1 : -1;
			return node - e.node;
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
