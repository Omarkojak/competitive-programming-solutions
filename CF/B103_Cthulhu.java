package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B103_Cthulhu {
	static int n;
	static boolean[] vis, adjMatrix[];

	static void dfs(int node) {
		vis[node] = true;
		for (int i = 0; i < n; i++)
			if (adjMatrix[node][i] && !vis[i])
				dfs(i);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		adjMatrix = new boolean[n][n];
		int m1 = m;
		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adjMatrix[u][v] = true;
			adjMatrix[v][u] = true;
		}
		vis = new boolean[n];
		dfs(0);
		if (m1 != n) {
			System.out.println("NO");
			return;
		}
		boolean flag = true;
		for (int i = 0; i < n; i++)
			if (!vis[i])
				flag = false;
		if(flag)
			System.out.println("FHTAGN!");
		else
			System.out.println("NO");
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
