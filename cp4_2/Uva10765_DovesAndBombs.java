package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva10765_DovesAndBombs {
	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints;
	static ArrayList<Output> as;

	static void findArtPointsAndBridges() {

		for (int i = 0; i < V; ++i)
			if (dfs_num[i] == 0) {
				root = i;
				rootChildren = 0;
				dfs(i);
				if (rootChildren <= 1) {
					artPoints[i] = false;
					as.get(i).pigeons--;
				}
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
				if (dfs_low[v] >= dfs_num[u]) {
					as.get(u).pigeons++;
					artPoints[u] = true;
				}

				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			} else if (parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean start = false;
		while (true) {
			V = in.nextInt();
			int m = in.nextInt();
			if (start)
				sb.append("\n");
			if (V == 0 && m == 0)
				break;

			start = true;
			adjList = new ArrayList[V];
			as = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
				as.add(new Output(1, i));
			}
			while (true) {
				int u = in.nextInt();
				int v = in.nextInt();
				if (u == -1 && v == -1)
					break;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			counter = 0;
			dfs_num = new int[V];
			dfs_low = new int[V];
			parent = new int[V];
			artPoints = new boolean[V];
			Arrays.fill(parent, -1);

			findArtPointsAndBridges();
			Collections.sort(as);
			for (Output p : as) {
				if (m == 0)
					break;
				sb.append(p.node + " " + p.pigeons).append("\n");
				m--;
			}
		}
		System.out.print(sb);
	}

	static class Output implements Comparable<Output> {
		int pigeons, node;

		Output(int a, int b) {
			pigeons = a;
			node = b;
		}

		@Override
		public int compareTo(Output o) {
			if (pigeons != o.pigeons)
				return o.pigeons - pigeons;
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
