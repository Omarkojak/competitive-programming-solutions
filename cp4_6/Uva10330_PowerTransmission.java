package cp4_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10330_PowerTransmission {
	static final int INF = (int) 1e9;
	static int V, s, t, res[][], ptr[], dist[];
	static ArrayList<Integer>[] adjList;

	static void addEdge(int u, int v, int w) {
		adjList[u].add(v);
		adjList[v].add(u);
		res[u][v] = w;
	}

	static int Vin(int x) {
		return x << 1;
	}

	static int Vout(int x) {
		return 1 + (x << 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = bf.readLine();
		while (in != null && in.length() != 0) {
			int n = Integer.parseInt(in);
			V = (n << 1) + 2;
			res = new int[V][V];
			adjList = new ArrayList[V];
			int maxcost = 0;
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<Integer>();
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int c = Integer.parseInt(ns.nextToken());
				addEdge(Vin(i), Vout(i), c);
				maxcost = Math.max(maxcost, c);
			}
			int m = Integer.parseInt(bf.readLine());
			while (m-- > 0) {
				ns = new StringTokenizer(bf.readLine());
				int u1 = Integer.parseInt(ns.nextToken()) - 1;
				int u2 = Integer.parseInt(ns.nextToken()) - 1;
				int cost = Integer.parseInt(ns.nextToken());
				addEdge(Vout(u1), Vin(u2), cost);
				maxcost = Math.max(maxcost, cost);
			}
			s = V - 2;
			t = V - 1;
			ns = new StringTokenizer(bf.readLine());
			int b = Integer.parseInt(ns.nextToken());
			int d = Integer.parseInt(ns.nextToken());
			ns = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= b + d; i++) {
				int u = Integer.parseInt(ns.nextToken()) - 1;
				if (i <= b)
					addEdge(s, Vin(u), maxcost * 2);
				else
					addEdge(Vout(u), t, maxcost * 2);
			}
			System.out.println(dinic());
			in = bf.readLine();
		}
	}

	static int dinic() {

		int mf = 0;
		while (bfs()) {
			ptr = new int[V];
			int f;
			while ((f = dfs(s, INF)) != 0)
				mf += f;
		}

		return mf;
	}

	static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		dist = new int[V];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.remove();
			if (u == t)
				return true;
			for (int i = 0; i < adjList[u].size(); ++i) {
				int v = adjList[u].get(i);
				if (dist[v] == -1 && res[u][v] > 0) {
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
		return false;
	}

	static int dfs(int u, int flow) {
		if (u == t)
			return flow;
		for (int i = ptr[u]; i < adjList[u].size(); i = ++ptr[u]) {
			int v = adjList[u].get(i);
			if (dist[v] == dist[u] + 1 && res[u][v] > 0) {
				int f = dfs(v, Math.min(flow, res[u][v]));
				if (f > 0) {
					res[u][v] -= f;
					res[v][u] += f;
					return f;

				}
			}
		}
		return 0;
	}

}
