package cp4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10842_TrafficFlow {
	static ArrayList<Edge>[] adjList;
	static int V;

	static long prim() {
		long min = (long) 1e18;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (visited[cur.to])
				continue;
			visited[cur.to] = true;
			if(cur.cost != 0)
				min = Math.min(min, cur.cost);
			for (Edge nxt : adjList[cur.to])
				if (!visited[nxt.to])
					pq.add(nxt);
		}

		return min;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), cse = 1;
		while (t-- > 0) {
			V = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			int m = in.nextInt();
			while (m-- > 0) {
				int u = in.nextInt();
				int v = in.nextInt();
				long cost = in.nextLong();
				adjList[u].add(new Edge(v, cost));
				adjList[v].add(new Edge(u, cost));
			}
			out.printf("Case #%d: %d\n", cse++, prim());
		}
		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int to;
		long cost;

		Edge(int a, long b) {
			to = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			if(cost > e.cost)
				return -1;
			if(cost < e.cost)
				return 1;
			return to - e.to;
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
