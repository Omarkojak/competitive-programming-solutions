package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10004_Bicoloring {
	static int V;
	static int color[];
	static ArrayList<Integer> adjList[];

	public static boolean dfs(int node, int col) {
		boolean flag = true;
		color[node] = col;
		for (int v : adjList[node]) {
			if (color[v] == -1)
				flag = (flag && dfs(v, col ^ 1));
			else if (col == color[v])
				flag = false;
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		V = in.nextInt();
		while (V != 0) {
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			color = new int[V];
			Arrays.fill(color, -1);

			int e = in.nextInt();
			while (e-- > 0) {
				int u1 = in.nextInt();
				int u2 = in.nextInt();
				adjList[u1].add(u2);
				adjList[u2].add(u1);
			}
			sb.append(dfs(0, 0) ? "BICOLORABLE." : "NOT BICOLORABLE.").append(
					"\n");

			V = in.nextInt();
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
