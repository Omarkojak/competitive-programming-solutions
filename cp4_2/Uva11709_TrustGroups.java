package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva11709_TrustGroups {
	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;

	static void tarjanSCC() {
		for (int i = 0; i < V; ++i)
			if (dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0)
				tarjanSCC(v);
			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {

			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				if (v == u)
					break;
			}
			SCC++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = bf.readLine();
		while (!s.equals("0 0")) {
			TreeMap<String, Integer> mp = new TreeMap<String, Integer>();
			int i = 0;
			StringTokenizer ns = new StringTokenizer(s);
			V = Integer.parseInt(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			for (int k = 0; k < V; k++)
				mp.put(bf.readLine(), i++);
			adjList = new ArrayList[V];
			dfs_num = new int[V];
			dfs_low = new int[V];
			inSCC = new boolean[V];
			stack = new Stack<Integer>();
			counter = 0;
			SCC = 0;
			for (int k = 0; k < V; k++)
				adjList[k] = new ArrayList<Integer>();
			for (int k = 0; k < m; k++) {
				int u1 = mp.get(bf.readLine());
				int u2 = mp.get(bf.readLine());
				adjList[u1].add(u2);
			}
			tarjanSCC();
			sb.append(SCC + "\n");

			s = bf.readLine();
		}
		System.out.print(sb);
	}

}
