package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B707 {
	static ArrayList<Edge> adjList[];
	static final int inf = (int) 1e18;
	static int V;
	static int n;
	static long dist[];
	static int[] storages;

	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist = new long[n];
		Arrays.fill(dist, inf);
		for(int i=0;i<storages.length;i++)
		{
			pq.add(new Edge(storages[i], 0));
			dist[storages[i]] = 0;
		}
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.node] > curr.c)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.c + curr.c < dist[e.node]) {
					dist[e.node] = e.c + curr.c;
					pq.add(new Edge(e.node, dist[e.node]));
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			long c = in.nextLong();
			adjList[u].add(new Edge(v, c));
			adjList[v].add(new Edge(u, c));
		}
		storages = new int[k];
		boolean []stor = new boolean [n];
		for (int i = 0; i < k; i++)
		{
			storages[i] = in.nextInt() - 1;
			stor[storages[i]] = true;
		}
		if (k == 0) {
			System.out.println(-1);
			return;
		}
		dijkstra();
		long min = inf;
		for(int i=0;i<n;i++)
			if(!stor[i])
				min = Math.min(min, dist[i]);
		if(min == inf)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static class Edge implements Comparable<Edge> {
		int node;
		long c;

		Edge(int a, long b) {
			node = a;
			c = b;
		}

		public int compareTo(Edge o) {
			if (c < o.c)
				return -1;
			if (c > o.c)
				return 1;

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
