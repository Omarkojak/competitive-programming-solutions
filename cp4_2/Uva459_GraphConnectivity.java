package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva459_GraphConnectivity {
	static boolean[] vis;
	static ArrayList<Integer>[] adjList;

	public static void dfs(int u) {
		vis[u] = true;
		for (int v : adjList[u])
			if (!vis[v])
				dfs(v);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (t-- > 0) {
			char c = bf.readLine().charAt(0);
			int size = (c - 'A') + 1;
			vis = new boolean[size];
			adjList = new ArrayList[size];
			for (int i = 0; i < size; i++)
				adjList[i] = new ArrayList<Integer>();
			String s = bf.readLine();
			while (s != null && (!(s.equals("")))) {
				adjList[s.charAt(0) - 'A'].add(s.charAt(1) - 'A');
				adjList[s.charAt(1) - 'A'].add(s.charAt(0) - 'A');
				s = bf.readLine();
			}
			int cnt = 0;
			for (int i = 0; i < size; i++)
				if (!vis[i]) {
					cnt++;
					dfs(i);
				}
			System.out.println(cnt);
			if (t != 0)
				System.out.println();
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
