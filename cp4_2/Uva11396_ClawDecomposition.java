package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11396_ClawDecomposition {
	static int[] color;
	static ArrayList<Integer>[] adjList;

	public static boolean dfs(int u) {
		for (int v : adjList[u]) {
			if (color[v] == -1) {
				color[v] = 1 ^ color[u];
				if (!dfs(v))
					return false;
			} else {
				if (color[v] == color[u])
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int v = in.nextInt();
		while (v != 0) {
			adjList = new ArrayList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new ArrayList<Integer>();
			int u1 = in.nextInt();
			int u2 = in.nextInt();
			while (u1 != 0 || u2 != 0) {
				adjList[u1 - 1].add(u2 - 1);
				adjList[u2 - 1].add(u1 - 1);
				u1 = in.nextInt();
				u2 = in.nextInt();
			}
			color = new int[v];
			Arrays.fill(color, -1);
			boolean flag = true;
			for (int i = 0; i < v; i++)
				if (color[i] == -1) {
					color[i] = 0;
					flag = dfs(i);
					if (!flag)
						break;
				}
			sb.append(flag ? "YES\n" : "NO\n");
			v = in.nextInt();
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
