package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva1197_Suspects {
	static int n, m;
	static ArrayList<Integer> adjList[];

	static int bfs() {
		boolean[] vis = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		int ans = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (vis[curr])
				continue;
			vis[curr] = true;
			ans++;
			for (int v : adjList[curr])
				if (!vis[v])
					q.add(v);

		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = in.nextInt();
			m = in.nextInt();
			if (n == 0 && m == 0)
				break;
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int k = in.nextInt();
				int[] a = new int[k];
				for (int i = 0; i < k; i++)
					a[i] = in.nextInt();
				for (int i = 0; i < k - 1; i++) {
					adjList[a[i]].add(a[i + 1]);
					adjList[a[i + 1]].add(a[i]);
				}
			}
			sb.append(bfs()).append("\n");
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
