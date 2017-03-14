package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva274_CatAndMouse {
	static int V;
	static ArrayList<Edge>[] adjList;
	static boolean reachc[], reachm[];
	static boolean[] vis;

	static void dfs(int u, char c) {
		vis[u] = true;
		if (c == 'M')
			reachm[u] = true;
		else
			reachc[u] = true;
		for (Edge e : adjList[u])
			if (!vis[e.node] && c == e.type)
				dfs(e.node, c);

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			int cathome = in.nextInt() - 1;
			int mousehome = in.nextInt() - 1;
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			while (true) {
				int u = in.nextInt();
				int v = in.nextInt();
				if (u == -1)
					break;
				adjList[u - 1].add(new Edge(v - 1, 'C'));
			}

			while (!in.nxtEmpty()) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				adjList[u].add(new Edge(v, 'M'));
			}
			reachm = new boolean[V];
			reachc = new boolean[V];
			vis = new boolean[V];
			dfs(mousehome, 'M');
			vis = new boolean[V];
			dfs(cathome, 'C');

			boolean f1 = false;
			for (int i = 0; i < V; i++)
				if (reachm[i] && reachc[i])
					f1 = true;

			boolean f2 = false;
			for (Edge u : adjList[mousehome])
				if (!reachc[u.node] && u.type == 'M' && !reachc[mousehome])
					f2 = true;
			
			sb.append((f1 ? "Y" : "N") + " " + (f2 ? "Y" : "N")).append("\n");
			if (t != 0)
				sb.append("\n");
		}

		System.out.print(sb);
	}

	static class Edge {
		int node;
		char type;

		Edge(int a, char c) {
			node = a;
			type = c;
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
