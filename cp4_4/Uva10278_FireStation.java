package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10278_FireStation {
	static int V;
	static ArrayList<Edge> adjList[];
	static boolean[] station;
	static final int inf = (int) 1e9;

	public static int dijkstra(int node) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[V];
		Arrays.fill(dist, inf);
		for (int i = 0; i < V; i++)
			if (station[i]) {
				pq.add(new Edge(i, 0));
				dist[i] = 0;
			}
		dist[node] = 0;
		pq.add(new Edge(node, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.node] < curr.cost)
				continue;
			for (Edge e : adjList[curr.node])
				if (dist[e.node] > curr.cost + e.cost)
					pq.add(new Edge(e.node, (dist[e.node] = curr.cost + e.cost)));

		}
		int max = 0;
		for(int i=0;i<V;i++)
			max = Math.max(max, dist[i]);
		return max;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int f = in.nextInt();
			V = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			station = new boolean[V];
			while (f-- > 0)
				station[in.nextInt() - 1] = true;

			while (true) {
				String s = in.nextLine();
				if (s == null || s.length() == 0)
					break;
				StringTokenizer ns = new StringTokenizer(s);
				int u = Integer.parseInt(ns.nextToken()) - 1;
				int v = Integer.parseInt(ns.nextToken()) - 1;
				int cost = Integer.parseInt(ns.nextToken());
				adjList[u].add(new Edge(v, cost));
				adjList[v].add(new Edge(u, cost));
			}
			int min = inf;
			int node = -1;

			for (int i = 0; i < V; i++) {
				int maxmin = dijkstra(i);
				//System.err.println(i + " " + maxmin);
				if (maxmin < min) {
					min = maxmin;
					node = i + 1;
				}
			}
			sb.append(node).append("\n");
			if(t != 0)
				sb.append("\n");

		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node, cost;

		Edge(int a, int b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}

}
