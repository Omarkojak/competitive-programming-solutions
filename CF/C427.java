package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class C427 {
	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static long cost[], sum, ways;
	static final long MOD = (long) 1e9 + 7;

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
			long min = Long.MAX_VALUE, cnt = 0;
			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				if (cost[v] < min) {
					min = cost[v];
					cnt = 1;
				} else if (cost[v] == min)
					cnt++;
				if (v == u)
					break;
			}
			sum += min;
			ways = (ways * cnt) % MOD;
			SCC++;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		cost = new long[V];
		for (int i = 0; i < V; i++)
			cost[i] = in.nextLong();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();
		int m = in.nextInt();
		while (m-- > 0)
			adjList[in.nextInt() - 1].add(in.nextInt() - 1);
		counter = 0;
		SCC = 0;
		dfs_num = new int[V];
		dfs_low = new int[V];
		inSCC = new boolean[V];
		stack = new Stack<>();
		sum = 0;
		ways = 1;
		tarjanSCC();
		System.out.println(sum + " " + ways);

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
