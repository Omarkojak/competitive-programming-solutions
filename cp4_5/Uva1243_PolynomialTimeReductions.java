package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva1243_PolynomialTimeReductions {
	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[], SCC_num[];
	static boolean[] inSCC;
	static int acc;
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
			int x = 0;
			while (true) {
				x++;
				int v = stack.pop();
				inSCC[v] = true;
				SCC_num[v] = SCC;

				if (v == u)
					break;
			}
			if (x > 1)
				acc += x;
			SCC++;
		}
	}

	static int[][] adjMatrix;

	static void floyd() {
		for (int k = 0; k < SCC; k++)
			for (int i = 0; i < SCC; i++)
				for (int j = 0; j < SCC; j++)
					adjMatrix[i][j] |= (adjMatrix[i][k] & adjMatrix[k][j]);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		while (true) {
			V = in.nextInt();
			int m = in.nextInt();
			if (V == 0 && m == 0)
				break;
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
			acc = 0;
			dfs_num = new int[V];
			dfs_low = new int[V];
			SCC_num = new int[V];
			inSCC = new boolean[V];
			stack = new Stack<>();
			tarjanSCC();
			adjMatrix = new int[SCC][SCC];
			for (int i = 0; i < V; i++)
				for (int v : adjList[i])
					if (SCC_num[i] != SCC_num[v])
						adjMatrix[SCC_num[i]][SCC_num[v]] = 1;

			floyd();
			int ans = 0;
			for (int i = 0; i < SCC; i++) {
				for (int j = 0; j < SCC; j++) {
					if (i == j || adjMatrix[i][j] == 0)
						continue;
					boolean flag = false;
					for (int k = 0; k < SCC; k++)
						if (k != i && k != j && adjMatrix[i][k] == 1
								&& adjMatrix[k][j] == 1)
							flag = true;
					if (flag)
						adjMatrix[i][j] = 0;
					else
						ans++;
				}
			}
			out.printf("Case %d: %d\n", cse++, ans + acc);

		}
		out.flush();
		out.close();
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
