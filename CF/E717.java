package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E717 {
	static PrintWriter out;
	static ArrayList<Integer>[] adjList;
	static int color[]; // 1 black 0 pink it should be all black

	public static void dfs(int u, int p) {
		out.print((u + 1) + " ");
		color[u] ^= 1;

		int sze = adjList[u].size();
		for (int i = 0; i < sze; i++) {
			int v = adjList[u].get(i);
			if (v == p)
				continue;
			dfs(v, u);
			if (i == sze - 1 && u == 0 && color[u] == 1 && color[v] == 1)
				return;

			color[u] ^= 1;
			out.print((u + 1) + " ");

			if (color[v] == 0) {
				color[v] ^= 1;
				out.print((v + 1) + " ");
				if (i == sze - 1 && u == 0 && color[u] == 1 && color[v] == 1)
					return;
				out.print((u + 1) + " ");
				color[u] ^= 1;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int n = in.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		color = new int[n];
		for (int i = 0; i < n; i++)
			color[i] = (in.nextInt() == 1) ? 1 : 0;
		color[0] ^= 1;
		for (int i = 0; i < n - 1; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		dfs(0, -1);
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
	}
}
