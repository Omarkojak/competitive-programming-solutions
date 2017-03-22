package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva315_Network {
	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int v, counter, root, rootChildren;
	static boolean[] artPoints;

	static void findArtPointsAndBridges() {
		for (int i = 0; i < v; ++i)
			if (dfs_num[i] == 0) {
				root = i;
				rootChildren = 0;
				dfs(i);
				if (rootChildren <= 1)
					artPoints[i] = false;
			}
	}

	static void dfs(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		for (int v : adjList[u])
			if (dfs_num[v] == 0) {
				parent[v] = u;
				if (u == root)
					++rootChildren;
				dfs(v);
				if (dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			} else if (parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = bf.readLine();
		while (!s1.equals("0")) {
			v = Integer.parseInt(s1);
			adjList = new ArrayList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new ArrayList<Integer>();
			dfs_low = new int[v];
			dfs_num = new int[v];
			parent = new int[v];
			artPoints = new boolean[v];
			counter = 0;
			String k = bf.readLine();
			while (!k.equals("0")) {
				StringTokenizer ns = new StringTokenizer(k);
				int or = Integer.parseInt(ns.nextToken()) - 1;
				while (ns.hasMoreTokens()) {
					int x = Integer.parseInt(ns.nextToken()) - 1;
					adjList[or].add(x);
					adjList[x].add(or);
				}
				k = bf.readLine();
			}
			findArtPointsAndBridges();
			int res = 0;
			for (boolean q : artPoints)
				if (q)
					res++;
			sb.append(res + "\n");
			s1 = bf.readLine();
		}
		System.out.print(sb);
	}

}
