package OfficialContests.GCPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A {
	static int V, sites, max, tosite[], tonode[], intime[];
	static int totaltime, taxitime;
	static ArrayList<Edge>[] adjList;
	static final int inf = (int) 1e9;
	static int dis[][], dp[][];
	static int dp2[][][];

	public static int[] dijsktra(int source) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[V];
		Arrays.fill(dist, inf);
		pq.add(new Edge(source, 0));
		dist[source] = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (dist[curr.node] < curr.cost)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (dist[e.node] > curr.cost + e.cost) {
					dist[e.node] = curr.cost + e.cost;
					pq.add(new Edge(e.node, dist[e.node]));
				}
			}
		}

		return dist;
	}

	public static int solve(int node, int msk) {
		if (msk == (1 << (sites + 1)) - 1)
			return dis[node][0] + intime[tonode[node]];

		if (dp[node][msk] != -1)
			return dp[node][msk];

		int min = inf;
		for (int i = 1; i <= sites; i++) {
			if ((msk & 1 << i) == 0) {
				int nxt = solve(i, msk | 1 << i);
				min = Math.min(min, nxt + intime[tonode[node]]
						+ dis[i][tonode[node]]);
			}
		}
		return dp[node][msk] = min;
	}

	public static int solve2(int node, int msk, int taxis) {
		if (msk == (1 << (sites + 1)) - 1) {
			if (taxis == 0)
				return dis[node][0] + intime[tonode[node]];
			else
				return intime[tonode[node]] + taxitime;
		}

		if (dp2[taxis][node][msk] != -1)
			return dp2[taxis][node][msk];

		int min = inf;
		for (int i = 1; i <= sites; i++) {
			if ((msk & 1 << i) == 0) {
				int nxt = solve2(i, msk | 1 << i, taxis);
				min = Math.min(min, nxt + intime[tonode[node]]
						+ dis[i][tonode[node]]);
				if (taxis > 0) {
					nxt = solve2(i, msk | 1 << i, 0);
					min = Math.min(min, nxt + intime[tonode[node]] + taxitime);
				}

			}
		}
		return dp2[taxis][node][msk] = min;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		sites = in.nextInt();
		int m = in.nextInt();
		totaltime = in.nextInt();
		taxitime = in.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();
		intime = new int[V];
		tonode = new int[sites + 1];
		tosite = new int[V];
		Arrays.fill(tosite, -1);
		for (int i = 1; i <= sites; i++) {
			int node = in.nextInt();
			int t = in.nextInt();
			intime[node] = t;
			tonode[i] = node;
			tosite[node] = i;
		}
		while (m-- > 0) {
			int u = in.nextInt();
			int v = in.nextInt();
			int time = in.nextInt();
			adjList[u].add(new Edge(v, time));
			adjList[v].add(new Edge(u, time));
		}
		dis = new int[sites + 1][];
		for (int i = 1; i <= sites; i++)
			dis[i] = dijsktra(tonode[i]);
		dp = new int[sites + 5][(1 << (sites + 5))];
		for (int i = 0; i < sites + 5; i++)
			Arrays.fill(dp[i], -1);
		int min = 0;
		if (tosite[0] != -1)
			min = solve(1, 3);
		else
			min = solve(0, 1);

		if (min <= totaltime) {
			System.out.println("possible without taxi");
			return;
		}
		dp2 = new int[2][sites + 5][(1 << (sites + 5))];
		for (int i = 0; i < sites + 5; i++) {
			Arrays.fill(dp2[0][i], -1);
			Arrays.fill(dp2[1][i], -1);
		}

		min = 0;
		if (tosite[0] != -1)
			min = solve2(1, 3, 1);
		else
			min = solve2(0, 1, 1);
		if (min <= totaltime)
			System.out.println("possible with taxi");
		else
			System.out.println("impossible");

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
