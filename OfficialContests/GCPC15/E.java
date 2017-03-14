package OfficialContests.GCPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {
	static int V;
	static long []dp;
	static ArrayList<Edge>[] adjList;
	static final int inf = (int) 1e9;
	static ArrayList<Integer> parent[];

	static void dijkstra() {
		int []dist = new int[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(dist, inf);
		dist[0] = 0;
		pq.add(new Edge(0, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.node] < curr.cost)
				continue;
			for (Edge e : adjList[curr.node]) {
				if (dist[e.node] > curr.cost + e.cost) {
					dist[e.node] = curr.cost + e.cost;
					pq.add(new Edge(e.node, dist[e.node]));
					parent[e.node] = new ArrayList<>();
					parent[e.node].add(curr.node);
				} else if (dist[e.node] == curr.cost + e.cost)
					parent[e.node].add(curr.node);
			}
		}
	}
	
	public static long dfs2(int u) {
		if (u == 0)
			return 1l;
		if (dp[u] != -1)
			return dp[u];
		if (parent[u] == null)
			return dp[u] = 0l;

		long cnt = 0;
		for (int v : parent[u]){
			cnt += dfs2(v);
			if(cnt > 2)
			    cnt = 2;
		}

		return dp[u] = cnt;
	}

	public static boolean dfs(int u) {
		if(parent[u] == null || u == 0 || parent[u].size() == 0)
			return false;

		if(parent[u].size() > 1)
			return true;
		
		return dfs(parent[u].get(0));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		adjList = new ArrayList[V];
		parent = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
			parent[i] = new ArrayList<>();
		}
		int[] path = new int[k];
		for (int i = 0; i < k; i++)
			path[i] = in.nextInt() - 1;
		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			int cost = in.nextInt();
			adjList[u].add(new Edge(v, cost));
			adjList[v].add(new Edge(u, cost));
		}
		dijkstra();
		if (dfs(V - 1))
			System.out.println("yes");
		else
			System.out.println("no");
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
	}
}