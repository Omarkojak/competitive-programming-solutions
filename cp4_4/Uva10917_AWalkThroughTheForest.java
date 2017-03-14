package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10917_AWalkThroughTheForest {
	static int V;
	static ArrayList<Edge>[] adjList;
	static final long inf = (long) 1e18;
	static long dist[], dp[];
	

	public static void dijkstra() {
		dist = new long[V];
		Arrays.fill(dist, inf);
		dist[1] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.node] < curr.dist)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.dist + curr.dist < dist[e.node]) {
					dist[e.node] = e.dist + curr.dist;
					pq.add(new Edge(e.node, dist[e.node]));
				}
			}
		}
	}
	
	//dist array contains the shortest distance from any node to home ->1
	public static long dfs(int node)
	{
		if(node == 1)
			return 1;
		
		if(dp[node] != -1)
			return dp[node];
		
		long ans = 0;
		for(Edge e:adjList[node])
			if(dist[node] > dist[e.node])
				ans+=dfs(e.node);
		return dp[node] = ans;
	}
	
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = in.nextInt();
			if (V == 0)
				break;
			int m = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				long dist = in.nextLong();
				adjList[u].add(new Edge(v, dist));
				adjList[v].add(new Edge(u, dist));
			}
			dijkstra();
			dp = new long[V];
			Arrays.fill(dp, -1);
		//	System.err.println(Arrays.toString(dist));
			sb.append(dfs(0)).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node;
		long dist;

		Edge(int a, long b) {
			node = a;
			dist = b;
		}

		public int compareTo(Edge e) {
			if (dist < e.dist)
				return -1;
			if (dist > e.dist)
				return 1;
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
