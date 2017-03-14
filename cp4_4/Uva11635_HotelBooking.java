package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva11635_HotelBooking {
	static int V, limit = 600;
	static boolean[] hotel;
	static ArrayList<Edge>[] adjList;
	static final int inf = (int) 1e9;

	public static int dijkstra() {
		int dist[][] = new int[V][limit + 5];
		for (int i = 0; i < V; i++)
			Arrays.fill(dist[i], inf);
		dist[0][0] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.node == V - 1)
				return curr.days;

			if (dist[curr.node][curr.time] < curr.days)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (curr.time + e.time <= limit
						&& dist[e.node][curr.time + e.time] > curr.days) {
					dist[e.node][curr.time + e.time] = curr.days;
					pq.add(new Edge(e.node, curr.time + e.time, curr.days));
				}
				if (hotel[curr.node])
					if (dist[e.node][e.time] > curr.days + 1) {
						dist[e.node][e.time] = curr.days + 1;
						pq.add(new Edge(e.node, e.time, curr.days + 1));
					}

			}
		}

		return inf;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = in.nextInt();
			if (V == 0)
				break;
			hotel = new boolean[V];
			int h = in.nextInt();
			for (int i = 0; i < h; i++)
				hotel[in.nextInt() - 1] = true;

			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			int m = in.nextInt();
			while (m-- > 0) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				int time = in.nextInt();
				adjList[u].add(new Edge(v, time, 0));
				adjList[v].add(new Edge(u, time, 0));
			}
			int val = dijkstra();

			sb.append((val == inf) ? -1 : val).append("\n");
		}
		System.out.print(sb);

	}

	static class Edge implements Comparable<Edge> {
		int node, time, days;

		Edge(int a, int b, int c) {
			node = a;
			time = b;
			days = c;
		}

		@Override
		public int compareTo(Edge o) {
			if (days != o.days)
				return days - o.days;

			if (time != o.time)
				return time - o.time;

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
