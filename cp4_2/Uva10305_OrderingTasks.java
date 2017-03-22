package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva10305_OrderingTasks {
	static boolean[] vis;
	static ArrayList<Integer>[] adjList;
	static Stack<Integer> st;

	public static void topologicalsorting(int u) {
		vis[u] = true;

		for (int v : adjList[u])
			if (!vis[v])
				topologicalsorting(v);

		st.push(u);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (n != 0 || m != 0) {
			adjList = new ArrayList[n];
			vis = new boolean[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; i++)
				adjList[in.nextInt() - 1].add(in.nextInt() - 1);
			st = new Stack<Integer>();
			for (int i = 0; i < n; i++)
				if (!vis[i])
					topologicalsorting(i);
			String k = "" + (st.pop() + 1);
			while (!st.isEmpty())
				k += " " + (st.pop() + 1);
			sb.append(k + "\n");

			n = in.nextInt();
			m = in.nextInt();
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
