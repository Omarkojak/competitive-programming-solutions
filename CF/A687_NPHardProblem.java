package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A687_NPHardProblem {
	static ArrayList<Integer> adjList[];
	static int color[];
	static boolean valid;

	public static void dfs(int node, int c) {
		color[node] = c;
		for (int u : adjList[node])
			if (color[u] == -1)
				dfs(u, 1 ^ c);
			else {
				if (color[u] == c)
					valid = false;
			}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		int m = in.nextInt();
		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		valid = true;
		color = new int[n];
		Arrays.fill(color, -1);
		for (int i = 0; i < n; i++)
			if (color[i] == -1)
				dfs(i, 0);

		if (!valid) {
			System.out.println(-1);
			return;
		}

		int b = 0;
		int w = 0;
		StringBuilder black = new StringBuilder();
		StringBuilder white = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				black.append((i + 1) + " ");
				b++;
			} else {
				white.append((i + 1) + " ");
				w++;
			}
		}
		System.out.println(b);
		System.out.println(black);
		System.out.println(w);
		System.out.println(white);

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
