package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva11312_FlippingFrustration {   //TLE
	static int r, l, n;
	static final int inf = (int) 1e9;

	public static int bfs(int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] dist = new int[n + 5];
		boolean []used = new boolean[n+5];
		Arrays.fill(dist, inf);
		dist[1] = 0;
		used[1] = true;
		q.add(1);
		while (!q.isEmpty()) {
			int curr = q.poll();

			if (used[target])
				return dist[target];

			if (curr + l <= n && !used[curr + l]) {
				dist[curr + l] = dist[curr] + 1;
				used[curr + l] = true;
				q.add(curr + l);
			}

			if (curr - r > 0 && !used[curr - r]) {
				dist[curr - r] = dist[curr] + 1;
				used[curr] = true;
				q.add(curr - r);
			}

		}
		return inf;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			r = in.nextInt();
			l = in.nextInt();
			int target = in.nextInt();
			int val = bfs(target);
			if (val == inf)
				sb.append("uh-oh!\n");
			else
				sb.append(val).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int page;
		int cost;

		Edge(int a, int b) {
			page = a;
			cost = b;
		}

		@Override
		public int compareTo(Edge o) {
			if (cost != o.cost)
				return cost - o.cost;
			return page - o.page;
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
