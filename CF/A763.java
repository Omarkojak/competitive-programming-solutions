package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A763 {
	static ArrayList<Integer>[] adjList;
	static int parent[];
	static boolean valid[], ok;
	static int color[];

	static void dfs(int u, int p) {
		parent[u] = p;
		for (int v : adjList[u]) {
			if (p != v) {
				dfs(v, u);
				if (color[v] != color[u]) {
					if (!valid[v]){
						if (p != -1 && color[u] != color[p])
							ok = false;
					}else
						valid[u] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		valid = new boolean[n];
		parent = new int[n];
		color = new int[n];
		Arrays.fill(valid, true);
		Arrays.fill(parent, -1);
		ok = true;
		for (int i = 0; i < n - 1; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		for (int i = 0; i < n; i++)
			color[i] = in.nextInt();
		dfs(0, -1);
		int cnt = 0;
		int vertex = -1;
		for (int i = 0; i < n; i++)
			if (!valid[i]) {
				cnt++;
				vertex = i + 1;
			}
		if (!ok || cnt >= 2)
			System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(vertex == -1? 1:vertex);
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
