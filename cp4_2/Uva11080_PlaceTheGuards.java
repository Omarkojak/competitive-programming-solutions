package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11080_PlaceTheGuards {
	static ArrayList<Integer>[] adjList;
	static int[] color;
	static boolean notbi;
	static int o, z;

	static void dfs(int u, int c) {
		if (color[u] == 0)
			z++;
		else
			o++;
		for (int v : adjList[u]) {
			if (color[v] != -1) {
				if (color[v] == color[u])
					notbi = true;
			} else {
				color[v] = 1 ^ c;
				dfs(v, 1 ^ c);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int v = in.nextInt();
			int e = in.nextInt();
			adjList = new ArrayList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new ArrayList<Integer>();

			while (e-- > 0) {
				int u1 = in.nextInt();
				int u2 = in.nextInt();
				adjList[u1].add(u2);
				adjList[u2].add(u1);
			}
			color = new int[v];
			Arrays.fill(color, -1);
			notbi = false;
			int ans = 0;
			for (int i = 0; i < v; i++) {
				if (color[i] == -1) {
					o = 0;
					z = 0;
					color[i] = 0;
					dfs(i, 0);
					ans += Math.max(1, Math.min(o, z));
				}
			}

			if (notbi)
				System.out.println("-1");
			else
				System.out.println(ans);
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
