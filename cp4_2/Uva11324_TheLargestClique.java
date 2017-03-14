package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva11324_TheLargestClique {
	static ArrayList<Integer>[] adjList, DAG;
	static int V, counter, SCC, dfs_num[], dfs_low[], SCC_size[], largest[], SCC_num[];
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
			if (SCC_num[v] == -1)
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			while (true) {
				int v = stack.pop();
				SCC_size[SCC]++;
				SCC_num[v] = SCC;
				if (v == u)
					break;
			}
			SCC++;
		}

	}

	public static int dfs(int u) {
		if(largest[u] != 0)
			return largest[u];
		int ret = 0;
		for(int v:DAG[u])
			ret = Math.max(ret, dfs(v));
		return largest[u] = ret + SCC_size[u];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			int m = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				adjList[u].add(v);
			}
			counter = 0;
			SCC = 0;
			dfs_num = new int[V];
			dfs_low = new int[V];
			SCC_size = new int[V];
			SCC_num = new int[V];
			Arrays.fill(SCC_num, -1);
			stack = new Stack<>();
			tarjanSCC();

			largest = new int[SCC];
			DAG = new ArrayList[SCC];
			for (int i = 0; i < SCC; i++)
				DAG[i] = new ArrayList<>();
			for (int u = 0; u < V; u++)
				for (int v : adjList[u])
					if (SCC_num[u] != SCC_num[v])
						DAG[SCC_num[u]].add(SCC_num[v]);

			int max = 0;
			for (int u = 0; u < SCC; ++u)
				max = Math.max(max, dfs(u));
			sb.append(max).append("\n");
		}
		System.out.print(sb);
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
