package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10505_MontescovsCapuleto {
	static ArrayList<Integer>[] adjList;
	static int[] color;
	static boolean flag;
	static int o, z;

	static boolean bipartitieCheck(int u) {
		if (color[u] == 1)
			o++;
		else
			z++;
		for (int v : adjList[u])
			if (color[v] == -1) {
				color[v] = 1 ^ color[u];
				bipartitieCheck(v);

			} else if (color[v] == color[u])
				flag = false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			color = new int[n];
			Arrays.fill(color, -1);
			for (int i = 0; i < n; i++) {
				int k = in.nextInt();
				while (k-- > 0) {
					int u = in.nextInt() - 1;
					if (u >= n || u < 0)
						continue;
					adjList[i].add(u);
					adjList[u].add(i);
				}
			}
			int res = 0;
			for (int i = 0; i < n; i++)
				if (color[i] == -1) {
					flag = true;
					o = 0;
					z = 0;
					color[i] = 0;
					bipartitieCheck(i);
					if (!flag) {
						o = 0;
						z = 0;
					}
					res += Math.max(o, z);

				}
			sb.append(res + "\n");
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
